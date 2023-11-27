package application;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The meaning of this class is test that StandardClac and RevPolishCalc class.
 * Calculator one.
 * 
 * @author papap
 *
 */
class CalculatorTest {

  private Calculator revCalc; // change after update StandaCalc
  private Calculator standCalc; //change after update StandaCalc

  @BeforeEach
  void setUp() {
    // calculator = new StandardCalc();
    revCalc = new RevPolCalc();
    standCalc = new StandardCalc();
  }

  // test 1 evaluate RevPol.
  // Added implement to RevPolClass.
  // Modified change evaluate method in Calculator class. It won't take anymore argument boolean.
  
  // Update Name after modification in StandardCalc class.
  @Test
  void evaluateReversePolishExpressiontest() throws InvalidExpression {

    String expression = "3 2 +";
    assertEquals(5f, revCalc.evaluate(expression));
  }


  // test 2 evaluate StandardClac.
  // Added implement to StandardardCalc class.
  
  // Update Name after modification in StandardCalc class.
  @Test
  void evaluateStandardCalcExpressiontest() throws InvalidExpression {

    String expression = "3 + 2";
    assertEquals(5f, standCalc.evaluate(expression));
  }

  // test 3 test unmatched parentheses.
  // this test was a fake test.
  // the meaning of it was proves the Calculator class hereditary all capability of the StandardCalc
  // class.
  
  // Update Name after modification in StandardCalc class.
  @Test
  void UnMatchedParentheseStandardCalcstest() {

    String expression = "( 3 + 2 )";
    assertDoesNotThrow(() -> standCalc.evaluate(expression));
    String expression1 = "(33 + 3";

    assertThrows(InvalidExpression.class, () -> standCalc.evaluate(expression1));

  }

  // test 4
  // this is another fake test. test Calculator class throw exception that RevPolCalc class should
  // be.
  
  // Update Name after modification in StandardCalc class.
  @Test
  void InsufficientOperandRevPishCalc() {

    String expression = "33 3 +";
    assertDoesNotThrow(() -> revCalc.evaluate(expression));
    String expression1 = "33 + -";
    assertThrows(InvalidExpression.class, () -> revCalc.evaluate(expression1));


  }

  // test 5.
  // Evalute a expression with an invalid opererator.
  // the test will considerate cthe case of both classes( RevPolCalc and StandardCalc class).

  @Test
  void InvalidOperatortest() {

    String expression = "33 + 3 & 22 ";
    assertThrows(InvalidExpression.class, () -> standCalc.evaluate(expression));
    String expression1 = "33 - 4 + 8";
    assertDoesNotThrow(() -> standCalc.evaluate(expression1));


    String expression2 = "33 4 + ?";
    assertThrows(InvalidExpression.class, () -> revCalc.evaluate(expression2));
    String expression3 = "33 4 3 + *";
    assertDoesNotThrow(() -> revCalc.evaluate(expression3));


  }



}

