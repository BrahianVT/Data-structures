
package brahianVT.stack;
/**
	Having a  Stack of Numbers :
	between 1 <= n <= 100 
	print the smallest element in the stack
	if the stack is empty print -1
	
	The best solution should has a O(1) complexity
	
	Examples: 
	[ 4, 5, 4, 5, 6 ,2] min  = 2
	
	If you delete the top
	[ 4, 5, 4, 5, 6] min  = 4
	
	If add an element
	[ 4, 5, 4, 5, 6, 1] min  = 1
 	
	With Empty Stack
	[] min = -1
	
	Create a function that return the min value in the stack
	@author Brahian VT
**/
import java.util.Stack;

public class FindMinElement{
	public Stack<Integer> s = new Stack<>();
	int minVal;
	// first we need to make some stuff when insert and delete in the stack
	// so I will create 3 methods for add,pop and find min value
	
	public void push(int element){
		
		if(!s.isEmpty()){
			if( element < minVal){
				int previousMin = minVal;
				minVal = element;
				element = (2 * element) - previousMin;
			}
		}else minVal = element;
		
		s.push(element);
	}
	
	public int pop(){ 
			if(!s.isEmpty()){
				int topElemet = s.pop();
				if(topElemet < minVal){
					int auxMin = minVal;
					
					minVal = 2 * minVal - topElemet;
					topElemet = auxMin;
				}
				
				return topElemet;
			}
		return -1;
		
		}
	
	public int findMin(){ return s.isEmpty()?-1:minVal; }
}