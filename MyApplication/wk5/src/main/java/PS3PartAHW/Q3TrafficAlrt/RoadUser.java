package PS3PartAHW.Q3TrafficAlrt;

public class RoadUser implements Observer {
    private String name;
    private Subject subject;

    public RoadUser(String name, Subject Traffic) {
        this.name =name;
        this.subject =Traffic;
        this.subject.register(this);
    }
    @Override
    public void update(String message) {
        System.out.println(name +" receives alert: " +message);
    }
    // Your code goes here
}
