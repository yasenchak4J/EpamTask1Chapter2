package task1;

import by.yasenchak.task1.creator.PyramidCreator;
import by.yasenchak.task1.creator.PyramidCreatorImpl;
import by.yasenchak.task1.entity.Pyramid;
import by.yasenchak.task1.service.OperationWithPyramid;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ServiceTest {

    List<Double> expectedSurface;
    List<Double> expectedVolume;
    OperationWithPyramid operation;

    @BeforeClass
    public void beforClassTest(){
        operation = new OperationWithPyramid();
        expectedVolume = new ArrayList<>();
        expectedVolume.add(39.8094557);
        expectedSurface = new ArrayList<>();
        expectedSurface.add(290.8623707);
    }

    @Test
    public void testCalcVolume(){
        List<Double> actualVolume;
        actualVolume = operation.caclVolume();
        Assert.assertEquals(actualVolume, expectedVolume);
    }

    @Test
    public void testCaclSurfaceArea(){
        List<Double> actualSurface = operation.calcSurfaceArea();
        Assert.assertEquals(actualSurface, expectedSurface);
    }


}
