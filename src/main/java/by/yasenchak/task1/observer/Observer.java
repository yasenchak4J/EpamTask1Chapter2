package by.yasenchak.task1.observer;

public interface Observer<T> {
    void onUpdate(T t);
    void onCreate(T t);
}
