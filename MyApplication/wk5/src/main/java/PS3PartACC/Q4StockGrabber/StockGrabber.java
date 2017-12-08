package PS3PartACC.Q4StockGrabber;

import java.util.ArrayList;

public class StockGrabber implements Subject {
    private String message;
    private ArrayList<Observer> observers;

    public StockGrabber() {
        observers =new ArrayList<Observer>();
    }
    @Override
    public void register(Observer o) {
        observers.add(o);
    }

    @Override
    public void unregister(Observer o) {
        observers.remove(o);
    }

    @Override
    public void stockUpdate(String S) {
        this.message =S;
        this.NotifyObservers();
    }

    private void NotifyObservers() {
        for(Observer o: observers) {
            o.update(this.message);
        }
    }
}
