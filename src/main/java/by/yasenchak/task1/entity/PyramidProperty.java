package by.yasenchak.task1.entity;

public class PyramidProperty {

    private double surfaceArea;
    private double volume;

    public PyramidProperty(){
        super();
    }

    public PyramidProperty(double surfaceArea, double volume) {
        this.surfaceArea = surfaceArea;
        this.volume = volume;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (getClass() != o.getClass()) return false;

        PyramidProperty pyramidProperty = (PyramidProperty) o;

        return this.surfaceArea == pyramidProperty.surfaceArea &&
                this.volume == pyramidProperty.volume;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + Double.valueOf(surfaceArea).hashCode();
        result = prime * result + Double.valueOf(volume).hashCode();

        return result;
    }

    @Override
    public String toString() {
        return getClass().getName() + "{" +
                "volume=" + volume +
                ", surface area=" + surfaceArea + '}';
    }


}
