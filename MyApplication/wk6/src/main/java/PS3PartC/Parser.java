//package PS3PartC;
//
//
///*
// * TODO (optional) define your grammar here
// */
//
//import java.util.ArrayList;
//
///**
// * Calculator parser. All values are measured in pt.
// */
//class Parser {
//
//	@SuppressWarnings("serial")
//	static class ParserException extends RuntimeException {
//	}
//
//	/**
//	 * Type of values.
//	 */
//	private enum ValueType {
//		POINTS, INCHES, SCALAR
//	};
//
//	/**
//	 * Internal value is always in points.
//	 */
//	public class Value {
//		final double value;
//		final ValueType type;
//
//		Value(double value, ValueType type) {
//			this.value = value;
//			this.type = type;
//		}
//
//		@Override
//		public String toString() {
//			switch (type) {
//			case INCHES:
//				return value / PT_PER_IN + " in";
//			case POINTS:
//				return value + " pt";
//			default:
//				return "" + value;
//			}
//		}
//	}
//
//	int counter;
//
//	private static final double PT_PER_IN = 72;
////	private final Lexer lexer;
//
//	// TODO write method spec
//	Parser(Lexer lexer) {
//		// TODO implement for Problem
//		counter =0;
//		String sublexer = null;
//		ArrayList<Lexer.Token> string =lexer.outputs;
//		while (counter <string.size()) {
//			if(string.get(counter).type ==Type.L_PAREN) {
//				ArrayList<Lexer.Token> sub =new ArrayList<>();
//				while (string.get(counter).type !=Type.R_PAREN) {
//					sub.add(string.get(counter +1));
//					counter +=1;
//				}
//				for(int i=0; i<sub.size(); i++) {
//					sublexer +=sub.get(i).text;
//				}
//
//			}
//
//
//
//
//
//
//
//
//
//
//
//
//
//		}
//	}
//
//	// TODO write method spec
//	public Value evaluate() {
//		// TODO implement for Problem
//	}
//}
