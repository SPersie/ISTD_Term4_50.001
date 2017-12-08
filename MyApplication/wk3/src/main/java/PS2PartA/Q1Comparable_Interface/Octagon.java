package PS2PartA.Q1Comparable_Interface;// Question 1
// total: 10 points

//===============================================
// todo: Modify Octagon class to implement the Comparable<Octagon> interface
//===============================================


public class Octagon implements Comparable<Octagon>{
    private double side;
    public Octagon(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    @Override
    public int compareTo(Octagon o) {
        if(this.side > o.side) {
            return 1;
        } else if(this.side < o.side) {
            return -1;
        } else {
            return 0;
        }
    }
}
