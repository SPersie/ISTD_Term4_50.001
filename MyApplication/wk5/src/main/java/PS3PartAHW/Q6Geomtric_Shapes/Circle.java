package PS3PartAHW.Q6Geomtric_Shapes;


public class Circle implements Visitable {
    private int circle;

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
    // Your code goes here
    public Circle(int circle) {
        this.circle =circle;
    }
    public int getCircle() {
        return circle;
    }

}
