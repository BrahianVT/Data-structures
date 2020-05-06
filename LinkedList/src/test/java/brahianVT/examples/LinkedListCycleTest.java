
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


public class LinkedListCycleTest{
	
	LinkedListD<Integer> linked = null;
	LinkedListCycle test = null;
	
	@BeforeEach
	public void setup(){
		linked = new LinkedListD<>();
		test = new LinkedListCycle();
	}
	
	@Test
	public void testEmptyLinkedList(){
		
		assertNull(test.getInitCycle(linked));
	}
	
	@Test
	public void test2(){
		
		linked.add(10);
		linked.add(11);
		
		LinkedListD.Node root = linked.getHead();
		linked.tail.next = root;
		assertEquals(root, test.getInitCycle(linked));
	}
	
	@Test
	public void test3(){
		
		linked.add(10);
		linked.add(11);
		linked.add(56);
		linked.add(50);
		linked.add(3);
		linked.add(34);
		
		LinkedListD.Node root = linked.getHead();
		linked.tail.next = root;
		
		LinkedListD.Node result = test.getInitCycle(linked); 
		
		assertEquals(root, result);
	}
}