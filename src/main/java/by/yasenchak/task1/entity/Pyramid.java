package by.yasenchak.task1.entity;

import by.yasenchak.task1.observer.Observable;
import by.yasenchak.task1.observer.Observer;
import by.yasenchak.task1.observer.PyramidObserver;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pyramid implements Serializable, Observable<Pyramid> {

    private static final long serialVersionUID = -2890388334857103595L;
    private long pyramidId;
    private int numberOfAngles;
    private double height;
    private double bottomSideLength;
    private Point pointOfCentrePyramid;
    private List<Observer<Pyramid>> observers = new ArrayList<>();

    public Pyramid(){
        super();
    }

    public Pyramid(int numberOfAngles, double height, double radiusOfSphere, Point pointOfCentrePyramid){
        attach(new PyramidObserver());
        this.numberOfAngles = numberOfAngles;
        this.height = height;
        this.bottomSideLength = radiusOfSphere;
        this.pointOfCentrePyramid = pointOfCentrePyramid;
        notifyCreateObservers();
    }

    public int getNumberOfAngles() {
        return numberOfAngles;
    }

    public void setNumberOfAngles(int numberOfAngles) {
        this.numberOfAngles = numberOfAngles;
        notifyUpdateObservers();
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
        notifyUpdateObservers();
    }

    public double getBottomSideLength() {
        return bottomSideLength;
    }

    public void setBottomSideLength(double bottomSideLength) {
        this.bottomSideLength = bottomSideLength;
        notifyUpdateObservers();
    }

    public Point getPointOfCentrePyramid() {
        return pointOfCentrePyramid;
    }

    public long getPyramidId() {
        return pyramidId;
    }
    public void setPointOfCentrePyramid(Point pointOfCentrePyramid) {
        this.pointOfCentrePyramid = pointOfCentrePyramid;
        notifyUpdateObservers();
    }

    public void setPyramidId(long pyramidId) {
        this.pyramidId = pyramidId;
        notifyUpdateObservers();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (getClass() != o.getClass()) return false;

        Pyramid pyramid = (Pyramid) o;

        return this.numberOfAngles == pyramid.numberOfAngles &&
                this.height == pyramid.height &&
                this.bottomSideLength == pyramid.bottomSideLength;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + Double.valueOf(numberOfAngles).hashCode();
        result = prime * result + Double.valueOf(height).hashCode();
        result = prime * result + Double.valueOf(bottomSideLength).hashCode();

        return result;
    }

    @Override
    public String toString() {
        return getClass().getName() + "{" +
                "numberOfAngles=" + numberOfAngles +
                ", height=" + height +
                ", bottomSideLength=" + bottomSideLength +
                ", pointOfCentrePyramid=" + pointOfCentrePyramid +
                '}';
    }

    @Override
    public void attach(Observer<Pyramid> observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer<Pyramid> observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyCreateObservers() {
        observers.forEach(o->o.onCreate(this));
    }

    @Override
    public void notifyUpdateObservers() {
        observers.forEach(o->o.onUpdate(this));
    }
}
