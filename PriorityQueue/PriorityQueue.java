import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
	This class implements a priority queue using a binaryHeap
	In this case a min binaryHeap is created.
	
	@author :BrahianVT
*/
public class PriorityQueue <T extends Comparable<T>> {
	
	private int heapSize = 0;
	private int heapCapacity = 0;

	List<T> heap = null;
	Map<T,TreeSet<Integer>> trackMov = new HashMap<>();
	
	public PriorityQueue(){ this(1); }
	public PriorityQueue(int size){  
		heapSize = heapCapacity = size;
		this.heap = new ArrayList<>(size); 
	}
	public PriorityQueue(T[] input){
		heapSize = heapCapacity = input.length;
		heap = new ArrayList<>(heapSize);
		for(int i = 0; i < heapSize; i++){
			heap.add(input[i]);
			mapAdd(i, input[i]);
		}
		
		for(int j = Math.max(0, (heapSize/2) -1); j >=0;  j--)
			sink(j);
	}
	
	private void sink( int parent){
		while(true){
			int leftChild = 2 * parent + 1;
			int rightChild = 2 * parent + 2;
			int smallest = leftChild;
			if(rightChild < heapSize && isLess(rightChild, leftChild))
				smallest = rightChild;
			
			if(leftChild >= heapSize || isLess(parent, leftChild))
				break;
			
			swap(parent, smallest);
			
			parent = smallest;
		}
	}
	
	public void add( T data){
		if(data == null) throw new IllegalArgumentException();
		
		if(heapSize < heapCapacity)
			heap.set(heapSize, data);
		else{
			heap.add(data);
			heapCapacity++;
		}
		
		mapAdd(heapSize, data);
		swim(heapSize);
		heapSize++;
		
	}
	
	public boolean remove(T data){
		if(data == null) return false;
		else{
			Integer index = mapGet(data);
			if(index != null) removeAt(index);
			
			return index != null;
		}
		
	}
	private T removeAt(Integer index){
		if(isEmpty())return null;
		T removeData = heap.get(index);
		
		heapSize--;	
		swap(index, heapSize);
		
		heap.set(heapSize, null);
		mapRemove(removeData, heapSize);
		
		if(index == heapSize) return removeData;
		
		T swappedElemet = heap.get(index);
		
		sink(index);
		
		if(swappedElemet.equals(heap.get(index)))swim(index);
		
		return removeData;
	}
	
	public T peak(){
		return heap.get(0);
	}
	public T poll(){
		return removeAt(0);
	}
	public boolean isMinHeap(int k){
		
		if(k >= heapSize) return true;
		int left = k * 2 + 1; int right = k * 2 + 2;
			
		if(left < heapSize && isLess(left, k)) return false;
		
		if(right < heapSize && isLess(right, k)) return false;
		

		return isMinHeap(left) && isMinHeap(right);
	}
	
	private void swim(int child){
		int parent = (child - 1)/ 2;
		while(child > 0 && isLess(child,parent)){	
			swap(parent, child);
			child = parent;
			parent = (child - 1)/ 2;
		}
	}
	
	private void mapAdd(Integer i, T key ){
		TreeSet<Integer> aux = trackMov.get(key);
		if (aux == null){
			TreeSet<Integer> newTreeSet = new TreeSet<>();
			newTreeSet.add(i);
			trackMov.put(key, newTreeSet);
		} else aux.add(i);
		
	}
	
	private boolean isLess(int indexA , int indexB){
		return heap.get(indexA).compareTo(heap.get(indexB)) <= 0;
	}
	
	private void swap(int indexA, int indexB){
		T dataA = heap.get(indexA);
		T dataB = heap.get(indexB);
		heap.set(indexA, dataB);
		heap.set(indexB, dataA);
		mapSwap(dataA, indexA, dataB, indexB);
	}
  
	private void mapSwap( T dataA, int indexA, T dataB, int indexB){
		Set<Integer> setA = trackMov.get(dataA);
		Set<Integer> setB = trackMov.get(dataB);
		
		setA.remove(indexA);  setB.remove(indexB);
		setA.add(indexB); setB.add(indexA);
	}
	
	private Integer mapGet(T key){
		TreeSet<Integer> auxSet = trackMov.get(key);
		if(auxSet == null)return null;
		return auxSet.last();
	}
	
	private void mapRemove(T key , Integer index){
		TreeSet<Integer> auxSet = trackMov.get(key);	
		auxSet.remove(index);
		if(auxSet.size() == 0) trackMov.remove(key);
	}
	
	public int size(){ return heapSize; }
	public boolean isEmpty(){ return heapSize == 0; }
	

  @Override
  public String toString() {
    return heap.toString();
  }
  public static void main(String args[]){
	  	Integer[] array = {10,3,5,1,5,7,8,4,3,5};
		System.out.println(array);
	    PriorityQueue exa = new PriorityQueue(array);
		System.out.println("Ordered using heapyfy process");
		System.out.println(exa);
		System.out.println("eliminated: " + exa.poll());
		System.out.println(exa);
		System.out.println("eliminated: " + exa.poll());
		System.out.println(exa);
		System.out.println("eliminated: " + exa.poll());
		System.out.println(exa);
		System.out.println("eliminated: " + exa.poll());
		System.out.println(exa);
		System.out.println("eliminated: " + exa.poll());
		
		System.out.println(exa);
		System.out.println("adding:  3");
		exa.add(3);
		
		System.out.println(exa);
		
		System.out.println("eliminated: " + exa.poll());
		System.out.println(exa);
  }
}