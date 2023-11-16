package application;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.Random;
import org.junit.jupiter.api.Test;

class StrStackTest {

  private StrStack numStack;
  private Entry entry;
  private Random value;


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

  @Test
  void PuhStringtest() throws BadType, EmptyStack {

    value = new Random();
    String arr[] = {"+", "?", "/", "*", "!", "ciao", ""};
    int index = value.nextInt(arr.length - 1);
    entry = new Entry(arr[index]);
    numStack.push(entry);

    String retriveString = numStack.top().getString();

    assertEquals(entry.getString(), retriveString);

    assertEquals(1, numStack.size());

  }

  // test 3 create size method.
  // The method has been created during test2.
  // test 4 I have create a loop to confirm the the size increase properly.
  // test 5 I Have create another loop to confirm the size decree are proprerly.
  // To do so I must implement pop method.
  @Test
  void SizeMethodIncreaseProperlytest() throws EmptyStack {


    String arr[] = {"+", "?", "/", "*", "!", "ciao", ""};
    for (int i = 0; i < arr.length; i++) {

      entry = new Entry(arr[i]);
      numStack.push(entry);
    }

    assertEquals(numStack.size(), (arr.length));

    int counter = arr.length;
    for (int i = counter - 1; i >= 0; i--) {
      assertEquals(numStack.size(), i + 1);
      entry = new Entry(arr[i]);
      numStack.pop();

    }
  }
  
  
  //test 6 top() method.
  //To pass the test i add option throw axception.
  @Test
  void TopThrowExceptionWhenStackIsEmptytest() throws EmptyStack {
    
    
    EmptyStack e = assertThrows(EmptyStack.class, () -> numStack.top());
    assertEquals("Stack is Empty", e.getMessage());

    
    
  }
  
  //test 7 top() verified the top element is the last push int.
  @Test
  void TopTheLastIsTheActuallyTopOnetest() throws BadType, EmptyStack {
    
    entry = new Entry("Ciao");
    numStack.push(entry);
    assertEquals(entry.getString(),numStack.top().getString());
    
  }
  
  //test 8 pop()
  //this test when the exception is throws if the stack is empty.
  
  @Test
  void PopThrowExceptiontest() throws EmptyStack {
    
    entry = new Entry("Ciao");
    numStack.push(entry);
    
    assertDoesNotThrow(() -> numStack.pop()); //Exception is not throws..
   
    EmptyStack e = assertThrows(EmptyStack.class, () -> numStack.pop());  // the extception is throws
    assertEquals("Stack is Empty", e.getMessage());
  }
  
}

