
package brahianVT.queue;

/**
	Implement a Queue with a LinkedList
 @author Brahian VT
*/
public class MyQueue <T>  implements Iterable <T> {
	private java.util.LinkedList<T> queue = new java.util.LinkedList<T>();

	public MyQueue(){}

	public MyQueue(T element){ add(element); }
	
	public int size(){  return queue.size(); }
	
	public boolean isEmpty(){ return size() == 0; }
	
	// insert at the begin of the list
	
	public void add(T element){
		queue.addLast(element);
	}
	// peek get the first Element of the list
	public T peek (){
		if(isEmpty()) throw new RuntimeException("Queue Empty");
		
		return queue.peekFirst();
	}
	
	// remove a element of the list()
	public T poll(){
		if(isEmpty()) throw new RuntimeException("Queue Empty");
		return queue.removeFirst();
	}
	
	// return a iterator to traverse the queue the method implementation is mandatory
	
	@Override
	public java.util.Iterator<T> iterator(){
		return queue.iterator();
	}
}