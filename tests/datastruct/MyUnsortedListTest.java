package datastruct;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyUnsortedListTest {
	private String testString = "test";
	protected MyUnsortedList ul;
	@Before
	public void setUp() throws Exception {
		ul = MyUnsortedList.of();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test 
	public void testOf() {
		Integer[] l = {1, 2, 3, 4};
		assertNotNull(MyUnsortedList.of(l));
		assertNotNull(ul);
	}
	@Test
	public void testIsEmpty() {
		assertTrue("Test : Verification d'une liste vide == vide", ul.isEmpty());
		ul = MyUnsortedList.of(testString);
		assertFalse("Test : Verification d'une liste non vide == vide", ul.isEmpty());
	}
	
	@Test
	public void testSize() {
		MyUnsortedList<String> empty_list = MyUnsortedList.of();
		MyUnsortedList<String> generic_list = MyUnsortedList.of("Un", "Deux", "Trois", "Quatre", "Cinq");
		assertEquals("Test : Verification que empty_list.size == 0", empty_list.size(),0);
		assertEquals("Test : Verification que generic_list.size == 5", generic_list.size(),5);

	}
	
	@Test
	public void testPrepend() {
		MyUnsortedList<String> generic_list = MyUnsortedList.of("Un","Deux","Trois","Quatre","Cinq");
		generic_list.prepend("Zero");
		assertEquals("Test : Verification de testPrepend avec liste non vide :",
				generic_list,MyUnsortedList.of("Zero", "Un", "Deux", "Trois", "Quatre", "Cinq"));
	
		generic_list = MyUnsortedList.of();
		generic_list.prepend("Zero");
		assertEquals("Test : Verification de testPrepend avec liste non vide :",
				generic_list, MyUnsortedList.of("Zero"));

	}
	
	@Test
	public void testAppend() {
		MyUnsortedList<String> generic_list = MyUnsortedList.of("Zero","Un");
		generic_list.append("Deux");
		assertEquals("Test : Verification de testAppend avec une liste non Vide", generic_list, MyUnsortedList.of("Zero", "Un", "Deux"));
		generic_list = MyUnsortedList.of();
		generic_list.append("Zero");
		assertEquals("Test : Verification de testAppend avec une liste non Vide", generic_list, MyUnsortedList.of("Zero"));

	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testInsertOutOfBounds() throws IndexOutOfBoundsException{
		MyUnsortedList<String> generic_list = MyUnsortedList.of();
		generic_list.insert("Test",85);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testInsertNegativeIndex() throws IndexOutOfBoundsException{
		MyUnsortedList<String> generic_list = MyUnsortedList.of();
		generic_list.insert("Test",-1);
	}
	
	@Test
	public void testInsertion() {
		MyUnsortedList<Integer> generic_list = MyUnsortedList.of();
		generic_list.insert(2,0);
		assertEquals("Test : Insertion dans une liste vide",generic_list, MyUnsortedList.of(2));
		generic_list.insert(1,0);
		assertEquals("Test : Insertion début de liste",generic_list, MyUnsortedList.of(1,2));
		generic_list.insert(8,generic_list.size());
		assertEquals("Test : Insertion dans une liste vide",generic_list, MyUnsortedList.of(1,2,8));
		generic_list.insert(4,2);
		assertEquals("Test : Insertion dans une liste vide",generic_list, MyUnsortedList.of(1,2,4,8));
		
	}
	
	
	@Test(expected = EmptyListException.class)
	public void testEmptyListPop() throws Exception{
		MyUnsortedList<Integer> empty_list = MyUnsortedList.of();
		empty_list.pop();
	}
	
	@Test(expected = EmptyListException.class)
	public void testEmptyListPopLast() throws Exception{
		MyUnsortedList<Integer> empty_list = MyUnsortedList.of();
		empty_list.popLast();
	}

	@Test
	public void testPop(){
		MyUnsortedList<Integer> generic_list = MyUnsortedList.of(1,2);
		int res = generic_list.pop();
		assertEquals("Test : pop avec une liste contenant plus d'une seule valeur", res, 1);
		res = generic_list.pop();
		assertEquals("Test : pop avec une liste contenant plus d'une seule valeur", res, 2);
	}
	
	@Test
	public void testPopLast(){
		MyUnsortedList<Integer> generic_list = MyUnsortedList.of(1,2);
		int res = generic_list.popLast();
		assertEquals("Test : popLast avec une liste contenant plus d'une seule valeur", res,2);
		res = generic_list.popLast();
		assertEquals("Test : popLast avec une liste contenant plus d'une seule valeur", res,1);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemoveOutOfBounds() throws Exception{
		MyUnsortedList<Integer> generic_list = MyUnsortedList.of(1,2);
		generic_list.remove(-1);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testEmptyListRemove() throws Exception{
		MyUnsortedList<Integer> generic_list = MyUnsortedList.of();
		generic_list.remove(0);
	}
	
	@Test
	public void testRemove() {
		MyUnsortedList<Integer> generic_list = MyUnsortedList.of(0,1,2,3,4);
		int res = generic_list.remove(0);
		assertEquals("Test : Remove sur un element en début de liste", res,0);
		res = generic_list.remove(generic_list.size()-1);
		assertEquals("Test : Remove sur un element en fin de liste", res,4);
		res = generic_list.remove(1);
		assertEquals("Test : Remove sur un element quelconque dans la liste", res,2);

	}
	
	@Test
	public void testEquals() {
		MyUnsortedList liste_1 = MyUnsortedList.of();
		MyUnsortedList liste_2 = MyUnsortedList.of();
		assertTrue(liste_1.equals(liste_2));				
		assertTrue(liste_2.equals(liste_1));

		liste_1 = MyUnsortedList.of(237,54,63);
		liste_2 = MyUnsortedList.of(237,54,63);
		assertTrue(liste_1.equals(liste_2));
		assertTrue(liste_2.equals(liste_1));

		liste_2 = MyUnsortedList.of(237,54,63,38);
		assertFalse(liste_1.equals(liste_2));
		assertFalse(liste_2.equals(liste_1));
	}
}
