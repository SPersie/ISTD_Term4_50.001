package PS3PartACC.Q4StockGrabber;

 
public class StockObserver implements Observer {
    private String name;
    private String message;
    private Subject subject;

    public StockObserver(Subject subject, String name) {
        this.name =name;
        this.subject =subject;
        this.subject.register(this);
    }
    @Override
    public void update(String msg) {
        this.message =msg;
        System.out.println(name +':' +msg);
    }
}
