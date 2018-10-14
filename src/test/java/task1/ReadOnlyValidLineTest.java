package task1;

import by.yasenchak.task1.exception.ReadException;
import by.yasenchak.task1.reader.ReaderImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ReadOnlyValidLineTest {

    List<String>  expectedList;

    @BeforeClass
    public void beforeReadOnlyValidTest(){
        expectedList = new ArrayList<>();
        expectedList.add("3.0 10.2 5.2 3.0 2.0 1.0");
    }

    @Test
    public void testReadOnlyValidLinesMethod() throws ReadException {
        ReaderImpl reader = new ReaderImpl();
        Assert.assertEquals(reader.readOnlyValid("resource/data.txt"), expectedList);
    }
}
