package application;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import java.util.Random;
import org.junit.jupiter.api.Test;

/**
 * The meaning of this class is test that the the functionality of the method if the class inherit
 * the functionality of the Stacks class method.
 * 
 * @author papap
 *
 */
class OpStackTest {

  private OpStack opStack;
  private Symbol symbol;
  private Random value;

  // Inizialize all the objext into its body At all methods.
  @BeforeEach
  void setUp() {
    opStack = new OpStack();
    value = new Random();


  }

  // test 1 test if constructor exist. to do so i will inizialize obj opstack.
  // This test is a fake test as java provide a default constructor anyway.
  @Test
  void Constructortest() {

    assertNotNull(opStack);

  }

  // test 2 testing push method.
  // To do so i had to add push and top method in the OpStack class.
  // I had to add trhows BadRype(about opStack.push(symbol)) and EmptyStack(about opStack.top()).
  // All those this exception has been inherited from the methods of Stack class.
  // test 3 the index of the stack is releted to the last push( this test can confirm that the size
  // work prorerly).

  @Test
  void PushSymboltest() throws BadType, EmptyStack { // refactor.

    // array used to compare symbol.
    Symbol arr[] = {Symbol.LEFT_BRACKET, Symbol.DIVISION, Symbol.MINUS, Symbol.PLUS,
        Symbol.RIGHT_BRACKET, Symbol.TIME};

    // array used to compaare symbol.
    Symbol arr1[] = {Symbol.LEFT_BRACKET, Symbol.DIVISION, Symbol.MINUS, Symbol.PLUS,
        Symbol.RIGHT_BRACKET, Symbol.TIME};

    int index = value.nextInt(arr.length - 1); // random index
    int index1 = value.nextInt(arr1.length - 1); // random index.

    opStack.push(arr[index]); // push symbol into the the stack.
    // entry = opStack.top(); // retrive symbol at the top of the stack.

    // the statement compare say if the two symbol are equal use assertEquals() otherwise
    // assertNotEqual().
    if (arr1[index1].equals(opStack.top()))
      // assertEquals(arr1[index1].toString(), opStack.top()); //modification.
      assertEquals(arr1[index1], opStack.top());
    else
      assertNotEquals(arr1[index1], opStack.top()); // modification.



    Symbol symbol1 = Symbol.INVALID; // obj crerated to do test 3.
    OpStack opStackSize = new OpStack(); // obj create to do test 3.

    assertNotEquals(opStack.size(), opStackSize.size());

    opStackSize.push(symbol1);
    assertEquals(opStack.size(), opStackSize.size());

  }

  // test 4 testing pop method.
  // create pop method.
  // Add all exception's declaration.
  // I have to fixed the method pop into the stack class as it was throwing the exception
  // when the stack had 1 itme instead then zero.
  // refactor. change top from entry type to symbol.


  @Test
  void PopSymbolTest() throws EmptyStack, BadType { // refactor. change top from entry type to
                                                    // symbol.

    Symbol symbol = Symbol.DIVISION;
    opStack.push(symbol);
    // entry = opStack.top();
    assertEquals(1, opStack.size()); // confirm the the element has been add into the stack.
    opStack.pop();
    assertEquals(0, opStack.size()); // confirm the pop stack work proerly.

  }

  @Test
  // test 6 throw EmptyStack exception if pop()
  // this test it will throws an exception when the itme insert is not the right one.
  // Refactor. add BadType exception.
  void popThrowsEmptyStackExceptiontest() throws EmptyStack, BadType {

    symbol = Symbol.LEFT_BRACKET;
    opStack.push(symbol);
    assertDoesNotThrow(() -> opStack.top());
    opStack.pop();
    EmptyStack e = assertThrows(EmptyStack.class, () -> opStack.pop());
    assertEquals("Stack is Empty", e.getMessage());

  }



}
