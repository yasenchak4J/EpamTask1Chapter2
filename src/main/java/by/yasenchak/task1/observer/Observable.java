package by.yasenchak.task1.observer;

public interface Observable<T> {
    void attach(Observer<T> observer);
    void detach(Observer<T> observer);
    void notifyCreateObservers();
    void notifyUpdateObservers();
}
