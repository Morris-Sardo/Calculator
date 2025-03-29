package application;

import java.util.function.Consumer;

/**
 * This class was created to implement CalcControllerTest class when CalcControllerTest class needs
 * to use viewInterface class methods.
 *
 * @author papap
 * @version $Id: $Id
 * @since 1.0
 */
public class MockView implements ViewInterface {

  public Runnable calculateMethod;
  public Consumer<OpType> typeMethod;
  public String expression;
  public String answer;


  // added set expression.
  /**
   * <p>Setter for the field <code>expression</code>.</p>
   *
   * @param newExpression a {@link java.lang.String} object
   */
  public void setExpression(String newExpression) {
    this.expression = newExpression;
  }

  /** {@inheritDoc} */
  @Override
  public void addCalculateObserver(Runnable f) {
    this.calculateMethod = f;


  }

  /** {@inheritDoc} */
  @Override
  public void addTypeObserver(Consumer<OpType> c) {
    this.typeMethod = c;

  }

  /** {@inheritDoc} */
  @Override
  public String getExpression() {

    return this.expression;
  }

  /** {@inheritDoc} */
  @Override
  public void setAnswer(String a) {
    this.answer = a;

  }

  /** {@inheritDoc} */
  @Override
  public void startView() {



  }



}
