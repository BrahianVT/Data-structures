
package brahianVT.sorting;

public class QuickSort{

		public int[] quickSort(int[] array){
			
			sort(array, 0, array.length -1);
		return array;
			
		}
		
		private void sort(int[] array , int start, int end){
			if(start < end){
				
				int index = partition(array, start, end);
				
				sort(array, start, index-1);
				sort(array, index+1, end);
			}
	
		}
		
		private int partition(int[] array, int start, int end){
			int pivot = array[end];
			
			int i = start -1;

			for(int j = start; j < end; j++){
			
				if(array[j] < pivot){
					i++;
					System.out.println(array[i]  + " -  " + array[j] );
					swap(array, i, j);
				}
			}
			
			swap(array, i + 1, end);
			return i + 1;
		}
		
		
		private void swap(int[] array, int a, int b){
			
			int aux = array[a];
			array[a] = array[b];
			array[b] = aux;
		}
		
	
}