

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import brahianVT.examples.ReverseSubLinkedList;
import brahianVT.examples.ListNode;




public class ReverseSubLinkedListTest{
	
	@Test
	public void testEmptyLinkedList(){	
		ReverseSubLinkedList test = new ReverseSubLinkedList();
		
		ListNode<Integer> head = null;
		
		assertNull(test.reverSubLinkedList(head, 3 , 2));	
	}
	
	@Test
	public void testLinkedListOneLength(){	
		ReverseSubLinkedList test = new ReverseSubLinkedList();
		
		ListNode<Integer> head = new ListNode<>(5);
		
		assertEquals(head, test.reverSubLinkedList(head, 1 , 1));	
	}

	@Test
	public void testLinkedListSeveralsNodes(){	
		ReverseSubLinkedList test = new ReverseSubLinkedList();
		
		ListNode<Integer> list = new ListNode<>(5);
		list.next = new ListNode<>(85); 
        list.next.next = new ListNode<>(4); 
        list.next.next.next = new ListNode<>(20); 
		
		ListNode newHead = list;
		assertEquals(newHead.next.data, test.reverSubLinkedList(list, 1 , 2).data);	
	}

	@Test
	public void testEmptyLinkedListR(){	
		ReverseSubLinkedList test = new ReverseSubLinkedList();
		
		ListNode<Integer> head = null;
		
		assertNull(test.reverSubLinkedListRecursion(head, 3 , 2));	
	}
	
	@Test
	public void testLinkedListOneLengthR(){	
		ReverseSubLinkedList test = new ReverseSubLinkedList();
		
		ListNode<Integer> head = new ListNode<>(5);
		
		assertEquals(head, test.reverSubLinkedListRecursion(head, 1 , 1));	
	}

	@Test
	public void testLinkedListSeveralsNodesR(){	
		ReverseSubLinkedList test = new ReverseSubLinkedList();
		
		ListNode<Integer> list = new ListNode<>(5);
		list.next = new ListNode<>(85); 
        list.next.next = new ListNode<>(4); 
        list.next.next.next = new ListNode<>(20); 
		
		ListNode newHead = list;
		assertEquals(newHead.next.data, test.reverSubLinkedListRecursion(list, 1 , 2).data);	
	}	
}