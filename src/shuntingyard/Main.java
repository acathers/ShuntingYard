package shuntingyard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main {

  static Stack<Operator> operatorStack = new Stack<>();
  static List<String> queue = new ArrayList<>();
  static List<String> validOperators = Arrays.asList("+", "-", "*", "-", "^");

  public static void main(String[] args) {

    String infix = "3 + 6 ^ 3 ^ 5 * 9 ( 3 + 5 ) - 4";
    toPostFix(infix);

    for (String string : queue) {
      System.out.print(string + " ");
    }
  }

  public static void toPostFix(String string) {

    for (String token : string.split(" ")) {
      if (isNumeric(token)) {
        queue.add(token);
      } else if (validOperators.contains(token)) {
        Operator operator = new Operator(token);

        while (!operatorStack.isEmpty()
            && (operatorStack.peek().compareTo(operator) == 1
                || (operatorStack.peek().compareTo(operator) == 0
                    && operatorStack.peek().leftAssociative))
            && !operatorStack.peek().getOperator().equals("(")) {
          queue.add(operatorStack.pop().getOperator());
        }
        operatorStack.push(operator);

      } else if (token.equals("(")) {
        operatorStack.push(new Operator("("));
      } else if (token.equals(")")) {

        while (!operatorStack.peek().getOperator().equals("(")) {
          queue.add(operatorStack.pop().getOperator());
        }
        operatorStack.pop();
      }
    }

    while (!operatorStack.isEmpty()) {
      queue.add(operatorStack.pop().getOperator());
    }
  }

  public static boolean isNumeric(String string) {
    try {
      Double d = Double.parseDouble(string);

    } catch (NumberFormatException e) {
      return false;
    }
    return true;
  }
}
