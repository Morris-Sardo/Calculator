package application;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
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
  
  //test 3 test unmatched parentheses.
  //this test was a fake test.
  //the meaning of it was proves the Calculator class hereditary all capability of the StandardCalc class.  
  @Test
  void UnMatchedParentheseStandardCalcstest() {
    
    String expression = "( 3 + 2 )";
    assertDoesNotThrow(() -> calculator.evaluate(expression));
    String expression1 = "(33 + 3";
   
    assertThrows(InvalidExpression.class, ()-> calculator.evaluate(expression1));
   
  }
  
  //test 4
  //this is another fake test. test Calculator class throw exception that RevPolCalc class should be.
  @Test
  void InsufficientOperandRevPishCalc() {
    
    String expression = "33 3 +";
    assertDoesNotThrow(()-> calculator.evaluate(expression));
    String expression1 = "33 + -";
    assertThrows(InvalidExpression.class,()->calculator.evaluate(expression1));
    
    
  }
  
  //test 5.
  //Evalute a expression with an invalid opererator.
  //the test will considerate cthe case of both classes( RevPolCalc and StandardCalc class).

  @Test
  void InvalidOperatortest() {
    
    String expression = "33 + 3 & 22 ";
    assertThrows(InvalidExpression.class,()->calculator.evaluate(expression));
    String expression1 = "33 - 4 + 8";
    assertDoesNotThrow(()-> calculator.evaluate(expression1));
    
    
    String expression2 = "33 4 + ?";
    assertThrows(InvalidExpression.class,()->calculator.evaluate(expression2));
    String expression3 = "33 4 3 + *";
    assertDoesNotThrow(()-> calculator.evaluate(expression3));
    
    
  }
  
 
  
  
  
  }

