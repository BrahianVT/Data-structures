
package brahianVT.stack;
/**
 
 Design a stack which supports the following operations.
Implement the CustomStack class:
CustomStack(int maxSize) Initializes the object with maxSize which is the maximum number of 
elements in the stack or do nothing if the stack reached the maxSize.
void push(int x) Adds x to the top of the stack if the stack hasn't reached the maxSize.
int pop() Pops and returns the top of stack or -1 if the stack is empty.
void inc(int k, int val) Increments the bottom k elements of the stack by val.
 If there are less than k elements in the stack, just increment all the elements in the stack.

 @author BrahianVT
*/
public class StackIncrement{
	
	int[] myStack;
	int size ,  maxSize;
	
	public StackIncrement(int maxSize){
		myStack = new int[maxSize];
		this.maxSize = maxSize;
	}
	
	
	public void push(int x){
		if(size < maxSize){
			myStack[size] = x;
			size++;
		}
	}
	
	public int pop(){
		if(size - 1 >= 0){
			return myStack[--size];
		}
		
		return -1;
	}
	
	public void increment(int k, int val){
		
		for(int i = 0; i< maxSize; i++){
			myStack[i] = myStack[i] + val;
			if(i + 1 == k) break;
		}
			
	}
	
}