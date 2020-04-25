

/**
	Dinamic Array Implementation
	@author Brahian VT
*/

public class DynamicArray<T> implements Iterable<T>{
	private int len =0; private int capacity = 0;
	private T[] array;
	
	// By default assign capacity of 16
	public DynamicArray(){ this(16);}
	
	public DynamicArray(int sz){
		if( sz < 0) throw new IllegalArgumentException("Illegal Capacity " + sz);
		capacity = sz;
		array = (T[]) new Object[sz];
	}
	
	public int size(){ return len; }
	public boolean isEmpty(){ return len == 0; }
	
	public T get(int index){
		if(index < 0 || index > len -1) throw new IndexOutOfBoundsException();
		
		return array[index];
	}
	
	public void set(int index, T data){
		if(index < 0 || index > len -1) throw new IndexOutOfBoundsException();
		array[index] = data;
	}
	
	// Insert a element in the array, first validating the capacity  
	public void add(T data){
	
		if(len + 1 > capacity){ 
			if( capacity == 0) capacity = 1;
			else capacity*= 2;
			
			T[] newArray = (T[]) new Object[capacity];
			for(int i = 0;  i< len; i++)
				newArray[i] = array[i];
			
			array = newArray;
			
		}
		
		array[len++] = data;
		
	}
	
	// Remove a element
	public T removeAt(int index){
		if(index < 0 || index >= len) throw new IndexOutOfBoundsException();
		
		T removeElement = array[index];
		
		T[] newArray = (T[]) new Object[len-1];
		
		for(int i = 0, j = 0; i < len; i++,j++)
			if(i == index) j--;
			else
				newArray[j] = array[i];

		array = newArray;
		capacity = --len;
		
		return removeElement;
	}
	
	public int indexOf(Object data){
		for(int i = 0; i < len; i++){
			if(data == null){
				if(array[i] == null) return i;
			} else {			
			if(data.equals(array[i])) return i;
			}
		}
		return -1;
	}
	
	public boolean remove(Object data){
		int index = indexOf(data);
		if(index != -1){
			removeAt(index);
			return true;
		} else return false;
	}
	
	public boolean constains(Object data){
		int index = indexOf(data);
		return index != -1;
	}
	
	@Override public String toString(){
		if(len == 0) return "[]";
		
		StringBuilder st = new StringBuilder("[");
		for(int i = 0; i< len-1; i++)
			st.append(array[i] + ",");
		
		return st.append(array[len-1] + "]").toString();
	}
	
	// Implement the Iterator method (mandatory) 
	@Override public java.util.Iterator<T> iterator(){
		return new java.util.Iterator<T>(){
			int index = 0;
			@Override public boolean hasNext(){ return index < len; }
			@Override public T next(){ return array[index++]; }
			@Override public void remove (){ throw new UnsupportedOperationException(); }
		};
	}
	
}