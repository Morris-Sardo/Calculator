package application;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The meaning of this class is create methods in numStack class and all the methodos in the
 * NumStack class all its method will work using the the mothod of the Stack class. allexception
 * implemented into Stack class. In other world the the meaning is to implement numStack class as it
 * is a Stack class wiith the only capability to get only float number entry.
 * 
 * @author papap
 *
 */
class NumStackTest {

  private NumStack numStack;
  Random testValue;

  @BeforeEach
  void setUp() {
    numStack = new NumStack();
    testValue = new Random();
  }

  // test 1 test contructor. This test a fake test because it will return not null as java it always
  // create a defaoult constructor.
  @Test
  void NumStackConstructortest() {

    assertNotNull(numStack);
  }

  // test 1 check if push method exist.
  // test 2 sure the entry is right type. To implement test:
  // I create top method with in Entry type, and add all the declaration for all exception.
  // into pushTest() and puch(). Create entry object that get a float attribute.
  // Create object stack such that the method push in NumStak class will call push method
  // into Stack class.
  // I had to add BadType exception as I am using Entry class.
  // Refactor. Eliminated Entry object which retreave top entry on the stack. Test pass.
  @Test
  void Pushtest() throws EmptyStack, BadType {

    float randFloat = testValue.nextFloat() * (float) 100.0;
    numStack.push(randFloat);
    assertEquals(randFloat, numStack.top());

  }

  // test 3 check it if the exception throw the right text exception.
  // Refactor. Added BadType Exception. Test pass.
  @Test
  void topThrowsEmptyExceptionWhenEmpty() throws EmptyStack, BadType {

    float randFloat = testValue.nextFloat() * (float) 100.0;
    numStack.push(randFloat);
    assertDoesNotThrow(() -> numStack.top());
    numStack.pop();
    EmptyStack e = assertThrows(EmptyStack.class, () -> numStack.top());
    assertEquals("Stack is Empty", e.getMessage());

  }

  // test 5 is create pop method in NumStack class.
  // I started to create size method such that every time push some thing into the stack the size
  // will increase.
  // Next, I have created pop method. To do so i had to add also all the exception(confirming the
  // also
  // pop method in numStack retreave the functionality of the pop method in Stack class.
  // Finally i ad to add Badtype exception as popEntryt i have use getFloat() that has BadTyoe as
  // exception.
  // Refactor. Eliminated Entry object used to retrieve the using pop method.
  @Test
  void Poptest() throws EmptyStack, BadType {

    float randFloat = testValue.nextFloat() * (float) 100.0;
    numStack.push(randFloat);
    assertEquals(1, numStack.size());

    float randFloat1 = testValue.nextFloat() * (float) 100.0;
    numStack.push(randFloat1);
    assertNotEquals(1, numStack.size());

    assertEquals(randFloat1, numStack.pop());


  }


}
