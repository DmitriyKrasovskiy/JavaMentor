package string_calculator.commands;

import string_calculator.CalculatorException;

public class MultiplicationStringCommand implements CalculatorCommand {


    @Override
    public String execute(String firstOperand, String secondOperand) {
        try {
            Integer multiplier = Integer.valueOf(secondOperand);
            if (multiplier >= 1 && multiplier <= 10) {
                StringBuilder stringBuilder = new StringBuilder(firstOperand);
                int i = multiplier;
                while (i > 1) {
                    stringBuilder.append(firstOperand);
                    i--;
                }
                return stringBuilder.toString();
            } else {
                throw new CalculatorException("Элемент " + multiplier + " не удовлетворяет условию задачи");
            }

        } catch (NumberFormatException e) {
            throw new CalculatorException("Элемент " + secondOperand + " не удовлетворяет условию задачи");
        }
    }

    @Override
    public String getIdentifier() {
        return "*";
    }
}
