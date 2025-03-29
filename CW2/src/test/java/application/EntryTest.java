package application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;
import org.junit.jupiter.api.Test;



/**
 * This class test all method, constructor, field and base cases. all of entry class.
 * 
 * @author papap
 *
 */
class EntryTest {


  @Test
  // test1 constructor String
  // create constructor.
  // create getString method that return string.
  // modified parameter that get random string.
  void costructorStringtest() throws BadType {
    Random rand = new Random();
    String[] arrString = {"a", "bracket", "ciao", "CAMILLO"};
    int randLength = rand.nextInt(4);
    Entry string = new Entry(arrString[randLength]);
    assertEquals(string.getString(), arrString[randLength]);
  }

  @Test
  // test 2 getString Throws badType exception if type is wrong.
  // create Entry float construct.
  // I added statement if(type != Type.STRING) will throws BadType exception.
  // modified test 1 adding throw exception statement.
  // I modified Entry constructor String such that the if statement coulf hadle the exception.
  void getStringThrowsBafTypeEsceptiontest() {
    Entry entry = new Entry(123.5f);
    BadType e = assertThrows(BadType.class, () -> entry.getString());
    assertEquals("It is not a string", e.getMessage());
  }

  @Test
  // test 3 getString Throws badType exception if type is wrong.
  // create getFloat() method.
  // add statement(type != Type.Float) will throws BadType exception.
  // add statement Throws BadType at the method.
  void getFloatThrowsBafTypeEsceptiontest() {
    Entry entry = new Entry("ciao");
    BadType e = assertThrows(BadType.class, () -> entry.getFloat());
    assertEquals("It is not a float number", e.getMessage());
  }

  @Test
  // test 4 getType() method.
  // create getType() method.
  void getTypeForStringEntry() throws BadType {
    Random rand = new Random();
    String[] arrString = {"a", "bracket", "ciao", "CAMILLO"};
    int randLength = rand.nextInt(4);
    Entry string = new Entry(arrString[randLength]);
    assertEquals(string.getType(), Type.STRING);
  }

  @Test
  // test 5 getType() method.
  // I added in Type type in constructor Entry float.
  void getTypeForFloatEntry() throws BadType {
    Random rand = new Random();
    float num = rand.nextFloat() * (float) 100.0;
    Entry number = new Entry(num);
    assertEquals(number.getType(), Type.FLOAT);
  }

  @Test
  // test 6 getType() method.
  // I added in Type type in constructor Entry float.
  // create getSymbol.
  void getTypeSymbolEntry() {

    Symbol[] symbol = {Symbol.LEFT_BRACKET, Symbol.RIGHT_BRACKET, Symbol.TIME, Symbol.DIVISION,
        Symbol.PLUS, Symbol.MINUS, Symbol.INVALID};

    int i = 0;
    do {
      Entry entry = new Entry(symbol[i]);
      assertEquals(entry.getType(), Type.SYMBOL);
      i++;
    } while (i < 7);
  }

  @Test
  // test 7 getSymbol Throws badType exception if Symbol is wrong
  // create getSymbol.
  // added statement if(type != Type.SYMBOL) to hanlde and wrong symbol.
  void geSymbolThrowsBadTyoe() {
    Entry entry = new Entry("ciao");
    BadType e = assertThrows(BadType.class, () -> entry.getSymbol());
    assertEquals("the symbol is wrong", e.getMessage());
  }


  @Test
  // test 8 test hashcode if two entry are the same..
  // created methods hashcode.
  // 1)I have initialise the prime number.
  // 2)Result is the result of operation between float number and a and prime number.
  // This method is good in terms of performance.
  // First hashcode is to compare float.
  void hashCodeFloattest() {
    Entry entry = new Entry(1.3f);
    Entry entry1 = new Entry(1.3f);
    Entry entry2 = new Entry(5.5f);
    assertEquals(entry.hashCode(), entry1.hashCode());
    assertNotEquals(entry.hashCode(), entry2.hashCode());

  }

  @Test
  // test 9 test hashcode if two entry are the same..
  // I had to add statement else if(type == Type.STRING).
  // add statement if(type == Type.Float).
  void hashCodeStringtest() {
    Entry entry = new Entry("ciao");
    Entry entry1 = new Entry("ciao");
    Entry entry2 = new Entry("bye");
    assertEquals(entry.hashCode(), entry1.hashCode());
    assertNotEquals(entry1.hashCode(), entry2.hashCode());

  }


  @Test
  // test 10 test hashcode if two entry are the same..
  // I add statement else if(type == Type.Symbol).
  void hashCodeSymboltest() {
    Entry entry = new Entry(Symbol.DIVISION);
    Entry entry1 = new Entry(Symbol.DIVISION);
    Entry entry2 = new Entry(Symbol.LEFT_BRACKET);
    assertEquals(entry.hashCode(), entry.hashCode());
    assertNotEquals(entry1.hashCode(), entry2.hashCode());

  }

  @Test
  // test 11 test equal equal method.
  // The method return true if two object are equal.
  // I had create a boolean method which take Object has argument.
  // I have casted input object has Entry
  // finally compared two same object.
  void equalSameObjecttest() {
    Entry entry = new Entry("hello");
    assertTrue(entry.equal(entry));
  }

  @Test
  // test 12 test equal equal method.
  // The method false if object is null.
  void equalNullFalse() {
    Entry entry = new Entry(1.3f);
    assertFalse(entry.equal(null));
  }


  @Test
  // test 13 test that two object are different type return false.
  // I add statement if(o.getClass() != this.getClass())
  void equalDifferentTypetest() {
    Entry entry = new Entry("ciao");
    String string = "ciao";

    assertFalse(entry.equal(string));
  }
}


