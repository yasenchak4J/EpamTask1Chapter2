package task1;

import by.yasenchak.task1.creator.PyramidCreatorImpl;
import by.yasenchak.task1.entity.Point;
import by.yasenchak.task1.entity.Pyramid;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CreatorTest {

    private List<Pyramid> expectedList;

    @BeforeClass
    public void beforeCreateClass(){
        Pyramid pyramid = new Pyramid();
        Point point = new Point();

        point.setPointX(3.0);
        point.setPointY(2.0);
        point.setPointZ(1.0);

        pyramid.setPointOfCentrePyramid(point);
        pyramid.setHeight(10.2);
        pyramid.setBottomSideLength(5.2);
        pyramid.setNumberOfAngles(3);

        expectedList = new ArrayList<>();
        expectedList.add(pyramid);
    }

    @Test
    public void testCreatePyramidList(){
        PyramidCreatorImpl pyramidCreator = new PyramidCreatorImpl();
        Assert.assertEquals(pyramidCreator.createFromFile("resource/data.txt"), expectedList);
    }
}
