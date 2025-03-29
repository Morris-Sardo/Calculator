package application;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The meaning of this class is test all possible input the calculator model can have. the class
 * test hat calculator model class after got expression send the expression to the right handle
 * which type of from of calculation must be used. the class test also all the possible exception
 * cases.
 * 
 * @author papap
 *
 */
class CalcModelTest {


  private CalcModel calcMod;


  @BeforeEach
  void seUp() {
    calcMod = new CalcModel();
  }

  // test 1. This test implement standards calculation.
  // create field in Calculator, create Constructor and fixed return value to 5.
  // Improving test randomising the numbers.
  // Improved RevPolish class such hat it will return a number with 2 decimal point.
  @Test
  void evaluateStandCaldtest() throws InvalidExpression {

    String addExpre = "3 + 2";
    assertEquals(5f, calcMod.evaluate(addExpre, true));

    String subExpre = "6.3 - 2";
    assertEquals(4.3f, calcMod.evaluate(subExpre, true));

    String timeExpre = "6.3 * 2";
    assertEquals(12.6f, calcMod.evaluate(timeExpre, true));

    String divExpre = "6 / 2.8";
    assertEquals(2.14f, calcMod.evaluate(divExpre, true));


  }

  // test 2. This test implement Reverse polish calculation.
  // Improved RevPolish class such hat it will return a number with 2 decimal point.
  @Test
  void evaluateRevPolCalctest() throws InvalidExpression {

    String subExpre = "6 2 -";
    assertEquals(4f, calcMod.evaluate(subExpre, false));

    String divExpre = "6.3 2 +";
    assertEquals(8.3f, calcMod.evaluate(divExpre, false));

    String devExpre = "6 2.8 /";
    assertEquals(2.14f, calcMod.evaluate(devExpre, false));

    String timeExpre = "2 11 *";
    assertEquals(22f, calcMod.evaluate(timeExpre, false));



  }

  // test 3. Exception in standard form.
  // Test aim to test if an exception is throws all possible situation.

  @Test
  void ExceptionStandardFormtest() throws InvalidExpression {

    String lessOperator = "6 + 2 - 2.3 43"; // less operator.
    assertThrows(InvalidExpression.class, () -> calcMod.evaluate(lessOperator, true));

    String NotOper = "3 4";// no operator.
    assertThrows(InvalidExpression.class, () -> calcMod.evaluate(NotOper, true));

    String TooManyOper = "6.3 + 2 + / *"; // many operators.
    assertThrows(InvalidExpression.class, () -> calcMod.evaluate(TooManyOper, true));

    String Parenthesys1 = "((6 * 2.8) * 3"; // Mismatch parentheses.
    assertThrows(InvalidExpression.class, () -> calcMod.evaluate(Parenthesys1, true));

    String Parenthesys2 = "((6 * )2.8)))) * 3"; // Mismatch parentheses.
    assertThrows(InvalidExpression.class, () -> calcMod.evaluate(Parenthesys2, true));

    String devByZero = "6 / 0"; // by zero.
    assertThrows(InvalidExpression.class, () -> calcMod.evaluate(devByZero, true));

    String RevForm = "6 0 /"; // RevForm.
    assertThrows(InvalidExpression.class, () -> calcMod.evaluate(RevForm, true));



  }
  // test 4. Exception in reverse polish form.
  // Test aim to test if an exception is throws all possible situation.

  @Test
  void ExceptionReversePolishFormtest() throws InvalidExpression {

    String lessOperator = "6 2 2.3 43 + /"; // less operator.
    assertThrows(InvalidExpression.class, () -> calcMod.evaluate(lessOperator, false));

    String NotOper = "3.99 4"; // no operator.
    assertThrows(InvalidExpression.class, () -> calcMod.evaluate(NotOper, false));

    String TooManyOper = "6.3 + 2 + / * / / *"; // many operators.
    assertThrows(InvalidExpression.class, () -> calcMod.evaluate(TooManyOper, false));

    String Parenthesys = "((6 * 2.8) * 3"; // Parentheses no accepted.
    assertThrows(InvalidExpression.class, () -> calcMod.evaluate(Parenthesys, false));

    String devByZero = "6 0 /"; // by zero.
    assertThrows(InvalidExpression.class, () -> calcMod.evaluate(devByZero, false));

    String StandardForm = "6 0 /"; // StandardFrom.
    assertThrows(InvalidExpression.class, () -> calcMod.evaluate(StandardForm, false));

  }

}


