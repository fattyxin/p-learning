package headfirst.observer;

import java.util.List;

public interface Subject {
    void addObserver(Observer observer);
    void delObserver(Observer observer);
    void notifyObservers(Subject subject);
}
