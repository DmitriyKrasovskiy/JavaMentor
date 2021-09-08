package string_calculator.commands;

public interface CalculatorCommand {

    String execute(String firstOperand, String secondOperand);

    String getIdentifier();
}
