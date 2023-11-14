package application;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.util.Random;
import org.junit.jupiter.api.Test;

class StrStackTest {
    
  private StrStack numStack;
  private Entry entry;
  private Random value;
  
  
  //tes 1 create StrStack class.
  @BeforeEach
  void setup() {
    numStack = new StrStack();
    
    
  }
  
  //text 2 pup string into the stack.
  //To Create metod push(). I have to build:
  //size() and top().
  //size() to keep track the index encrease every time add a entry,
  //plus the size wwill be useful to as index when I will verify that 
  //the entry just pushed is has the top of the stack. I will build top()
  //for the purpose as well.
  //After create top() method TTD was failing as the throw exception were unhadled.
  
  @Test
  void puhStringtest() throws BadType, EmptyStack {
    
    value = new Random();
    String arr[] = {"+","?","/","*","!","ciao",""};
    int index = value.nextInt(arr.length - 1);  
    Entry entry = new Entry(arr[index]);
    numStack.push(entry);
    
    String retriveString = numStack.top().getString();
    
    assertEquals(entry.getString(),retriveString);
    
    assertEquals(1,numStack.size());
    
  }
  
  
    
  }
