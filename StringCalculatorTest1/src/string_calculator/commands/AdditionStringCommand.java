package string_calculator.commands;

import string_calculator.CalculatorException;

public class AdditionStringCommand implements CalculatorCommand {

    @Override
    public String execute(String firstOperand, String secondOperand) {
        if(secondOperand.startsWith("\"")&&secondOperand.endsWith("\"")){
            return firstOperand + secondOperand.substring(1,secondOperand.length()-1);
        }
       throw new CalculatorException("Некорректная запись второго операнда");
    }

    @Override
    public String getIdentifier() {
        return "+";
    }
}
