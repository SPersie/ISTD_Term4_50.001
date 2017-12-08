package PS3PartAHW.Q6Geomtric_Shapes;


public class Square implements Visitable {
    private int squ;

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
    // Your code goes here
    public Square(int squ) {
        this.squ =squ;
    }
    public int getSqu() {
        return squ;
    }

}
