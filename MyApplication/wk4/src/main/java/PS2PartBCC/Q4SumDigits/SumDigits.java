package PS2PartBCC.Q4SumDigits;
// Cohort Question 4
// total: 10 points

//===============================================
// todo: complete the following program
//===============================================


public class SumDigits {
    public static void main(String[] args) {
        System.out.println(sumDigits(-54));
    }

    public static int sumDigits(int number) {
        if(number <0) {
            number = -number;
        }
        if(number ==0) {
            return 0;
        } else {
            return number % 10 + sumDigits(number / 10);
        }
    }
}
