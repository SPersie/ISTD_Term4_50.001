package PS2PartBHW.Q7RecursiveStringReverse;
// Homework Question 7
// total: 10 points

//===============================================
// todo: complete the following program
//===============================================

public class RecurStringReverse {
    public static void main (String[] args) {
        System.out.println(recurStringReverse("man ate fish"));


    }
    public static String recurStringReverse (String s)  {
        // Input your codes here
        if(s.split(" ").length ==1) {
            return " " + s;
        } else {
//            System.out.println(s.substring(0, s.lastIndexOf(" ")));

            return s.substring(s.lastIndexOf(" "))  + recurStringReverse(s.substring(0, s.lastIndexOf(" ")));
        }
    }
}
