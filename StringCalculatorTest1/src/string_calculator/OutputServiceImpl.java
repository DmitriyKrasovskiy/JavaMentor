package string_calculator;

public class OutputServiceImpl implements OutputService {

    @Override
    public String prepareStringForOutput(String result) {
        if (result.length() > 40) {
            return result.substring(0, 40) + "...";
        } else {
            return result;
        }
    }
}