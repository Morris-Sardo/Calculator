package application;

/**
 * A calculator capable of decoding a String as an arithmetic expression and evaluating the answer.
 */
public interface Calculator {
  /**
   * This method get a string expression an evaluate it or reverse polish or in Standard one.
   * 
   * @param expression to evaluate.
   * @return the result of the evaluated expression.
   * @throws InvalidExpression every then expression type is not correct.
   */
  public float evaluate(String expression) throws InvalidExpression;

}
