package PS3PartAHW.Q3TrafficAlrt;

import java.util.ArrayList;

public class Traffic implements Subject {
    private String message;
    private ArrayList<Observer> observers;

    public Traffic() {
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
    public void changeCondition(String S) {
        this.message =S;
        this.NotifyObservers();
    }

    // Your code goes here
    private void NotifyObservers() {
        for(Observer o: observers) {
            o.update(this.message);
        }
    }




}