package PS3PartAHW.Q5AirPollutionAlert;

import java.util.ArrayList;

class AirPollutionAlert implements Subject {
    private int index =0;
    private String message;
    private ArrayList<Observer> observers;

    public AirPollutionAlert() {
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


    public void setAirPollutionIndex(int index) {
        this.index =index;
        this.notifyObservers();
    }

    // Your code goes here
    public void notifyObservers() {
        for(Observer o: observers) {
            o.update(this.index);
        }
    }

    // Your code goes here



}




