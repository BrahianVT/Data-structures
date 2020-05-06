
/**
	Find the node where a Cycle begins in a LinkedList
	If there is no cycle return null.
	Examples: [3,2,0,-4], pos = 1 the node 2 will be returned
	[1,2], pos = 0 the node 1 will be returned
	[1], pos = -1 null will be returned.
	
	
	@author Brahian VT
*/

public class LinkedListCycle{
	
	public LinkedListD.Node getInitCycle(LinkedListD head){
		
		LinkedListD.Node aux = head.getHead();
		LinkedListD.Node aux2 = head.getHead();
		
		while(aux2 != null && aux2.next != null){
			
			aux = aux.next; aux2 = aux2.next.next;
			
			if(aux == aux2){
				LinkedListD.Node index = head.getHead();
				while( index != aux2){
					index = index.next;
					aux2 = aux2.next.next;
				}
				return index;
			}	
			
			
		}
	
		return null;
	}
	
}