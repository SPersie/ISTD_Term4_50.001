package PS3PartAHW.Q5AirPollutionAlert;

class Subscriber implements Observer{
    private String name;
    private Subject AirPollutionAlert;

    public Subscriber(String name, Subject AirPollutionAlert) {
        this.name =name;
        this.AirPollutionAlert =AirPollutionAlert;
        this.AirPollutionAlert.register(this);
    };

    @Override
    public void update(double airPollutionIndex) {
        if(airPollutionIndex >100) {
            System.out.println(name +" received notification: " + airPollutionIndex);
        }
    }
    // Your code goes here

}

