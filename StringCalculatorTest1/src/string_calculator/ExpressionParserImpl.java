package string_calculator;

import java.util.LinkedList;
import java.util.List;

public class ExpressionParserImpl implements ExpressionParser {
    @Override
    public List<String> parseExpression(String validatedString) {
        List<String> expressionElements = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();
        String stringWithoutFirstOperand = null;
        for (int i = 1; i < validatedString.length(); i++) {
            if ('"' != validatedString.charAt(i) || ('"' == validatedString.charAt(i) && validatedString.length() > i + 1 && '"' == validatedString.charAt(i + 1))) {
                stringBuilder.append(validatedString.charAt(i));
            } else {
                stringWithoutFirstOperand = validatedString.substring(i + 1).trim();
                break;
            }
        }
        String firstOperand = stringBuilder.toString();
        if (stringWithoutFirstOperand != null && stringWithoutFirstOperand.length() >= 2) {
            String operation = stringWithoutFirstOperand.substring(0, 1);
            String secondOperand = stringWithoutFirstOperand.substring(1).trim();
            expressionElements.add(firstOperand);
            expressionElements.add(operation);
            expressionElements.add(secondOperand);
        } else {
            throw new CalculatorException("Некорректная запись выражения");
        }
        return expressionElements;
    }

}
