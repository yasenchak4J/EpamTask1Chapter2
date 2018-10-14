package by.yasenchak.task1.validator;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorImpl implements Validator {

    private final String REGEX = "^[\\s]*[\\d]+\\.[\\d]+[\\s]+[\\d]+\\.[\\d]+[\\s]+[\\d]+\\.[\\d]+[\\s]+[\\d]+\\.[\\d]+[\\s]+[\\d]+\\.[\\d]+[\\s]+[\\d]+\\.[\\d]+[\\s]*$";

    @Override
    public boolean isValid(String line) {
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(line);
        return m.find();
    }

}
