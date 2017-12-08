package PS3PartACC.Q5TaxtVisitor;

public class Electronics implements Visitable {
    private double eletax;

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
    // Your code goes here
    public Electronics(double eletax) {
        this.eletax =eletax;
    }

    public double getEletax() {
        return eletax;
    }
}
