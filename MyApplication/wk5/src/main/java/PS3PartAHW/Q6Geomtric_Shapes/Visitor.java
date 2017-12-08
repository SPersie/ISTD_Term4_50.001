package PS3PartAHW.Q6Geomtric_Shapes;

public interface Visitor {
    void visit(Circle c);
    void visit(Square s);
    void visit(Rectangle r);
}

