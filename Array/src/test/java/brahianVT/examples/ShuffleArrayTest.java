package brahianVT.examples;

import java.util.Random;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.Arrays;

public class ShuffleArrayTest{
	
	
	@Test 
	public void basicShuffling(){
		int[] array = {1,2,3,4,5};
		ShuffleArray test = new ShuffleArray(array.clone());	
		assertFalse(Arrays.equals(array, test.shuffle()));
	}
	
	@Test 
	public void shufflingRevert(){
		int[] array = {1,2,3,4,5};
		ShuffleArray test = new ShuffleArray(array.clone());
		test.shuffle();
		assertArrayEquals(array, test.revert());
	}
	
	@Test 
	public void shufflingRevertShuffling(){
		int array[] = {3,5,67,8,9,1};
		ShuffleArray test = new ShuffleArray(array.clone());
		test.shuffle(); test.revert();
		
		assertFalse(Arrays.equals(array, test.shuffle()));
	}
}