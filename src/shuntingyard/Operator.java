package shuntingyard;

public class Operator implements Comparable<Operator> {
  private String operator;
  boolean leftAssociative = true;

  public Operator(String op) {
    if (op.equals("^")) {
      leftAssociative = false;
    }
    operator = op;
  }

  public String operator() {
    return operator;
  }

  public int precedence() {

    if (operator.equals("+") || operator.equals("-")) {
      return 2;
    } else if (operator.equals("*") || operator.equals("/")) {
      return 3;
    } else if (operator.equals("^")) {
      return 4;
    }

    return -1;
  }

  @Override
  public int compareTo(Operator o) { // TODO Auto-generated method stub
    if (this.precedence() > o.precedence()) {
      return 1;
    } else if (this.precedence() < o.precedence()) {
      return -1;
    }

    return 0;
  }

  public String getOperator() {
    return operator;
  }
}