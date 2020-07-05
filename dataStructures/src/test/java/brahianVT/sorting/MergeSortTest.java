package brahianVT.sorting;


import brahianVT.sorting.MergeSort;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class MergeSortTest{
	
	MergeSort test;
	@BeforeEach
	public void setup(){
		
		test = new MergeSort();
	}
	
	@Test
	public void sorting1(){
		int array[] = {3,5,67,8,9,1};
		
		int res[] = {1,3,5,8,9,67};
		
		assertArrayEquals(res, test.mergeSort(array));
		
	}
	
	@Test
	public void sorting2(){
		int array[] = {1,5,67,8,9,3};
		
		int res[] = {1,3,5,8,9,67};
		
		assertArrayEquals(res, test.mergeSort(array));
		
	}
	
	
	@Test
	public void sorting3(){
		int array[] = {9,8,7,6,5,4};
		
		int res[] = {4,5,6,7,8,9};
		
		assertArrayEquals(res, test.mergeSort(array));
		
	}
	
		@Test
	public void sorting4(){
		int array[] = {8,1,7,3,5,4};
		
		int res[] = {1,3,4,5,7,8};
		
		assertArrayEquals(res, test.mergeSort(array));
		
	}
	
}
