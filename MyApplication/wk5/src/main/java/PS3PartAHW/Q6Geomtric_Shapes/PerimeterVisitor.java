package PS3PartAHW.Q6Geomtric_Shapes;

public class PerimeterVisitor implements Visitor {
    private double totalper;
    @Override
    public void visit(Circle c) {
        totalper +=2 * Math.PI * c.getCircle();
    }

    @Override
    public void visit(Square s) {
        totalper +=4 *s.getSqu();
    }

    @Override
    public void visit(Rectangle r) {
        totalper +=2 *(r.getRec1() +r.getRec2());
    }

    // Your code goes here
    public double getTotalPerimeter() {
        return totalper;
    }





}

