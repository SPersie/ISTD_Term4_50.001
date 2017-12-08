
// Cohort Question 3
// total: 5 points

//===============================================
// todo: complete the following program
//===============================================

package PS2PartBCC.Q3RecurMulti;
import java.lang.Math;


public class RecurMulti {
    public static void main(String[] args) {
        System.out.println(multiply(4, 7));
        System.out.println(multiply(0, 7));
        System.out.println(multiply(4, 0));
    }

    public static int multiply(int a, int b) {
        if(a ==0) {
            return 0;
        }
        return b + multiply(a -1, b);


    }
}