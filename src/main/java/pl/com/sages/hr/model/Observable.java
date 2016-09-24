package pl.com.sages.hr.model;


/**
 * Created by aliberadzki on 24.09.16.
 */
public interface Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer obsever);
    void notifyObservers();
}
