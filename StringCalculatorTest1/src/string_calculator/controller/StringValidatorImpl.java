package string_calculator.controller;

import string_calculator.CalculatorException;
import string_calculator.CommandExecutor;

public class StringValidatorImpl implements StringValidator {

    private CommandExecutor commandExecutor;

    public StringValidatorImpl(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

    @Override
    public String validate(String input) {
        String validatedString = input.trim();
        if (!validatedString.startsWith("\"")) {
            throw new CalculatorException("Некорректное выражение");
        }
        if (commandExecutor.getAvailableIdentifies().stream().noneMatch(validatedString::contains)) {
            throw new CalculatorException("Непподерживаемая операция");
        }
        if (validatedString.length() < 4) {
            throw new CalculatorException("Некорректная длина выражения");
        }
        return validatedString;
    }
}
