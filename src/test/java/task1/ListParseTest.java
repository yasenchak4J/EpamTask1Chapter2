package task1;

import by.yasenchak.task1.exception.ParserException;
import by.yasenchak.task1.parser.ParserImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ListParseTest {

    List<Double[]> expectedList;
    List<String> inputList;

    @BeforeClass
    public void beforeListParse(){
        expectedList = new ArrayList<>();
        inputList = new ArrayList<>();
        Double[] doubleArr = new Double[]{3.0, 10.2, 5.2, 3.0, 2.0};
        expectedList.add(doubleArr);
        inputList.add("3.0 10.2 5.2 3.0 2.0 1.0");
    }

    @Test
    public void testParserListMethod() throws ParserException {
        ParserImpl parser = new ParserImpl();
        Assert.assertEquals(parser.parserList(inputList), expectedList);
    }
}
