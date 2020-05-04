package brahianVT.examples;
/**
	given a array with non-negative integers
	find the maximum area between all the elements
	Area of two elements: find the smallest value of both and multiply it with the distance between each other.
	
	Example Input: [1,8,6,2,5,4,8,3,7]
	
	Maxinum Area : 49 , the elements are first 8 and 7. The smallest is 7 
	and the distance between each other is 7. Area = 7 * 7 = 49.  
	@author Brahian VT
*/
public class MaximumArea{
	public MaximumArea(){};
	
	public int findMaximumArea(int [] array){
		if(array.length < 1) return 0;
		
		int maxArea = 0;
		
		int sIndex = 0 , eIndex = array.length - 1 ;  
	while(sIndex < eIndex){
			
			if(array[sIndex] <= array[eIndex]){
				maxArea = Math.max(maxArea, array[sIndex]* (eIndex - sIndex));
				sIndex++;
			} else{
				maxArea = Math.max(maxArea, array[eIndex]* (eIndex - sIndex));
				eIndex--;
			}
		}
	return maxArea;
	}
}