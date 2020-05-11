
package brahianVT.queue;

/**
	Implement a Queue with a Fixed Vector
 @author Brahian VT
*/
public class QueueV <T>  implements Iterable <T> {
	int len = 0,capacity = 0;

	T[] data = null;	

	public QueueV(){ this(8); }

	public QueueV(int sz){
		if(sz < 0 ) throw new IllegalArgumentException("the size must be positive");
		this.data = (T[]) new Object[sz];
		capacity = sz;
	}
	
	public QueueV(T data){
		this.data = (T[]) new Object[8];
		this.data[0] = data;
		++len;
	}
	
	public int size(){  return len; }
	
	public boolean isEmpty(){ return len == 0; }
	
	// insert at the begin of the list
	
	public void add(T element){
		
		if(len + 1 > capacity){
			if(capacity == 0) capacity = 1;
			else 
				capacity *= 2;
			
			T[] auxArray = (T[]) new Object[capacity];
			
			for(int i = 0; i< data.length; i++)
				auxArray[i] = data[i];
			
			data = auxArray;
		}
		data[++ len] = element;
		
	}
	// peek get the first Element of the list
	public T peek (){
		if(isEmpty()) throw new RuntimeException("Empty queue");
		
		return data[0];
	}
	
	
	// remove a element of the list()
	public T poll(){
		if(isEmpty()) throw new RuntimeException("Empty queue"); 
		
		T dataAtFirst = data[0];
		for(int i = 1; i < len; i++){
			data[i-1] = data[i];
			
		}
		
		--len;
		return dataAtFirst;
	}
	
	
	// find a element in the queue
	public boolean find(T element){
		for(int i = 0; i < len; i++){
			if(element == null)
				if(data[i] == null) return true;
			else
				if(element.equals(data[i])) return true;
	
		}
			
		return false;
	}
	
	
	// return a iterator to traverse the queue the method implementation is mandatory
	
	@Override
	public java.util.Iterator<T> iterator(){
		return new java.util.Iterator<T>(){
			int cont = 0;
			@Override
			public boolean hasNext(){ return cont < len; }
			
			@Override
			public T next(){ return data[cont++];}
			
			@Override
			public void remove(){ throw new UnsupportedOperationException(); }
		};
	}
	
}