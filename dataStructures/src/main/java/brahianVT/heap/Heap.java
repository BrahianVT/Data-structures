
/**
 Implementation of a priority queue, using 
 a binary Heap
 @author Brahian VT 
**/
package brahianVT.heap;
import java.util.*;

public class Heap< T extends Comparable<T>>{
	
	private int size;
	
	private List<T> heap = null;
	private Map<T, TreeSet<Integer>> map = new HashMap();
	
	
	public Heap(){
		this(8);
	}
	
	public Heap(int sz){
		heap = new ArrayList<>(sz);
	}
	
	public Heap(T[] array){
		size = array.length;
		heap = new ArrayList<>(size);
		
		for(int i = 0; i < size; i++){
			mapAdd(array[i], i);
			heap.add(array[i]);
		}
		
		//Heapify O(n)
		
		for(int i = Math.max(0, (size/ 2) -1); i >= 0; i--){
			sink(i);
		}
	}
	
	public boolean isEmpty(){ return size == 0; }
	
	public void clear(){
		heap.clear(); map.clear(); size = 0;
	}
	
	public int size(){ return size; }
	
	public T peek(){
		if(isEmpty()) return null;
		return heap.get(0);
	}
	
	public T poll(){ return removeAt(0); }

	public boolean contains(T data){
		if(isEmpty()) return false;
		return map.containsKey(data);
	} 	
	
	public void add( T ele){
		if(ele == null) throw new IllegalArgumentException("Null value");
		heap.add(ele);
		int indexLastElement = heap.size() -1;
		mapAdd(ele, indexLastElement);
			
		size++;
		swim(indexLastElement);
	}
	
	private boolean less(int i, int j){
		return heap.get(i).compareTo(heap.get(j)) <= 0;
	}
	
	// bottom - up
	private void swim(int k){
		int parent = (k -1)/ 2;
		while( k > 0 && less(k, parent)){
			swap(parent, k);
			
			k = parent;
			parent = ( k -1) /2;
		}	
	}
	
	// top - down
	
	private void sink (int k){
		while(true){
			int leftChild = 2*k + 1;
			int rightChild = 2*k + 2;
			int smallestChild = leftChild;
			
			if(rightChild < size && less(rightChild,leftChild))
				smallestChild = rightChild;
			
			if(leftChild >= size || less(k, smallestChild)) break;
			
			swap(k, smallestChild);
			k = smallestChild;
		}
	}
	
	private void swap(int i ,int j){
		T iElem = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, iElem);
		
		mapSwap(heap.get(j), heap.get(i),i, j);
	}
	
	public boolean remove(T ele){
		if(ele == null) return false;
		Integer index = mapGet(ele);
		if(index != null) removeAt(index);
		return index != null;
	}
	
	private T removeAt(int index){
		if(isEmpty()) return null;
		
		T elemToRemove = heap.get(index);
		
		
		int lastIndex = heap.size() - 1;
		
		swap(lastIndex ,index);
		
		heap.remove(lastIndex); size--;
		
		map.remove(elemToRemove, lastIndex);
		if(index == lastIndex) return elemToRemove;
		
		T elem  = heap.get(index);
		
		sink(index);
		
		
		if(elem.equals(heap.get(index))) swim(index);
		return elemToRemove;
		
	}
	
	private void mapAdd(T value, int index){
		TreeSet<Integer> set = map.get(value);
		
		if(set == null){
			set = new TreeSet<>();
			set.add(index);
			map.put(value, set);
		}else{
			set.add(index);
		}
	}
	
	private void mapRemove(T value, int index){
		TreeSet<Integer> set = map.get(index);

		set.remove(index);
		if(set.size() == 0)map.remove(value);
	}
	
	private Integer mapGet(T value){
		TreeSet<Integer> set = map.get(value);
		if(set != null) return set.last();
		return null;
	}
	
	private void mapSwap(T val1, T val2, int index1, int index2){
		
		Set<Integer> set1 = map.get(val1);
		Set<Integer> set2 = map.get(val2);
		
		set1.remove(index1);
		set2.remove(index2);
		
		set1.add(index2);
		set2.add(index1);
		
	}
	
	
	public String toString(){
		return heap.toString();
	}
}