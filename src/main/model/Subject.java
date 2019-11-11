package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    private List<Observer> observers;

    public Subject() {
        observers = new ArrayList<>();
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public void addObserver(Observer o) {
        if (!observers.contains(o)) {
            observers.add(o);
        }
    }

    public void removeObserver(Observer o) {
        if (observers.contains(o)) {
            observers.remove(o);
        }
    }

    public void notifyObservers(Movie movie) {
        for (Observer o : observers) {
            o.update(movie);
        }
    }
}
