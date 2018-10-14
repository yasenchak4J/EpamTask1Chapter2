package by.yasenchak.task1.service;

import by.yasenchak.task1.creator.PyramidCreator;
import by.yasenchak.task1.creator.PyramidCreatorImpl;
import by.yasenchak.task1.entity.Pyramid;

import java.util.ArrayList;
import java.util.List;

public class OperationWithPyramid {

    private PyramidCreator pyramidCreator;
    private List<Pyramid> pyramids;

    public OperationWithPyramid(){
        pyramidCreator = new PyramidCreatorImpl();
        pyramids = pyramidCreator.create();
    }

    public List<Double> calcSurfaceArea(){
        List<Double> surfaceList = new ArrayList<>();
        for (Pyramid pyramid: pyramids) {
            double surfaceArea = calcSurfaceSideArea(pyramid) + calcBaseArea(pyramid);
            surfaceList.add(surfaceArea);
        }
        return surfaceList;
    }

    public List<Double> caclVolume(){
        List<Double> volumeList = new ArrayList<>();
        for (Pyramid pyramid: pyramids) {
            double volumeArea = ((1.0 / 3.0) * calcBaseArea(pyramid)) * pyramid.getHeight();
            volumeList.add(volumeArea);
        }
        return volumeList;
    }

    public double caclVolume(Pyramid pyramid){
        double volumeArea = ((1.0 / 3.0) * calcBaseArea(pyramid)) * pyramid.getHeight();
        return volumeArea;
    }

    public double caclSurfaceArea(Pyramid pyramid){
        double surface = calcSurfaceSideArea(pyramid) + calcBaseArea(pyramid);
        return surface;
    }

    public boolean isPyramid(Object obj){
        try {
            Pyramid pyramid = (Pyramid) obj;

            if (pyramid.getHeight() > 0 && pyramid.getBottomSideLength() > 0 && pyramid.getNumberOfAngles() >= 3) {
                return true;
            } else {
                return false;
            }
        } catch (ClassCastException e){
            return false;
        }
    }

    public List<Boolean> isBaseOnTheCoordinatePlane(){
        List<Boolean> booleanList = new ArrayList<>();
        for (Pyramid pyramid: pyramids) {
            if(isBasedOnX(pyramid) || isBasedOnY(pyramid) || isBasedOnZ(pyramid)){
                booleanList.add(true);
            } else booleanList.add(false);
        }
        return booleanList;
    }

    private boolean isBasedOnX(Pyramid pyramid){
        return isBased(pyramid.getPointOfCentrePyramid().getPointX(), pyramid);
    }

    private boolean isBasedOnY(Pyramid pyramid){
        return isBased(pyramid.getPointOfCentrePyramid().getPointY(), pyramid);
    }

    private boolean isBasedOnZ(Pyramid pyramid){
        return isBased(pyramid.getPointOfCentrePyramid().getPointZ(), pyramid);
    }

    private boolean isBased(double coordinate, Pyramid pyramid){
        if(coordinate > 0){
            if (coordinate - (pyramid.getBottomSideLength() / 2) < 0){
                return true;
            } else return false;
        } else {
            if (coordinate + (pyramid.getBottomSideLength() / 2) > 0){
                return true;
            } else return false;
        }
    }

    private double calcBaseArea(Pyramid pyramid){
        double baseArea;
        switch (pyramid.getNumberOfAngles()){
            case 3: baseArea = (Math.sqrt(3) / 4) * Math.pow(pyramid.getBottomSideLength(), 2); return baseArea;
            case 4: baseArea = Math.pow(pyramid.getBottomSideLength(), 2); return baseArea;
            case 6: baseArea = (3 * Math.sqrt(3)) / (2 * Math.pow(pyramid.getBottomSideLength(), 2)); return baseArea;
            default: baseArea = 0;
        }
        return baseArea;
    }

    private double calcApothem(Pyramid pyramid){
        double apothem = Math.sqrt(Math.pow(pyramid.getHeight(), 2) + Math.pow(pyramid.getBottomSideLength() / 2, 2));
        return apothem;
    }

    private double calcSurfaceSideArea(Pyramid pyramid){
        double surfaceSideArea = pyramid.getHeight() * (0.5 * pyramid.getBottomSideLength()) * calcApothem(pyramid);
        return surfaceSideArea;
    }
}
