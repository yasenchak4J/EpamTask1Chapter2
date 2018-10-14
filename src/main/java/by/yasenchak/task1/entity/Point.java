package by.yasenchak.task1.entity;

import java.io.Serializable;

public class Point implements Serializable {

    private static final long serialVersionUID = -8228737910229286905L;
    private double pointX;
    private double pointY;
    private double pointZ;

    public Point(){
        super();
    }

    public double getPointX() {
        return pointX;
    }

    public void setPointX(double pointX) {
        this.pointX = pointX;
    }

    public double getPointY() {
        return pointY;
    }

    public void setPointY(double pointY) {
        this.pointY = pointY;
    }

    public double getPointZ() {
        return pointZ;
    }

    public void setPointZ(double pointZ) {
        this.pointZ = pointZ;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (getClass() != o.getClass()) return false;

        Point point = (Point) o;

        return this.pointX == point.pointX &&
                this.pointY == point.pointY &&
                this.pointZ == point.pointZ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + Double.valueOf(pointX).hashCode();
        result = prime * result + Double.valueOf(pointY).hashCode();
        result = prime * result + Double.valueOf(pointZ).hashCode();

        return result;
    }

    @Override
    public String toString() {
        return getClass().getName() + "{" +
                "pointX=" + pointX +
                ", pointY=" + pointY +
                ", pointZ=" + pointZ +
                '}';
    }
}
