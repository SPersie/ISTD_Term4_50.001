package PS3PartACC.Q5TaxtVisitor;

public class Chocolate implements Visitable {
    private double chotax;

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
    // Your code goes here
    public Chocolate(double chotax) {
        this.chotax =chotax;
    }

    public double getChotax() {
        return chotax;
    }
}
