/**
	Implementations of a doubly Linked List
	@author Brahian VT
*/

public class LinkedListD <T> implements Iterable<T>{
	private int size;
	public Node<T> head = null, tail = null;
	
	// Clear the linked list O(n)
	public void clear(){
		Node<T> aux = head;
		
		while( aux != null){
			Node<T> next = aux.next;
			aux.previous = aux.next = null;
			aux.data = null;
			aux = next;
		}
		head = tail = aux = null;
		size = 0;
	}
	
	public Node<T> getHead(){ return head; }
	
	//Return the size
	public int size(){ return size; }
	
	public boolean isEmpty(){return size == 0; }
	
	// Add an element to the tail O(1)
	public void add(T elem){
		addLast(elem);
	}
	
	public void addLast(T elem){
		if(elem == null)return;
		
		if(isEmpty()){
			head = tail = new Node<T>(elem);
		} else{
			
			Node<T> newTail = new Node<T>(elem);
			newTail.previous = tail;
			tail.next = newTail;
			tail = tail.next;
		}
		size++;
	}
	
	public void addFirst(T elem){
		
		if(elem == null) return;
		
		if(isEmpty()){
			head = tail = new Node(elem);
		} else{
			Node<T> newHead = new Node<T>(elem);
			newHead.next = head;
			head.previous = newHead;
			head = newHead;
		}
		size++;
	}
	
	//Add at index O(n)
	public void addAt(int index, T elem) throws Exception{
		if(elem == null || index < 0) throw new Exception("Illegal Index or null elem");
		
		if(index == 0){ addFirst(elem); return; }
		if(index == size){ addLast(elem); return; }
		
		Node<T> aux = head;
		
		for(int i = 0; i< index -1; i++)
			aux = aux.next;
			
		Node<T> nodeAtIndex = new Node(elem);
		
		aux.next = nodeAtIndex;
		nodeAtIndex.next = aux;
		nodeAtIndex.previous = aux;
		
		size++;
	}
	
	// Get First Value O(1)
	public T peekFirst(){
		if(isEmpty()) throw new RuntimeException("Empty List");
		
		return head.data;
	}
	
	// Last value O(1)	
	public T peekLast(){
		if(isEmpty()) throw new RuntimeException("Empty List");
		return tail.data;
	}
	
	// remove First O(1)
	
	public T removeFirst(){
		if(isEmpty()) throw new RuntimeException("Empty List");
		
		//Extract the data at the first
		
		T data = head.data;
		head = head.next;
		--size;
		if(size == 0) tail = null;
		else head.previous = null;
		
		return data;
	}
	
	public T removeLast(){
		if(isEmpty()) throw new RuntimeException("Empty List");
		
		T data = tail.data;
		tail = tail.previous;
		--size;
		
		if(isEmpty())head = null;
		else
			tail.next = null;
		
		return data;
	}
	
	// Remove node from the list O(1)
	private T remove(Node<T> node){
		
		// if the elemment is either the first or last
		if(node.next == null) return removeLast();
		if(node.previous == null) return removeFirst();
		
		node.next.previous = node.previous;
		node.previous.next = node.next;
		
		T data = node.data;
		node.data = null;
		node = node.previous = node.next = null;
		--size;
		return data;
	}
	
	public T removeAt(int index){
		if(index < 0 || index >= size) throw new IllegalArgumentException();
		
		int i;
		Node<T> aux;
		
		if(index < size/2){
			for(i = 0 , aux = head; i != index; i++)
				aux = aux.next;
			
		}else {
			for(i= size -1, aux = tail; i != index; i--)
				aux = aux.previous;
			
		}
		
		return remove(aux);
	}
	
	// Remove on based in the value O(n)
	public boolean remove(Object obj){
		Node<T> aux = head;
		if(obj == null){
			for(aux = head; aux != null; aux = aux.next){
				if(aux.data == null){
					remove(aux); return true;
				}
			}
		} else{
			for(aux = head; aux != null; aux = aux.next){
				if(obj.equals(aux.data)){
					remove(aux); return true;
				}
			}
		}
		
		return false;
	}
	
	public int indexOf(Object obj){
		int index = 0;
		Node<T> aux = null;
		
		if(obj == null){
			for(aux = head; aux != null; aux = aux.next, index++){
				if(aux.data == null) return index;
			}
		}else
			for(aux = head; aux != null; aux = aux.next, index++){
				if(obj.equals(aux.data)) return index;
			}
			
		return -1;
	}
	
	public boolean constains(Object obj){
		int index = indexOf(obj);
		
		return (index != -1)?true:false;
	}
	
	 @Override
	public java.util.Iterator<T> iterator(){
		return new java.util.Iterator<T>(){
			Node<T> aux = head;
			@Override
			public boolean hasNext(){return aux != null;}
			
			@Override
			public T next(){
				T data = aux.data;
				aux = aux.next;
				return data;
			}
			
			@Override
			public void remove(){throw new UnsupportedOperationException();}
		};
	}
	
	
	@Override
	public String toString(){
		if(size == 0) return "[]";
		StringBuilder st = new StringBuilder("[");
		Node<T> aux = head;
		while(aux != null){
			st.append(aux.data);
			
			if(aux.next != null)
				st.append(", ");
			
			aux = aux.next;
		}
		
		st.append("]");
		return st.toString();
	}
	
	// Internal node class
	public class Node<T> {
		T data;
		public Node<T> previous = null, next = null;
	
		public Node(T data){
			this.data = data;
		}
	}	
}

 