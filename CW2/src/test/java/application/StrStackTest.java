package application;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
  void puhStringtest() throws BadType, EmptyStack {

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
  
  
  //test 4 pop() method.
  //Test fail but prove prove that the top throw exception if call 
  //top method when stack is empty.
  @Test
  void topWhenStackIsEmptytest() throws EmptyStack {
    
    entry  = new Entry("Cioa");
    numStack.push(entry);
    numStack.top();
    
  }
}

