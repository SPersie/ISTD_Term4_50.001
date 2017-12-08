package PS2PartBCC.Q6DoubleEachLetter;
// Cohort Question 6
// total: 5 points

//===============================================
// todo: complete the following program
//==============================================6


public class DoubleEachLetter {
    public static void main(String[] args) {
        System.out.println(doubleEachLetter("book"));

    }

    public static String doubleEachLetter(String s) {
        int len = s.length();
        if(s.length()==0) {
            return s;
        } else {
            return s.substring(0,1) + s.substring(0,1) + doubleEachLetter(s.substring(1));
        }
    }
}
