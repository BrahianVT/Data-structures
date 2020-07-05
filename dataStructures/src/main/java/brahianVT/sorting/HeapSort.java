
package brahianVT.sorting;


/**
	Implementation of mergeSort
	using binary heap
	@author Brahian VT
*/

public class HeapSort{
	int size;

	public int[]  heapSort(int array[]){
		size = array.length;
		
		for(int i = Math.max(0,(size/2)); i >=0; i--){
			heapify(i, array);
		}
		
		for(int j = array.length-1; j>0; j--){
			remove(j, array);
		}
		
		return array;
	}
	
	private void heapify(int parent, int[] array){
		while(true){
			int leftChild = parent *2 + 1;
			int rightChild = parent*2 + 2;
			int greatest = leftChild;
			if(rightChild < size && isGreater(rightChild, leftChild, array))
				greatest = rightChild;

			if(leftChild >= size || isGreater(parent, greatest, array)){ 
			break; 
			}
			
			swap(parent, greatest,array);
			
			parent = greatest;
			
		}
	}
	
	private void remove(int j, int[] array){
		swap(0, j, array);
		size--;
		heapify(0, array);
	}
	
	private void swap(int a, int b, int[] array){
		int aux = array[a];
		array[a] = array[b];
		array[b] = aux;
	}
	
	private boolean isGreater(int a, int b, int[] array){
		return array[a] >= array[b];
	}

}