package by.yasenchak.task1.observer;

import by.yasenchak.task1.entity.Pyramid;
import by.yasenchak.task1.registrator.PyramidRegistrator;

public class PyramidObserver implements Observer<Pyramid> {
    @Override
    public void onUpdate(Pyramid pyramid) {
        PyramidRegistrator.getInstance().update(pyramid);
    }

    @Override
    public void onCreate(Pyramid pyramid) {
        PyramidRegistrator.getInstance().add(pyramid);
    }
}
