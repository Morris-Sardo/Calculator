package application;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
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

  @BeforeEach
  void setUp() {
    opStack = new OpStack();
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
  
    Symbol symbol = Symbol.DIVISION;
    opStack.push(symbol);
    Entry entry = opStack.top();
    assertEquals(symbol, entry.getSymbol());

    Symbol symbol1 = Symbol.INVALID; // obj crerated to do test 3.
    OpStack opStackSize = new OpStack(); // obj create to do test 3.

    assertNotEquals(opStack.size(), opStackSize.size());

    opStackSize.push(symbol1);
    assertEquals(opStack.size(), opStackSize.size());

  }

  // test 4 testing pop method/
  @Test
  void PopSymbolTest() {}


}
