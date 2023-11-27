package application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {

  private Calculator calculator;
  
  @BeforeEach
  void setUp() {
    //calculator = new StandardCalc();
    calculator = new RevPolCalc();
    calculator = new StandardCalc();
  }
  
  //test 1 evaluate RevPol.
  //Added implement to RevPolClass.
  //Modified change evaluate method in Calculator class. It won't take anymore argument boolean.
  @Test
  void evaluateReversePolishExpressiontest() throws InvalidExpression {
    
    String expression = "3 2 +";
    assertEquals(5f,calculator.evaluate(expression));
  }
  
  
  //test 2 evaluate StandardClac.
  //Added implement to StandardardCalc class.
  @Test
  void evaluateStandardCalcExpressiontest() throws InvalidExpression {
    
    String expression = "3 + 2";
    assertEquals(5f,calculator.evaluate(expression));
  }
  
//  //test 3 test unmatched parentheses
//  //this 
//  @Test
//  void UnMatchedParentheseStandardCalcstest() {
//    
//    String expression = "( 3 + 2";
//    assertThrows(InvalidExpression.class, () -> calculator.evaluate(expression));
//  }
//  
  
  
  
  }

