package PS2PartBHW.Q4HandShake;
// Homework Question 4
// total: 10 points

//===============================================
// todo: complete the following program
//===============================================




import java.util.InputMismatchException;

public class Handshake {
    public static void main (String[] args) {
        try {

            System.out.println(handshake(10));
            System.out.println(handshake(3));
            System.out.println(handshake(-4));

        }
        catch (InputMismatchException ex) {
            System.out.println("Sorry. Number of persons cannot be negative.");
        }
        // Input your codes here
    }

    public static int handshake (int k) throws InputMismatchException {
        // Input your codes here
        if(k <=1) {
            throw new InputMismatchException();
        } else {
            return k *(k-1) /2;
        }
    }
}
