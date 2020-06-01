package brahianVT.examples;

/**
 Implements binary search in a array of Integers
 usings loops and recursion
*/

public class BinarySearch{
	
	
	public int binarySearch(int[] array, int k){
		if(array.length == 0) return -1;
			
		int start = 0, end = array.length -1;
		while(start <= end ){
			int middle = start + (end - start) / 2;
			
			System.out.println("m: " + middle);
			if(array[middle] < k) start = middle + 1;
			else if (array[middle] > k) end = middle - 1;
			else return middle;
		}
		
		return  -1;
	}
	
	public int binarySearchR(int[] array, int k , int start, int end ){
		if(array.length == 0 ||  end < start) return -1;
		
		int middle =  start + (end - start) / 2;
		int res = middle;
		System.out.println("mr: " + middle);
		if(array[middle] < k) res = binarySearchR(array, k, middle+1, end);
		else if(array[middle] > k) res = binarySearchR(array, k, start, middle-1);
		return res;
	}
}