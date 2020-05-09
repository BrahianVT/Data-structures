
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import brahianVT.examples.ReverseLinkedList;
import brahianVT.examples.ListNode;

public class ReverseLinkedListTest{
	
	@Test
	public void testEmptyLinkedList(){	
		ReverseLinkedList test = new ReverseLinkedList();
		
		ListNode<Integer> head = null;
		
		assertNull(test.recursiveReverseList(head));	
	}
	
	@Test
	public void testLinkedListOneLength(){	
		ReverseLinkedList test = new ReverseLinkedList();
		
		ListNode<Integer> head = new ListNode<>(5);
		
		
		assertEquals(test.recursiveReverseList(head).data, head.data);	
	}
	
	@Test
	public void testLinkedListSeveralsNodes(){	
		ReverseLinkedList test = new ReverseLinkedList();
		
		ListNode<Integer> list = new ListNode<>(5);
		list.next = new ListNode<>(85); 
        list.next.next = new ListNode<>(4); 
        list.next.next.next = new ListNode<>(20); 
	
		assertEquals(list.next.next.next.data, test.recursiveReverseList(list).data);	
	}
	
	@Test
	public void testLinkedListAnothers(){	
		ReverseLinkedList test = new ReverseLinkedList();
		
		ListNode<Integer> list = new ListNode<>(-55);
		list.next = new ListNode<>(852); 
        list.next.next = new ListNode<>(14); 
        list.next.next.next = new ListNode<>(2); 
		
		assertEquals(list.next.next.data, test.recursiveReverseList(list).next.data);	
	}
	
		@Test
	public void testLinkedListAnothers2(){	
		ReverseLinkedList test = new ReverseLinkedList();
		
		ListNode<String> list = new ListNode<>("H");
		list.next = new ListNode<>("o"); 
        list.next.next = new ListNode<>("l"); 
        list.next.next.next = new ListNode<>("a"); 
		
		assertEquals(list.next.data, test.recursiveReverseList(list).next.next.data);	
	}
}