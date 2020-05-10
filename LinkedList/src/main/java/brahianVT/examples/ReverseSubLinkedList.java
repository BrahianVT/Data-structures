/**
	Reverse a Sub-Linked List in a LinkedList
	You have a value "m" the first element to reverse
	and a value "n" the last element to reverse.
	
	Constraints: 1<= m <= n <= list size. 
	Examples:
	Input: 1->2->3->4->5->NULL, m = 2, n = 4
	Output: 1->4->3->2->5->NULL
	Input: 1->2->3->4->5->NULL, m = 1, n = 4
	Output: 5->4->3->2->1->NULL
	
	Input: 1->2->3->4->5->NULL, m = 3, n = 4
	Output: 1->2->4->3->5->NULL

	Input: 1->2->3->4->5->NULL, m = 1, n = 2
	Output: 2->1->3->4->5->NULL
	
	@author Brahian VT
	
	
*/
package brahianVT.examples;

public class ReverseSubLinkedList {

	public ListNode reverSubLinkedList(ListNode head, int m, int n){
		// basic validation if is null or m is greater return head;
		if(head == null || m >= n) return head;
		// Declare some pointers
		ListNode preNode = null, postNode = null, nodeAtM = null, nodeAtN = null;
		ListNode iterate = head;
		
		// Iterate until n is quals to N
		while(n != 1){
			if(m == 2) preNode = iterate;
			iterate = iterate.next; m--; n--;
			
		}
		// On based of iterate variable(nodeAtN) and preNode find the postNode and nodeAtM elements 
		if(preNode != null) nodeAtM = nodeAtM = preNode.next;
		else nodeAtM = head;
		
		nodeAtN = iterate;  postNode = iterate.next;

		// Now just reverse the elements between nodeAtN and nodeAtM
		
		ListNode aux = nodeAtM , next = null, prev = null;
		
		/* if there is a postNode value assign to prev cause this will be the
		   element next to preNode
		*/
		
		if(postNode != null) prev = postNode;
		
		while( aux != nodeAtN){
			next = aux.next;
			aux = prev;
			prev = aux;
			aux = next;
		}
		aux.next = prev;
		
		if(preNode != null){
			preNode.next = nodeAtN;
			return head;
		} else
			return nodeAtN;
		
	}
	
	// Using recursion
	public ListNode reverSubLinkedListRecursion(ListNode head, int m, int n){
		// basic validation if is null or m is greater return head;
		if(head == null && m >= n) return head;
		// Declare some pointers
		ListNode preNode = null, postNode = null, nodeAtM = null, nodeAtN = null;
		ListNode iterate = head;
		 while( n != 1){
			 if(m == 2) preNode = iterate;
			 iterate = iterate.next;
			 n--; m--;
		}
		// On based of iterate variable(nodeAtN) and preNode find the postNode and nodeAtM elements 
		if(preNode != null) nodeAtM = preNode.next;
		else nodeAtM = head;
		
		nodeAtN = iterate; postNode = iterate.next;
		
		reverseBetweenMandN(nodeAtM, n-m);
				
		if(postNode != null)
			nodeAtM.next = postNode;
		
		if(preNode != null){
			preNode.next = nodeAtN;
			return head;
		} else return nodeAtN;
		
	}
	
	public ListNode reverseBetweenMandN(ListNode head, int cont){
		if(head == null || cont == 0) return head;
		
		ListNode next = reverseBetweenMandN(head.next, cont-1);
		next.next = head;
		head.next = null;
		return head;
	}
}



