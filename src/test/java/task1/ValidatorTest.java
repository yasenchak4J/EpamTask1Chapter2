package task1;

import by.yasenchak.task1.validator.ValidatorImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ValidatorTest {
    private String inputString;

    @BeforeClass
    public void beforeValidatorTest(){
        inputString = "3.0 10.2 5.2 3.0 2.0 1.0";
    }

    @Test
    public void testIsValidMethod(){
        ValidatorImpl validator = new ValidatorImpl();
        Assert.assertEquals(validator.isValid(inputString), true);
    }
}
