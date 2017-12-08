package PS2PartBCC.Example;

/**
 * Created by study on 9/11/17.
 */

public class moveLnStars {
    public static void main(String[] args) {
        System.out.println(moveLnStars("hello"));
        System.out.println(moveLnStars("xxyy"));
        System.out.println(moveLnStars("aaaa"));

    }

    public static String moveLnStars(String input) {
        int len =input.length();
        if(len ==0) {
            return "";
        } else if(len ==1) {
           return input;
        } else if(input.charAt(0) ==input.charAt(1)) {
            return input.substring(0, 1) +'*' +moveLnStars(input.substring(1));
        } else {
            return input.substring(0, 1) +moveLnStars(input.substring(1));
        }
    }
}
