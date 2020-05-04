
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.Random;

public class LinkedListDTest{
	LinkedListD<Integer> testList = null;
	
	private static final int LOOPS = 10000;
	private static final int TEST_SZ = 4500;
	private static final int MAX_RAND_NUM = 250;


	@BeforeEach
	public void setup(){ testList = new LinkedListD<>(); }
	
	@Test
	public void testEmptyList(){
		assertTrue(testList.isEmpty());
		assertEquals(testList.size(),0);
	}
	
	@Test
	public void testExceptions(){
		assertAll("Testing Exceptions with a empty Linked List",
			() -> assertThrows( RuntimeException.class, ()-> testList.removeFirst()),
			() -> assertThrows( RuntimeException.class, ()-> testList.removeLast()),
			() -> assertThrows( RuntimeException.class, ()-> testList.peekLast()),
			() -> assertThrows( RuntimeException.class, ()-> testList.peekFirst())
		);
	}
	
	@Test 
	public void testAddFirst(){
		testList.addFirst(3);
		assertEquals(testList.size(), 1);
		testList.addFirst(5);
		assertEquals(testList.size(), 2);
		

		assertEquals("[5, 3]", testList.toString());
	}
	
	@Test
	public void testAddAt() throws Exception{
		testList.addAt(0, 1);
		assertEquals(testList.size(), 1);
			
		testList.addAt(1, 2);
		assertEquals(testList.size(), 2);
		
		testList.addAt(1, 3);
		assertEquals(testList.size(), 3);
		
		testList.addAt(2, 4);
		assertEquals(testList.size(), 4);
		
		testList.addAt(1, 8);
		assertEquals(testList.size(), 5);
		
	}
	
	@Test 
	public void testRemoveFirst(){
		testList.addFirst(3);
		
		assertTrue(testList.removeFirst() == 3);
		assertTrue(testList.isEmpty());
		
	}
	
	@Test
	public void testRemoveLast(){
		testList.addLast(4);
		
		assertTrue(testList.removeLast() == 4);
		assertTrue(testList.isEmpty());
	}
	
	@Test
	public void testPeekFirst(){
		testList.addFirst(50);
		assertTrue(testList.peekFirst() == 50);
		assertEquals(testList.size(), 1);
	}
	
	@Test
	public void testPeakLast(){
		testList.addLast(70);
		assertTrue(testList.peekLast() == 70);
		assertEquals(testList.size(), 1);
	}
	
	@Test
	public void testPeeking(){	
		// 8
		testList.addFirst(8);
		assertTrue(testList.peekFirst() == 8);
		assertTrue(testList.peekLast() == 8);
		// 6 8		
		testList.addFirst(6);
		assertTrue(testList.peekFirst() == 6);
		assertTrue(testList.peekLast() == 8);
		// 6 8 80
		testList.addLast(80);
		assertTrue(testList.peekFirst() == 6);
		assertTrue(testList.peekLast() == 80);
		// 6 8  
		testList.removeLast();
		assertTrue(testList.peekFirst() == 6);
		assertTrue(testList.peekLast() == 8);
		
		// 7 6 8		
		testList.addFirst(7);
		assertTrue(testList.peekFirst() == 7);
		assertTrue(testList.peekLast() == 8);
		// 7 6 8 3
		testList.addLast(3);
		assertTrue(testList.peekFirst() == 7);
		assertTrue(testList.peekLast() == 3);
	}
	
	@Test
	public void testRemoving(){
		LinkedListD<String> strs = new LinkedListD<>();
		strs.add("a"); strs.add("b"); strs.add("c"); strs.add("d");
		strs.add("e"); strs.add("f");
		
		strs.remove("b"); strs.remove("a");strs.remove("d");
		strs.remove("e"); strs.remove("c"); strs.remove("f");	
		
		assertEquals(0, strs.size());
	}
	
	@Test
	public void testRemoveAt(){
		testList.add(1); testList.add(2); testList.add(3); testList.add(4);
		testList.removeAt(0); testList.removeAt(2);
		
		assertTrue(testList.peekFirst() == 2);
		
		assertTrue(testList.peekLast() == 3);
		
		testList.removeAt(1); testList.removeAt(0);
		
		assertEquals(testList.size(), 0);
	}
		
	@Test
	public void testClear(){
		
		testList.add(22); testList.add(33); testList.add(44);
		assertTrue(testList.size() == 3);
		
		testList.clear();
		

		assertTrue(testList.isEmpty());
		
		testList.add(-2); testList.add(5); testList.add(6);
		assertTrue(testList.size() == 3);
		
		testList.clear();
		assertTrue(testList.isEmpty());
	}
	
	@Test 
	public void testRandomRemoving(){
		Random r = new Random();
		for(int i = 0; i< LOOPS; i++){
			testList.add( r.nextInt(MAX_RAND_NUM));
		}
		
		assertEquals(testList.size(), LOOPS);
		int finalSize = testList.size() - TEST_SZ;
		
		for(int i = 0; i< TEST_SZ; i++){
			int index = r.nextInt(testList.size());
			testList.removeAt(index);
		}

		assertEquals(testList.size(), finalSize);
	}
	
	@Test
	public void testToString(){
		testList.add(1);
		testList.add(2);
		testList.add(3);
		testList.add(4);
		
		assertEquals("[1, 2, 3, 4]", testList.toString());
		testList.addFirst(50); testList.addLast(20);
		assertEquals("[50, 1, 2, 3, 4, 20]", testList.toString());
		
		testList.clear();
		assertEquals("[]", testList.toString());
	}	
}