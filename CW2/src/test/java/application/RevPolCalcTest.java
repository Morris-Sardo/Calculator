package application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The meaning of this class is testing all possible operations allowed by the calculator and to
 * test the various possible faults.
 * 
 * @author papap
 *
 */
class RevPolCalcTest {

  Random number = new Random();
  private RevPolCalc polCal;
  private String firstOp;
  private String secondOp;
  private int index;
  private int index2;
  private float result;

  @BeforeEach
  void setup() {
    polCal = new RevPolCalc();
    String[] arr = {"0", "1", "2", "3", "40", "33", "345", "22", "-1", "-2", "-3", "2"};
    index = number.nextInt(arr.length);
    index2 = number.nextInt(arr.length);
    firstOp = arr[index];
    secondOp = arr[index2];


  }

  // test 1 if class exist.
  // change test such that the object does not get any argument
  @Test
  void RevPolClacClasstest() {

    polCal = new RevPolCalc();

  }

  // test 2 if constructor evaluate expression and store result.
  // Create constructor and getResult() method.
  // Modified test 1( added agrguement).
  // test 3 add return different value.
  // added throw exception in test 1.

  // Update method. deleted the parameter into the obj and deleted the getResult() method.
  // this update i the methods are free from BadType and EmptyStack exception.
  // this modification has been done at all test.
  @Test
  void EvalutateExpressionAdditiontest() throws InvalidExpression {


    float result = Float.parseFloat(firstOp) + Float.parseFloat(secondOp);
    assertEquals(result, polCal.evaluate(firstOp + " " + secondOp + " " + "+"));


    assertEquals(15f, polCal.evaluate("5 1 2 + 4 + + 3 + "));

  }

  // test 4 test subtraction operation.
  // Added case "-" is switch statement.
  // test 5 create random entries. Generalise the the method.
  @Test
  void EvalutateExpressionSubtractiontest() throws InvalidExpression {

    float result = Float.parseFloat(firstOp) - Float.parseFloat(secondOp);
    assertEquals(result, polCal.evaluate(firstOp + " " + secondOp + " " + "-"));

    assertEquals(1f, polCal.evaluate("4 3 -"));
    assertNotEquals(7.2f, polCal.evaluate("4 3 -"));

    assertEquals(6f, polCal.evaluate("5 1 2 - - "));

  }

  // test 6 test multiplication operation.
  // test added case"*" in switch statement.
  @Test
  void EvalutateExpressionMotilplicatiThrowsExceptiontest() throws InvalidExpression {

    float result = Float.parseFloat(firstOp) * Float.parseFloat(secondOp);
    assertEquals(result, polCal.evaluate(firstOp + " " + secondOp + " " + "*"));


  }

  // test 7 test division.
  // added case"/" in switch state.
  // added if statement in case"/" to handle the InvalidExpression.
  // the exception is throw is secondOp == 0.
  @Test
  void EvalutateExpressionDivisiontest() throws InvalidExpression {



    assertThrows(InvalidExpression.class, () -> polCal.evaluate(firstOp + " 0 " + "/"));

    result = Float.parseFloat(firstOp) / Float.parseFloat(secondOp);
    assertEquals(result, (polCal.evaluate(firstOp + " " + secondOp + " " + "/")));


  }

  // test 8 test excess of operand.
  // Modified code such the it handles empty stack exception.
  // Modified test 2,3,4,5,6,7. Delete EmptyStack exception declaration.
  @Test
  void evaluateExpressionWithInsufficientOperandstest() {
    assertThrows(InvalidExpression.class, () -> polCal.evaluate("1 +"));
  }

  // test 9
  // Added statement If(number.size() != 1). the statement say that if in the and o
  // of computation NumStack is more the 1 than means there are not enough operands.
  @Test
  void evaluateExpressionWithInsuffiOperandstest() {
    assertThrows(InvalidExpression.class, () -> polCal.evaluate("1 2 3 +"));
  }


  // test 10.
  // This test straight passed.
  // This test has been created to test edge cases.
  @Test
  void evaluateWithInsufficientOperands() {
    assertThrows(InvalidExpression.class, () -> polCal.evaluate("+"));
  }

  // test 11
  // This test straight passed.
  // This test has been created to test if an a value is not right.
  @Test
  void evaouateWithInvalidToken() {
    assertThrows(InvalidExpression.class, () -> polCal.evaluate("2 4 5 &"));
  }


}


