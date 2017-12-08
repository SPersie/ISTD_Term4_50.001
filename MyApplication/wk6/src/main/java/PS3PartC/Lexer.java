package PS3PartC;


import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Calculator lexical analyzer.
 */
public class Lexer {

    public int counter;
    public Pattern p =Pattern.compile("\\d+(\\.\\d+)?");
	/**
	 * Token in the stream.
	 */
	public static class Token {
		final Type type;
		final String text;

		Token(Type type, String text) {
			this.type = type;
			this.text = text;
		}

		Token(Type type) {
			this(type, null);
		}
	}

	@SuppressWarnings("serial")
	static class TokenMismatchException extends Exception {
	}

	static class DoNotSupport extends Exception {

    }

    static class OrderNotExplicit extends Exception {

    }



	// TODO write method spec
    public ArrayList<Token> outputs;

	public Lexer(String input) {
		// TODO implement for Problem

        outputs =new ArrayList<>();
        while (counter <input.length()) {
            if(Character.isDigit(input.charAt(counter))) {
                Matcher m =p.matcher(input.substring(counter));
                if(m.find()) {
                    String digit =m.group();
                    Token number =new Token(Type.NUMBER, digit);
                    outputs.add(number);
                    counter +=m.end();
                }
            } else {
//                L_PAREN,	// it means (
//                R_PAREN,	// it means )
//                NUMBER,		// 1, 2, 3, 4...
//                INCH,
//                POINT,
//                PLUS,		// +
//                MINUS,		// -
//                TIMES,		// *
//                DIVIDE		// /

                if(input.charAt(counter) =='(') {
                    Token lparen =new Token(Type.L_PAREN, "(");
                    outputs.add(lparen);
                    counter +=1;
                } else if(input.charAt(counter) ==')') {
                    Token rparen =new Token(Type.R_PAREN, ")");
                    outputs.add((rparen));
                    counter +=1;
                } else if(input.charAt(counter) =='i' &input.charAt(counter +1) =='n') {
                    Token inch =new Token(Type.INCH, "in");
                    outputs.add(inch);
                    counter +=2;
                } else if(input.charAt(counter) =='p' &input.charAt(counter +1) =='t') {
                    Token point =new Token(Type.POINT, "pt");
                    outputs.add(point);
                    counter +=2;
                } else if(input.charAt(counter) =='+') {
                    Token plus =new Token(Type.PLUS, "+");
                    outputs.add(plus);
                    counter +=1;
                } else if(input.charAt(counter) =='-') {
                    Token minus =new Token(Type.MINUS, "-");
                    outputs.add(minus);
                    counter +=1;
                } else if(input.charAt(counter) =='*') {
                    Token times =new Token(Type.TIMES, "*");
                    outputs.add(times);
                    counter +=1;
                } else if(input.charAt(counter) =='/') {
                    Token divide =new Token(Type.DIVIDE, "/");
                    outputs.add(divide);
                    counter +=1;
                } else if(input.charAt(counter) ==' ') {
                    counter +=1;
                }
                //exceptions
                else if(input.charAt(counter) =='^') {
                    try{
                        throw new DoNotSupport();
                    } catch (DoNotSupport e) {
                        System.out.println("do not support ^");
                        System.out.println(e);
                    }
                } else if(input.charAt(counter) =='i' &input.charAt(counter +1) =='n'
                        &input.charAt(counter +2) ==' ' &input.charAt(counter +3) =='p'
                        &input.charAt(counter +4) =='t') {
                    try{
                        throw new OrderNotExplicit();
                    } catch (OrderNotExplicit ex) {
                        System.out.println("order not explicit");
                        System.out.println(ex);
                    }
                } else if(input.charAt(counter) =='p' &input.charAt(counter +1) =='t'
                        &input.charAt(counter +2) ==' ' &input.charAt(counter +3) =='i'
                        &input.charAt(counter +4) =='n') {
                    try{
                        throw new OrderNotExplicit();
                    } catch (OrderNotExplicit ex) {
                        System.out.println("order not explicit");
                        System.out.println(ex);
                    }
                } else {
                    try{
                        throw new TokenMismatchException();
                    } catch (TokenMismatchException ex) {
                        System.out.println("token mismach");
                        System.out.println(ex);
                    }
                }
            }
        }
	}
}
