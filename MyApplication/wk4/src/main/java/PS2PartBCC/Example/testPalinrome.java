package PS2PartBCC.Example;

/**
 * Created by study on 9/11/17.
 */

public class testPalinrome {
    public static void main(String[] args) {
        System.out.println(testPalindrome("Pp"));
        System.out.println(testPalindrome("annna"));
        System.out.println(testPalindrome("Palindrome"));

    }

    public static boolean testPalindrome(String input) {
        String in =input.toLowerCase();
        int len =input.length();
//        System.out.println(len);
        if(len ==0 ||len ==1) {
            return true;
        } else if(in.charAt(0) ==in.charAt(len -1)) {
//            System.out.println(input.substring(1, len -1) +"testtest");
            return testPalindrome(in.substring(1, len -1));
        } else {
            return false;
        }
    }
}
