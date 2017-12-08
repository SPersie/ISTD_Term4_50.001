package PS3PartAHW.Q4GrandTotalVisitor;

 
public class Jacket implements Visitable {
    private double jackett;
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
    public Jacket(double jackett) {
        this.jackett =jackett;
    }
    public double getJackett() {
        return jackett;
    }

    // Your code goes her

}

