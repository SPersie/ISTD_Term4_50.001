package PS2PartBHW.Q2Scheduler;
// Homework Question 2
// total: 10 points

//===============================================
// todo: complete the following program
//===============================================


import java.util.*;
import java.util.*;
public class Scheduler {
    /**
     * @param args the command line arguments
     */


    public static void main(String[] args) {
        System.out.println("Welcome to the Appointment Scheduler.");
        System.out.println("You can schedule an appointment " +
                "at 1 or 2 pm.");
        Scanner reader = new Scanner(System.in);
        String appointments[] = new String[3];
        int appointmentsMade = 0;

        //Type your codes here
        while(appointmentsMade !=2) {
            try {
                String str =reader.nextLine();
                if(str.charAt(0) >'2' || str.charAt(0) <'1') {
                    throw new InvalidTimeException();
                }

                if(appointments[Character.getNumericValue(str.charAt(0))] !=null) {
                    throw new TimeInUseException();
                }

                appointments[Character.getNumericValue(str.charAt(0))] =str.substring(2);
                appointmentsMade ++;
            }
            catch (Exception ex) {

            }
        }
        System.out.println("1pm: " +appointments[1] +"2pm: " +appointments[2]);
    }

    public static class InvalidTimeException extends Exception{
        //Type your codes here
        public InvalidTimeException() {
            System.out.println("InvalidTimeException");
        }
    }

    public static class TimeInUseException extends Exception{
        //Type your codes here
        private int time;
        public TimeInUseException() {
            System.out.println("TimeInUseException");
        }
    }

}
