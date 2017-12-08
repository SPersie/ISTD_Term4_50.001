package PS3PartAHW.Q4GrandTotalVisitor;

public class ShoppingVisitor implements Visitor {
    private double total =0;
    @Override
    public void visit(Milk m) {
        total +=m.getMilkk();
    }

    @Override
    public void visit(Fish f) {
        total +=f.getFishh() *f.getFishhh();
    }

    @Override
    public void visit(Jacket j) {
        total +=j.getJackett() *1.2;
    }

    // Your code goes here


    public double getTotal() {
        return total;
    }




}
