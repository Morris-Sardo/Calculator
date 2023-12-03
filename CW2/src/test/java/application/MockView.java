package application;

import java.util.function.Consumer;

/**
 * 
 * @author papap
 *
 */
public class MockView implements ViewInterface {

  private Runnable calculateMethod;
  private Consumer<OpType> typeMethod;
  private String expression;
  private String answer;


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
      this.answer =a;

  }

  @Override
  public void startView() {
    


  }
  


}
