package application;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.Random;
import org.junit.jupiter.api.Test;

/**
 * The meaning of this class is test that the the functionality of the method if the class inherit
 * the functionality of the Stacks class method.
 * 
 * @author papap
 *
 */
class StrStackTest {

  private StrStack numStack;
  //private Entry entry;
  private Random value; // it use to strore random number.



  // tes 1 create StrStack class.
  @BeforeEach
  void setup() {
    numStack = new StrStack();


  }

  // text 2 pup string into the stack.
  // To Create metod push(). I have to build:
  // size() and top().
  // size() to keep track the index encrease every time add a entry,
  // plus the size wwill be useful to as index when I will verify that
  // the entry just pushed is has the top of the stack. I will build top()
  // for the purpose as well.
  // After create top() method TTD was failing as the throw exception were unhadled.
  // Fixed bug. change argument from Entry type to String.
  // Refactor. Added BadType declaration plus and the retrived string form Entry ot String one.
  // Test pass now.
  @Test
  void PuhStringtest() throws BadType, EmptyStack {  

    value = new Random();
    String arr[] = {"+", "?", "/", "*", "!", "ciao", ""};
    int index = value.nextInt(arr.length - 1);
    numStack.push(arr[index]);

    String retriveString = numStack.top().toString();

    assertEquals(arr[index].toString(), retriveString);

    assertEquals(1, numStack.size());

  }

  // test 3 create size method.
  // The method has been created during test2.
  // test 4 I have create a loop to confirm the the size increase properly.
  // test 5 I Have create another loop to confirm the size decree are proprerly.
  // To do so I must implement pop method.
  // Refactor test. Added BadType declaration, the array alement are not converted anymore to Entry.
  // Test pass.
  @Test
  void SizeMethodIncreaseProperlytest() throws EmptyStack, BadType {


    String arr[] = {"+", "?", "/", "*", "!", "ciao", ""};
    for (int i = 0; i < arr.length; i++) {

      numStack.push(arr[i]);
    }

    assertEquals(numStack.size(), (arr.length));

    int counter = arr.length;
    for (int i = counter - 1; i >= 0; i--) {
      assertEquals(numStack.size(), i + 1);
      numStack.pop();

    }
  }


  // test 6 top() method.
  // To pass the test i add option throw axception.
  @Test
  void TopThrowExceptionWhenStackIsEmptytest() throws EmptyStack {


    EmptyStack e = assertThrows(EmptyStack.class, () -> numStack.top());
    assertEquals("Stack is Empty", e.getMessage());



  }

  // test 7 top() verified the top element is the last push int.
  //Refactor. from push and entry string into stack now I straight push in as String.
  //Test pass now.
  @Test
  void TopTheLastIsTheActuallyTopOnetest() throws BadType, EmptyStack {

    numStack.push("Ciao");
    assertEquals("Ciao", numStack.top().toString());

  }

  // test 8 pop()
  // this test when the exception is throws if the stack is empty.
  // Refactort the same change as previuos test.
  // test as well.
  @Test
  void PopThrowExceptiontest() throws EmptyStack {

    numStack.push("Ciao");

    assertDoesNotThrow(() -> numStack.pop()); 

    EmptyStack e = assertThrows(EmptyStack.class, () -> numStack.pop());
    assertEquals("Stack is Empty", e.getMessage());
  }

}

