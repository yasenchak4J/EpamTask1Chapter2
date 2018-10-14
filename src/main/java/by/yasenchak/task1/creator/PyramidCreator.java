package by.yasenchak.task1.creator;

import by.yasenchak.task1.entity.Point;
import by.yasenchak.task1.entity.Pyramid;

import java.util.List;

public interface PyramidCreator {
    List<Pyramid> createFromFile(String URI);
    Pyramid create(int numberOfAngles, double height, double radiusOfSphere, Point pointOfCentrePyramid);
}