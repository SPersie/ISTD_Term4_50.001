package PS2PartBHW.Q6ReverseLetter;
// Homework Question 6
// total: 10 points

//===============================================
// todo: complete the following program
//===============================================

public class ReverseLetter {
    public static void main (String[] args) {
        String s = "HelloWorld";

        System.out.println ("Calling reverse: ");
        String output = reverse(s);
        System.out.println("output = " + output);
    }
    public static String reverse(String s){
        // Input your codes here
        int len =s.length();
        int last =len-1;
        if(len ==0) {
            return s;
        } else {
            return s.substring(last, last+1) +reverse(s.substring(0,last));
        }


    }
}
