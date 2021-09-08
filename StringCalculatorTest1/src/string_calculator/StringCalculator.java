package string_calculator;

import string_calculator.commands.*;
import string_calculator.controller.StringValidator;
import string_calculator.controller.StringValidatorImpl;

import java.util.Scanner;

public class StringCalculator {

    private static Scanner scanner = new Scanner(System.in);
    private CommandExecutor commandExecutor;
    private StringValidator stringValidator;
    private OutputService outputService;

    public StringCalculator() {
        init();
    }

    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator();
        System.out.println("Введите выражение:");
        String input = scanner.nextLine();
        System.out.println(stringCalculator.calculate(input));
    }

    private void init() {
        ExpressionParser expressionParser = new ExpressionParserImpl();
        CalculatorCommand addition = new AdditionStringCommand();
        CalculatorCommand division = new DivisionStringCommand();
        CalculatorCommand multiplication = new MultiplicationStringCommand();
        CalculatorCommand subtraction = new SubtractionStringCommand();
        this.commandExecutor = new CommandExecutorImpl(expressionParser, addition, division, multiplication, subtraction);
        this.stringValidator = new StringValidatorImpl(commandExecutor);
        this.outputService = new OutputServiceImpl();
    }

    private String calculate(String input) {
        String validatedString = stringValidator.validate(input);
        String result = commandExecutor.execute(validatedString);
        return outputService.prepareStringForOutput(result);
    }
}
