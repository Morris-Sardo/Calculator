package application;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
//import java.util.Random;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import java.util.Random;
import org.junit.jupiter.api.Test;

/**
 * The meaning of this class is test that the the functionality of the method if the class iherit
 * the functionality of the Stacks class method.
 * 
 * @author papap
 *
 */
class OpStackTest {

  private OpStack opStack;
  private Entry entry;
  private Symbol symbol;
  private Random value;
  
  //Inizialize all the objext into its body At all methods.
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
  // test 3 the index of the stack is releted to the last push( this est can confirm prt of the size
  // test method as well).
  @Test
  void PushSymboltest() throws BadType, EmptyStack {
    
    
    //inproving making it generic.
    //int index = value.nextInt(6);
    Symbol arr[] = {Symbol.LEFT_BRACKET, Symbol.DIVISION, Symbol.MINUS, Symbol.PLUS, Symbol.RIGHT_BRACKET,
        Symbol.TIME}; 
    
    int index = value.nextInt(arr.length - 1);
    //symbol = Symbol.DIVISION;
    opStack.push(arr[index]);
    entry = opStack.top();
    assertEquals(symbol, entry.getSymbol());

    Symbol symbol1 = Symbol.INVALID; // obj crerated to do test 3.
    OpStack opStackSize = new OpStack(); // obj create to do test 3.

    assertNotEquals(opStack.size(), opStackSize.size());

    opStackSize.push(symbol1);
    assertEquals(opStack.size(), opStackSize.size());

  }

  // test 4 testing pop method.
  //create pop method.
  //Add all exception's declaration.
  //I have to fixed the method pop into the stack class as it was throwing the exception 
  //when the stack had 1 itme instead then zero.
  
  @Test
  void PopSymbolTest() throws EmptyStack, BadType {
    
    Symbol symbol = Symbol.DIVISION;
    opStack.push(symbol);
    entry = opStack.top();
    assertEquals(1 , opStack.size()); //confirm the the element has been add into the stack.
    opStack.pop();
    assertEquals(0, opStack.size()); //confirm the pop stack work proerly.
    
  }
  
  @Test
  // test 5 throw EmptyStack exception if pop() 
  //This method before test that exception is not throws if a symbol when item is right.
  //then i added statement the cinfirm the the exception is been throw whe is not right.
 void popThrowsBadTypeExceptiontest() {
   
    //improvit makig all the test random
    symbol = Symbol.LEFT_BRACKET;
    opStack.push(symbol);
    assertDoesNotThrow(() -> opStack.top());
    BadType e = assertThrows(BadType.class, () -> opStack.pop().getString());
    assertEquals("It is not a string", e.getMessage());

  }
  
  @Test
  // test 6 throw EmptyStack exception if pop() 
  // this test it will throws an exception when the itme insert is not the right one.
 void popThrowsEmptyStackExceptiontest() throws EmptyStack {
    
    
    //try maki it generic.
    symbol = Symbol.LEFT_BRACKET;
    opStack.push(symbol);
    assertDoesNotThrow(() -> opStack.top());
    opStack.pop();
    EmptyStack e = assertThrows(EmptyStack.class, () -> opStack.pop());
    assertEquals("Stack is Empty", e.getMessage());

  }
  


}
