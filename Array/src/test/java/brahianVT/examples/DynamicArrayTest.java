//
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class DynamicArrayTest{
	DynamicArray<Integer> list = null;
	
	@BeforeEach
	public void reset(){
		list = new DynamicArray<>();
	}
	@Test
	public void testEmptyList(){
		
		assertTrue(list.isEmpty());
	}
	
	@Test 
	public void testRemovingEmpty(){

		assertThrows(Exception.class, () -> {list.removeAt(0);});
		
	}
	
	@Test 
	public void testIndexOutOfBounds(){
		list.add(-56);
		list.add(-53);
		list.add(-532);
		assertThrows(IndexOutOfBoundsException.class,() -> list.removeAt(3));
	}
	
	@Test 
	public void testIndexOutOfBoundsOthers(){
		for(int i = 0; i < 100; i++) list.add(i);
		
		assertAll( "Testing IndexOutOfBoundsException",
		    () -> assertThrows(IndexOutOfBoundsException.class, () -> list.removeAt(100)),
		    () -> assertThrows(IndexOutOfBoundsException.class, () -> list.removeAt(-1)),
			() -> assertThrows(IndexOutOfBoundsException.class, () -> list.set(-1,1)),		
			() -> assertThrows(IndexOutOfBoundsException.class, () -> list.set(101,3)),
			() -> assertThrows(IndexOutOfBoundsException.class, () -> list.get(456))
		);	
	}
	
	@Test 
	public void testRemoving(){
		DynamicArray<String> list2 = new DynamicArray<>();
		String[] strs = {"a","b","c","d","e",null,"g","h"};
		for(String index: strs) list2.add(index);
		boolean ret = list2.remove("c");
		
		assertTrue(ret);
		
		ret = list2.remove("c");
		assertFalse(ret);
		
		ret = list2.remove("h");
		assertTrue(ret);
		
		ret = list2.remove(null);
		assertTrue(ret);
		
		ret = list2.remove("a");
		assertTrue(ret);
		
		ret = list2.remove("a");
		assertFalse(ret);
		
		ret = list2.remove("h");
		assertFalse(ret);
		
		ret = list2.remove(null);
		assertFalse(ret);
	}
	
	@Test 
	public void testIndexOfNullElement(){
		DynamicArray<String> list2 = new DynamicArray<>();
		String[] strs = {"a","b",null,"d"};
		for(String s: strs) list2.add(s);
		
		assertTrue(list2.indexOf(null) == 2);
	}
	
	@Test 
	public void testAddingElements(){
		int[] elems = {1,2,3,4,5,6,7};
		for(int i = 0; i <  elems.length; i++) list.add(elems[i]);
		
		for(int i = 0; i <  elems.length; i++)
			assertEquals(list.get(i).intValue(), elems[i]);
	}
	
	@Test
	public void testAndRemove(){
		for (int i = 0; i < 55; i++) list.add(44);
		for (int i = 0; i < 55; i++) list.remove(44);
		assertTrue(list.isEmpty());
		
		for (int i = 0; i < 155; i++) list.add(44);
		for (int i = 0; i < 155; i++) list.removeAt(0);
		assertTrue(list.isEmpty());
	}
	
	@Test
	public void testAndRemove2(){
		for (int i = 0; i < 55; i++) list.add(120);
		for (int i = 0; i < 55; i++) list.set(i,100);
		for (int i = 0; i < 55; i++) list.remove(100);
		
		assertTrue(list.isEmpty());
		
		for (int i = 0; i < 55; i++) list.add(120);
		for (int i = 0; i < 55; i++) list.set(i,100);
		for (int i = 0; i < 55; i++) list.removeAt(0);
		
		assertTrue(list.isEmpty());
	}
	
	@Test
	public void testSize(){
		Integer[] elems = {-76, 45, 66, 3, null, 54, 33};
		for(int i = 0, sz = 1; i < elems.length; i++, sz++){
			list.add(elems[i]);
			assertEquals(list.size(), sz);
		}
	}
}