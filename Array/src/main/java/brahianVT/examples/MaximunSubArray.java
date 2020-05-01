/**
	Find out the maximum sub-array of non negative numbers from an array.
	Example:
	A : [1, 2, 5, -7, 2, 3]
	The two sub-arrays are [1, 2, 5] [2, 3].
	The answer is [1, 2, 5] as its sum is larger than [2, 3]

    NOTE 1: If there is a tie, then compare with segment's length and return segment which has maximum length 
    NOTE 2: If there is still a tie, then return the segment with minimum starting index
    @author Brahian
*/
package brahianVT.examples; 

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Comparator;

public class MaximunSubArray{
	int[] array;
	SortedSet<String> sortedSubArray = new TreeSet<>( new Comparator<String> (){
		@Override 
		public int compare(String s1, String s2){
			String[] array1 = s1.split("-");
			String[] array2 = s2.split("-");
			
			int cmp1 = Integer.parseInt(array1[0]) - Integer.parseInt(array2[0]);
			if(cmp1 != 0) return cmp1;
			int cmp2 = Integer.parseInt(array1[1]) - Integer.parseInt(array2[1]);
			if(cmp2 != 0) return cmp2;
			int cmp3 = Integer.parseInt(array2[2]) - Integer.parseInt(array1[2]);
			return cmp3;
		}
	});
	
	public MaximunSubArray(int[] array){
		this.array = array;
		this.sortedSubArray.clear();
	}
	
	
	// time complexity: O(nlog(n)) space complexity O(nlog(n))
	public void printMaximumSubArray(){
		
		if(array.length < 0) return;
		
		int startIndex = -1; int sum = 0; int length = 0;
		
		for(int i = 0; i < array.length; i++){
			if(array[i]  < 0){
				if(length > 0){
					sortedSubArray.add(""+sum+"-"+length+"-"+startIndex);
					startIndex = -1; sum = 0; length = 0;
				}
				continue;
			}
			
			sum+=array[i]; length++;
			if(startIndex == -1) startIndex = i;
		}
		
		if(startIndex != -1)sortedSubArray.add(""+sum+"-"+length+"-"+startIndex);
		
		if(!sortedSubArray.isEmpty()){
			
			String maximumElement = sortedSubArray.last();
			String elements[] = maximumElement.split("-");
			
			int startIndexMax = Integer.parseInt(elements[2]);
			int lengthMax = Integer.parseInt(elements[1]);
			
			for(int i = startIndexMax; i < startIndexMax + lengthMax; i++)
				System.out.print(array[i] + " ");
		}
	}
	
	public static void main(String[] args){
		int[] ver = {-3,4,-10,-1,-6,8,8,-8,-6,-5,-5,-9};
		MaximunSubArray a = new MaximunSubArray(ver);
		a.printMaximumSubArray();
	}
}