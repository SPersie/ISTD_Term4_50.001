package PS2PartBHW.Q1ModularProgram;
// Homework Question 1
// total: 10 points

//===============================================
// todo: complete the following program
//===============================================


import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.Math;
public class ModularProgram {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean continueInput = true;
        do {
            try {
                tryexception(input);
            } catch (InputMismatchException ex) {
                // Input your code here
                System.out.println("Sorry, you must enter two integer values");
                System.out.println(ex);
            } catch (ArithmeticException ex) {
                // Input your code here
                System.out.println("Sorry, cannot compute mod by 0");
                System.out.println(ex);

            } finally {
                System.out.println("Do another pair of values ? (y)");
                input.nextLine();
                String str = input.next();
                char ch = str.charAt(0);
                System.out.println(" ch = " + ch);
                if ((ch != 'y') && (ch != 'Y')) {
                    continueInput = false;
                }
            }
        } while (continueInput);
    }

    public static void tryexception(Scanner input) throws InputMismatchException {
        // Input your code here
        System.out.println("Welcome to the modulus computer");
        System.out.println("Enter two integer values");
        int a =input.nextInt();
        int b =input.nextInt();
        int c =a%b;
    }
}
