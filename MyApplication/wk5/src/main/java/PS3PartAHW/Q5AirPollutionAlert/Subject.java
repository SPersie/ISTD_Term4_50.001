package PS3PartAHW.Q5AirPollutionAlert;

interface Subject{
    void register(Observer o);
    void unregister(Observer o);
    void notifyObservers();
}
