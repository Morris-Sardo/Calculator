package application;

import java.util.function.Consumer;

/**
 * This class was created to implement CalcControllerTest class when CalcControllerTest class needs
 * to use viewInterface class methods.
 * 
 * @author papap
 *
 */
public class MockView implements ViewInterface {

  public Runnable calculateMethod;
  public Consumer<OpType> typeMethod;
  public String expression;
  public String answer;


  // added set expression.
  public void setExpression(String newExpression) {
    this.expression = newExpression;
  }

  @Override
  public void addCalculateObserver(Runnable f) {
    this.calculateMethod = f;


  }

  @Override
  public void addTypeObserver(Consumer<OpType> c) {
    this.typeMethod = c;

  }

  @Override
  public String getExpression() {

    return this.expression;
  }

  @Override
  public void setAnswer(String a) {
    this.answer = a;

  }

  @Override
  public void startView() {



  }



}
