package PS3PartAHW.Q6Geomtric_Shapes;

public class Rectangle implements Visitable {
    private int rec1;
    private int rec2;

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
    // Your code goes here

    public Rectangle(int rec1, int rec2) {
        this.rec1 =rec1;
        this.rec2 =rec2;
    }

    public int getRec1() {
        return rec1;
    }

    public int getRec2() {
        return rec2;
    }

}

