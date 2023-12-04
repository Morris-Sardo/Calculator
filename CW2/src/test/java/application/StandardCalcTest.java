package application;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;


/**
 * The meaning of this class is testing all possible operations allowed by the calculator and to
 * test the various possible faults.
 * 
 * @author papap
 *
 */
class SandardCalcTest {


  StandardCalc calc = new StandardCalc();

  // test 1
  // I have create class StandardCalss class.
  // Create created hashmap such that it will keep track of priority of operator.
  // use a BuilderString to save the expression converted in Reverse polish on.
  // I used queue such that the operand i could push and pop of both side(this is good
  // because if a operand was behind to another one it could push it into from the another side of
  // it).
  // Inside the loop various if and else statement with some of them with while loop.
  // In addition the loop check if element is operand or operator. If it s a operator check in
  // hashmap
  // which propriety has(Higher number higher priority) and add them in the back of number into
  // BuildString.
  // If it s parenthesis check group all numbers and operator into it.
  // Is is been throw an exception if a parenthesis is mismatched.
  @Test
  void AdditionTest() throws InvalidExpression {

    assertEquals(61f, calc.evaluate("2 * 32 + 3 - 6"));
  }

  // test 2
  // evaluate long expression with addition of parentheses.

  @Test
  void LongAdditionTest() throws InvalidExpression {

    assertEquals(10f, calc.evaluate("( 2 * 3 ) + 4"));
  }


  // test 3
  // test if expression implemented by StandardCalc is compatible
  // with RevPolCalss class.
  // Modified evaluate method form string to float.
  // create constructor use to initialise RevPolCalc's object.
  // Test 1 and test 2 now are failed as evaluate type is not String anymore.

  @Test
  void StandCalcCompatibleWithRevPolCalctest() throws InvalidExpression {

    assertEquals(5.4f, calc.evaluate("3.2 + 2.2"));
    assertEquals(7f, calc.evaluate("5 + 2"));
  }


  // test 4
  // mismatch operand.
  // this test testing it the operand are less then suppose to many.
  @Test
  void MismatchOperandtest() {

    assertDoesNotThrow(() -> calc.evaluate("2 + 3"));
    assertThrows(InvalidExpression.class, () -> calc.evaluate("2 + + 3"));
    assertThrows(InvalidExpression.class, () -> calc.evaluate("2 * 3 4"));
    // Exception e = assertThrows(InvalidExpression.class, () -> calc.evaluate("2 * 3 4"));
    // e.getMessage()


  }

  // test 5
  // mismatch parentheses.
  // Update the test such that it will verify the message the exception.
  @Test
  void MismatchParenthesestest() {

    assertDoesNotThrow(() -> calc.evaluate("4 / 2"));
    assertThrows(InvalidExpression.class, () -> calc.evaluate("( ( ( (2 / 4 * 4 ) + 3 ) - 6"));
    assertDoesNotThrow(() -> calc.evaluate("( ( ( ( 2 / 4 * 4 ) + 3 ) - 6 ) )"));
    assertThrows(InvalidExpression.class, () -> calc.evaluate(") ) ( (2 / 4 * 4 ) + 3 ) - 6"));
    Exception e = assertThrows(InvalidExpression.class, () -> calc.evaluate("( 2 * 3 4"));
    assertEquals("Invalid Expression", e.getMessage());

  }

  // test 6.
  // added test to handle if expression typed was in reverse polish.
  // to do so I had I added boolean variable which change if state every time that loop find
  // two consecutive numbers.
  // I update also test 5 about the return message.
  // I had to modify test in CalculatorTest class.
  @Test
  void Revtest() {

    assertThrows(InvalidExpression.class, () -> calc.evaluate("2 3 +"));
  }



}

