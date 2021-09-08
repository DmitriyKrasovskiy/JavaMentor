package string_calculator;

import java.util.Set;

public interface CommandExecutor {

    String execute(String expression);

    Set<String> getAvailableIdentifies();
}
