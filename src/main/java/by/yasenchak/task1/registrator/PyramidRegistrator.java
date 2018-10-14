package by.yasenchak.task1.registrator;

import by.yasenchak.task1.entity.Pyramid;
import by.yasenchak.task1.entity.PyramidProperty;
import by.yasenchak.task1.service.OperationWithPyramid;

import java.util.HashMap;
import java.util.Map;

public class PyramidRegistrator {
    private static PyramidRegistrator instance;

    private Map<Long, PyramidProperty> pyramidProperty;

    private PyramidRegistrator(){
        pyramidProperty = new HashMap<>();
    }

    public static PyramidRegistrator getInstance(){
        if(instance == null){
            instance = new PyramidRegistrator();
        }
        return instance;
    }

    public Map<Long, PyramidProperty> getPyramidProperty() {
        return pyramidProperty;
    }

    public void add(Pyramid pyramid) {
        OperationWithPyramid operation = new OperationWithPyramid();
        PyramidProperty property = new PyramidProperty(operation.caclSurfaceArea(pyramid), operation.caclVolume(pyramid));
        pyramidProperty.put(pyramid.getPyramidId(), property);
    }

    public void update(Pyramid pyramid) {
        OperationWithPyramid operation = new OperationWithPyramid();
        PyramidProperty property = new PyramidProperty(operation.caclSurfaceArea(pyramid), operation.caclVolume(pyramid));
        pyramidProperty.replace(pyramid.getPyramidId(), property);
    }
}
