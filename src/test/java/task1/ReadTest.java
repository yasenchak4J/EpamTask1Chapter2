package task1;

import by.yasenchak.task1.exception.ReadException;
import by.yasenchak.task1.reader.ReaderImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ReadTest {

    private List<String> expectedList;

    @BeforeClass
    public void beforeReaderTest(){
        expectedList = new ArrayList<>();
        expectedList.add("3.0 10.2 5.2 3.0 2.0");
    }

    @Test
    public void testReadMethod() throws ReadException {
        ReaderImpl reader = new ReaderImpl();
        Assert.assertEquals(reader.read("resource/data.txt"), expectedList);
    }
}
