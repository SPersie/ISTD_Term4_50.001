package PS2PartBCC.Example;

/**
 * Created by study on 9/11/17.
 */

public class EndX {
    public static void main(String[] args) {
        System.out.println(EndX("khikhik"));

    }

    public static String EndX(String input) {
        int len =input.length();
        if(len ==0) {
            return "";
        } else if(input.charAt(0) =='k') {
            return EndX(input.substring(1)) +'k';
        } else {
            return input.substring(0, 1) +EndX(input.substring(1));
        }
    }
}
