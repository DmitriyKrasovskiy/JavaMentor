package string_calculator;

import string_calculator.commands.CalculatorCommand;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CommandExecutorImpl implements CommandExecutor {

    private Map<String, CalculatorCommand> commandMap;
    private ExpressionParser expressionParser;


    public CommandExecutorImpl(ExpressionParser expressionParser, CalculatorCommand... commands) {
        this.expressionParser = expressionParser;
        initCommandMap(commands);
    }

    @Override
    public String execute(String expression) {
        List<String> dividedExpression = expressionParser.parseExpression(expression);
        String operation = dividedExpression.get(1);
        CalculatorCommand command = commandMap.get(operation);
        if (command != null) {
            StringBuilder result = new StringBuilder();
            result.append("\"");
            result.append(command.execute(dividedExpression.get(0), dividedExpression.get(2)));
            result.append("\"");
            return result.toString();
        } else {
            throw new CalculatorException("Непподерживаемая операция");
        }
    }

    @Override
    public Set<String> getAvailableIdentifies() {
        return commandMap.keySet();
    }

    private void initCommandMap(CalculatorCommand[] commands) {
        this.commandMap = new HashMap<>();
        for (CalculatorCommand command : commands) {
            commandMap.put(command.getIdentifier(), command);
        }
    }
}
