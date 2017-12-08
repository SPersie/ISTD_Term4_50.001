package PS3PartACC.Q5TaxtVisitor;

public class Car implements Visitable {
    private double cartax;

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
    // Your code goes here
    public Car(double cartax) {
        this.cartax =cartax;
    }

    public double getCartax() {
        return cartax;
    }
}
