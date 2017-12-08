package PS3PartAHW.Q4GrandTotalVisitor;

public class Fish implements Visitable {
    private double fishh;
    private double fishhh;
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
    // Your code goes here
    public Fish(double fishh, double fishhh) {
        this.fishh =fishh;
        this.fishhh =fishhh;
    }
    public double getFishh() {
        return fishh;
    }
    public double getFishhh() {
        return fishhh;
    }
}

