//interface to implement observer pattern
//Author: Mark, Michael, Thien
package observer;

public interface Subject {
    void attach(Observer o);
    void detach(Observer o);
    void notifyObservers();
}
