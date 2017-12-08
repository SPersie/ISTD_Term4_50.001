package PS3PartACC.Q5TaxtVisitor;

public class TaxVisitor implements Visitor {
    private double total =0;
    private String type;

    public TaxVisitor(String type) {
        this.type =type;
    }
    @Override
    public void visit(Car c) {
        if(type =="TAXHOLIDAY") {
            total +=c.getCartax() *0.3;
        } else {
            total +=c.getCartax() *0.4;
        }
    }

    @Override
    public void visit(Electronics e) {
        if(type =="TAXHOLIDAY") {
            total +=e.getEletax() *0.5;
        } else {
            total +=e.getEletax() *0.8;
        }
    }

    @Override
    public void visit(Chocolate c) {
        if(type =="TAXHOLIDAY") {
            total +=c.getChotax() *0.1;
        } else {
            total +=c.getChotax() *0.2;
        }
    }

    // Your code goes here


    public double getTotal() {
        return total;
    }


}


