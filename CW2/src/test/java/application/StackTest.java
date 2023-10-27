package application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Random;
import org.junit.jupiter.api.Test;


/**
 * This class test all the method, field and base case of the Stack class.
 * 
 * @author papap
 *
 */
class StackTest {

  private Stack stack = new Stack(); // is use to inizialise array into Stack class.



  @Test
  // test 1 encrease size.
  // create push method.
  // create size method.
  // create a List entry.
  // into the push method to to add entry into entry list i use add method.
  void encreaseSizetest() throws BadType {

    Entry entry = new Entry("ciao");
    stack.push(entry);
    assertEquals(stack.size(), 1);
  }

  @Test
  // test 2 ensure that the entry of the top stack is the same of the last entry.
  // create top() method that return entry of top of the Stack.
  void topStringOnStackIsSameLastEntryPushedtest() throws EmptyStack, BadType {
    Random rand = new Random();
    String[] arrString = {"a", "bracket", "ciao", "CAMILLO"};
    int randLength = rand.nextInt(4);
    Entry string = new Entry(arrString[randLength]);
    stack.push(string);
    Entry top = stack.top();
    assertEquals(string, top);

    Random rand1 = new Random();
    float randFloat = rand1.nextFloat() * (float) 100.0;
    Entry entry = new Entry(randFloat);
    stack.push(entry);
    Entry top1 = stack.top();
    assertEquals(entry, top1);
  }

  @Test
  // test 3 throw EmptyStack exception if try retreave an entry when stack is empty.
  // create EmptyStack exception class.
  // add if( size == 0) will throws exception.
  // added Throws exception statement on the the method.
  // modified test 2 Add EmptyStack exception.
  void topThrowsEmptyExceptionWhenStackIsEmptytest() {
    EmptyStack e = assertThrows(EmptyStack.class, () -> stack.top());
    assertEquals("Stack is Empty", e.getMessage());

  }

  @Test
  // test 4 return last entry and decrease size of one.
  // create method pop().
  // store the last entry added in tmp variable.
  // remove last entry from the array.
  // deacrease of of one size.
  // return value of the tmp varible.
  void returnLastElementAddedAndDrecreaseOnetest() throws BadType, EmptyStack {
    Entry entry = new Entry("hi");
    Entry entry1 = new Entry("bye");
    stack.push(entry);
    stack.push(entry1);
    Entry pop = stack.pop();
    assertEquals(entry1, pop);

  }

  @Test
  // test 5 throw EmptyStack exception if pop() retreave an entry when stack is empty.
  // if if(size == 0 or size == 1) will throws EmptyStack exception.
  // modified test 4 adding EmptyStack exception statement c.
  void popThrowsEmptyExceptionWhenStackIsEmptytest() {
    EmptyStack e = assertThrows(EmptyStack.class, () -> stack.pop());
    assertEquals("Stack is Empty", e.getMessage());

  }


  @Test
  // test 6 return the right right value of size every time the stack is being eancrease or decrease
  // for this test i did not need to change any things on Stack class.
  void keepTrackOfSizetest() throws BadType, EmptyStack {

    int i = 0;
    do {
      Random rand = new Random();
      String[] arrString = {"a", "bracket", "ciao", "CAMILLO"};
      int randLength = rand.nextInt(4);
      Entry string = new Entry(arrString[randLength]);
      stack.push(string);


      i++;
    } while (i < 10);
    assertEquals(stack.size(), 10);

    i = 0;
    do {
      Random rand = new Random();
      String[] arrString = {"a", "bracket", "ciao", "CAMILLO"};
      int randLength = rand.nextInt(4);
      Entry string = new Entry(arrString[randLength]);
      stack.push(string);


      i++;
    } while (i < 10);
    assertNotEquals(stack.size(), i);


  }

}