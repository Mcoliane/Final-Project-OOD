/* header: this is the actual computer class that implements the ComputerComponent interface 
and the Subject interface.
 * author: Thien
 * observer: Michael
 */
package Builder;

import observer.Observer;
import observer.Subject;

import java.util.ArrayList;
import java.util.List;

public class Computer implements ComputerComponent, Subject {
    private List<String> parts = new ArrayList<>(); //list of parts
    private List<Observer> observers = new ArrayList<>(); //list of observers

    //add new parts
    @Override
    public void addPart(String part) {
        parts.add(part);
        notifyObservers();
    }
    //get new parts
    @Override
    public List<String> getParts() {
        return parts;
    }
    //return the parts
    @Override
    public String toString() {
        return "Computer Parts: " + parts.toString();
    }

    //attach observer
    @Override
    public void attach(Observer o) {
        observers.add(o);
    }
    //detach observer
    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }
    //notify observers
    @Override
    public void notifyObservers() {
        for (Observer obs : observers) {
            obs.update();
        }
    }
}
