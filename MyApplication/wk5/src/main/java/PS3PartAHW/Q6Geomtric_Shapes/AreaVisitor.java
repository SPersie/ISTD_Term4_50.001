package PS3PartAHW.Q6Geomtric_Shapes;

public class AreaVisitor implements Visitor {
    private double totalarea =0;

    @Override
    public void visit(Circle c) {
        totalarea +=Math.PI *c.getCircle() *c.getCircle();
    }

    @Override
    public void visit(Square s) {
        totalarea +=s.getSqu() *s.getSqu();
    }

    @Override
    public void visit(Rectangle r) {
        totalarea +=r.getRec1() *r.getRec2();
    }

    // Your code goes here

    public double getTotalArea() {
        return totalarea;
    }


}

