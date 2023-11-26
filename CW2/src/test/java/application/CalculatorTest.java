package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {

  private Calculator calculator;
  
  @BeforeEach
  void setUp() {
    //calculator = new StandardCalc();
    calculator = new RevPolCalc();
  }
  
  //test 1 evaluate RevPol.
  //Added implement to RevPolClass.
  //Modified change evaluate method in Calculator class. It won't take anymore argument boolean.
  @Test
  void evaluateReversePolishExpressiontest() {
    
    String expression = "3 2 +";
    assertEquals(5f,calculator.evaluate(expression));
  }
  
////test 2 evaluate StandardClac.
//  //Added implement to StandardardCalc class.
//  @Test
//  void evaluateRevewrsePolishExpressiontest() throws InvalidExpression {
//    
//    String expression = "3 2 +";
//    assertEquals(5f,calculator.evaluate(expression));
//  }
  
  
  }

