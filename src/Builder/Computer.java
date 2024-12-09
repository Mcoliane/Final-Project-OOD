package Builder;

import observer.Observer;
import observer.Subject;

import java.util.ArrayList;
import java.util.List;

public class Computer implements ComputerComponent, Subject {
    private List<String> parts = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void addPart(String part) {
        parts.add(part);
        notifyObservers();
    }

    @Override
    public List<String> getParts() {
        return parts;
    }

    @Override
    public String toString() {
        return "Computer Parts: " + parts.toString();
    }

    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer obs : observers) {
            obs.update();
        }
    }
}
