package PS2PartBHW.Q5SumOdds;
// Homework Question 5
// total: 15 points

//===============================================
// todo: complete the following program
//===============================================




public class SumOdds {
    public static void main (String[] args) {
        int number = -54322;
        System.out.println(sumOdd(number));

           /* Suggested solution plan:
            * Input your codes to deal with negative number
            * and deal with even number. Invoke sumOdd(number)
            * Print result.
            */

    }

    public static int sumOdd(int i) {
        // Input your codes here
        if(i ==0) {
            return 0;
        } else {
            if(i <0 && i > -10 && i %2 ==-1) {
                return i %10 +Math.abs(sumOdd(i /10));
            } else {
                if(i %10 %2 ==1 || i %10 %2 ==-1) {
                    return Math.abs(i %10) +sumOdd(i /10);
                } else {
                    return sumOdd(i /10);
                }
            }
        }
    }
}
