/**
	You have an sorted rotated array in an unknown point
	Find an element in the array otherwise return -1.
	
	Example: [1,2,3,4,5] might become [3,4,5,1,2]
	Find the element in the second array assume never you
	will have repeated elements.
	@author Brahian VT
**/
package brahianVT.examples;


public class BinarySearchRotatedArray{
	private int[] array;
	private int element;
	
	public BinarySearchRotatedArray( int[] array, int element){
		this.array = array;
		this.element = element;
	}
	
	public int findElement(){
		if(array.length < 1)return -1;
		
		int startIndex = 0; int endIndex = array.length -1;
		
		while(startIndex <= endIndex){
			int middleIndex = startIndex + (endIndex - startIndex) / 2;
			
			if(array[middleIndex] == element) return middleIndex;
			
			if(array[middleIndex] >= array[startIndex]){
				if(array[middleIndex] < element && array[startIndex] >= element)
					endIndex = middleIndex - 1;
				else
					startIndex = middleIndex + 1;
			} else{
				if( element > array[middleIndex] && array[endIndex] >= element)
					startIndex = middleIndex + 1;
				else
					endIndex = endIndex - 1;
			}
			
		}
		
		return -1;
	}
	
}