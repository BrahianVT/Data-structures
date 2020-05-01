package brahianVT.examples;

/**
	Majority Element Given an array A of N elements. 
	Find the majority element in the array. 
	A majority element in an array A of size N is an element 
	that appears more than N/2 times in the array.
	return the majority element, otherwise return -1
	@author Brahian VT
**/

public class MajorityElement{
	int[] array;
	public MajorityElement(int[] array){
		this.array = array;
	}
	
	public int findMajority(){
		if(array.length <1) return -1;
		int sizeMajority = array.length / 2;
		
		int contMajority = 0, value = 0;
		for(int i = 0; i < array.length; i++){
			if(contMajority == 0){
				value = array[i];
				contMajority = 1;
			}
			else if(value == array[i]) contMajority++;
			else contMajority--;
		}
		
		int totalMajority = 0;
		for(int i = 0; i < array.length; i++){
			if(array[i] == value)totalMajority++;
			if(totalMajority > sizeMajority)return value;
		}
		
		return -1;
	
	}
}