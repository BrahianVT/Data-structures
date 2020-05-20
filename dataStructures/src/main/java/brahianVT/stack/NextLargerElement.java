package brahianVT.stack;
/**
	Given an array A of size N having distincts elements
	The task is to find the next greater element for each element
	of the array in order of their appearance in the array. if no such
	element exists , print out a -1.
	
	[1 3 2 4] -> [3 4 4 -1]
	[4 3 2 1] -> [-1 -1 -1 -1]
	@author Brahian VT
**/
import java.util.Stack;
import java.util.Arrays;
class NextLargerElement{
	
	public int[] findNextLargerElement(int[] array){
		if(array.length < 1) return array;
		
		// Iterate the array from last to first
		
		// create a stack to store the elements and compare between the ones
		Stack<Integer> stack = new Stack<Integer>();
		int[] res = new int[array.length];
		
		for(int i = array.length - 1; i >= 0; i--){
			
			/* Check if the stack is empty and if it isn't, check is the element at top 
			is greater than the element at the array if it isn't remove the elements from 
			the stacks until you match the condition 
			 */
		
			 while(!stack.isEmpty() && array[i] >= stack.peek()){
				 stack.pop();
			 }
			 
			res[i] = stack.isEmpty()?-1:stack.peek();
		stack.push(array[i]);
		}
		System.out.println(Arrays.toString(res));
		return res;
	}
	
}