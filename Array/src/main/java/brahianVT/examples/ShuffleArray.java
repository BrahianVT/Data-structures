package brahianVT.examples;
import java.util.Random;

/**
	Create a function that shuffle a array and another that revert the shuffle
	assume all the elements of the array are ints and there aren't repeted values
	@author Brahian VT
*/
public class ShuffleArray{
	
	int[] array ,auxArray;
	Random random = new Random();
	
	public ShuffleArray(int[] array){
		this.array = array;
		auxArray = array.clone();
	}
	
	
	// Here shuffle with the fish-yates algorithm
	
	public int[] shuffle(){
		if (array.length < 1) return array;
		
		for(int i = array.length; i > 1; i--){
			swap(i-1, random.nextInt(i));
		}	
		
		return array;
	}
	
	public int[] revert(){
		array = auxArray.clone();
		return array;
	}
	
	private void swap(int indexA, int indexB){
		int aux = array[indexA];
		array[indexA] = array[indexB];
		array[indexB] = aux;
	}
	
}