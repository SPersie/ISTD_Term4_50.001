package PS3PartAHW.Q4GrandTotalVisitor;

 
    public class Milk implements Visitable {
        private double milkk;
        @Override
        public void accept(Visitor v) {
            v.visit(this);
        }
        // Your code goes here
        public Milk(double milkk) {
            this.milkk =milkk;
        }
        public double getMilkk() {
            return milkk;
        }

    }
