package string_calculator.commands;

import string_calculator.CalculatorException;

public class DivisionStringCommand implements CalculatorCommand {

    @Override
    public String execute(String firstOperand, String secondOperand) {
        try {
            Integer divisor = Integer.valueOf(secondOperand);
            if (divisor >= 1 && divisor <= 10) {
                int finalLength = firstOperand.length() / divisor;
                return firstOperand.substring(0, finalLength);
            } else {
                throw new CalculatorException("Элемент " + secondOperand + " не удовлетворяет условию задачи");
            }
        } catch (NumberFormatException e) {
            throw new CalculatorException("Элемент " + secondOperand + " не удовлетворяет условию задачи");
        }
    }

    @Override
    public String getIdentifier() {
        return "/";
    }
}
