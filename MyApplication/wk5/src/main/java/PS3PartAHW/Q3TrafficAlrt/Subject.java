package PS3PartAHW.Q3TrafficAlrt;

public interface Subject {
    void register(Observer o);
    void unregister(Observer o);
    void changeCondition (String S);
}
