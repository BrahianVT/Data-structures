
package brahianVT.sorting;


public class MergeSort{
	
	
	public int[] mergeSort(int [] array){
		
		sort(array, 0, array.length-1);
		
		return array;
	}
	
	private void sort(int[] array, int start, int end){

		if(start < end){
			
			int mid = (start + end) / 2;
			
			sort(array, start, mid);
			sort(array, mid+1, end);
			
			merge(array, start, mid, end);
		}
	}
	
	private void merge(int[] array, int start, int mid, int end){
		
		int leftSize = mid -start +1, rightSize = end- mid;
		System.out.println(" start: " + start + " end: " + end +" mid: " + mid);
		
		int[] left = new int[leftSize]; int[] right = new int[rightSize]; 		
		
		for(int i = 0; i < leftSize; i++){
			left[i] = array[start + i];
		}
		
		for(int j = 0; j < rightSize; j++){
			right[j] = array[mid + j + 1];
		}
		int i = 0, j = 0, k = start;
	
		
		System.out.println("left -" + java.util.Arrays.toString(left));
		System.out.println("right -" +java.util.Arrays.toString(right));
		System.out.println("array -"+java.util.Arrays.toString(array));
		while( i < leftSize && j < rightSize){
			
			if(left[i] <= right[j]){
				array[k] = left[i];
				i++;
			}else{
				array[k] = right[j];
				j++;
			}
			
			k++;
		}
		

		System.out.println(" k: " + k  + "j :" + j + " i: " + i);
		while( i < leftSize){
			array[k] = left[i];
			i++; k++;
		}
		
		while( j < rightSize){
			array[k] = right[j];
			j++; k++;
		}
		
		System.out.println("array: "+ java.util.Arrays.toString(array) );
	}
	
}