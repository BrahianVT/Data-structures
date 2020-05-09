/**
	Reverse a Linked List iteratevely 
	and with recursion
	@author Brahian VT
*/
package brahianVT.examples;

public class ReverseLinkedList{
	
	// Reverse the list iterating over the list
	public ListNode reverseList(ListNode head){
		ListNode current = head;
		ListNode previous = null, next = null;
		
		while( current != null){
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		return previous;
	}
	
	// Using recursion
	public ListNode recursiveReverseList(ListNode head){
		
		if(head == null) return null;
		if(head.next == null) return head;
		
		ListNode next = head.next;
		
		head.next = null;

		ListNode secondElement = recursiveReverseList(next); 
		
		next.next = head;
		
		return secondElement;
	}
}




