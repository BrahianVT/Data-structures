/**
	Given the level and inorder traversal
	find the height of a binary search tree
	without construct the tree
  @Author: Brahian Velazquez Tellez
*/

import java.util.Arrays;
public class Example6{
	
	private int getIndexRoot(int[] in, int start, int end, int elem){
		if( start == end) end++;
		return Arrays.binarySearch(in, start,end,elem);
	}
	
	public int getHeight(int[]in, int[] level, int start,int end,int n){
		if(level.length == 0) return 0;
		
		int indexRoot = getIndexRoot(in, start, end+1, level[0]);
		
		int leftSize =  indexRoot - start;  int rightSize = end - indexRoot;
		
		int totalLeft = 0; int totalRight = 0; 
		
		int[] leftLevel = new int[leftSize];
		int[] rightLevel = new int[rightSize];
		
		int i = 0;  int k = 0;
		while( k < leftSize){
			int index = getIndexRoot(in, start, indexRoot, level[i]);
			if(index > -1){
				leftLevel[k]= level[i];
				k++;
			}
			i++;
		}
		
		
		k = 0; i = 0;
		while(k < rightSize){	
			int index = getIndexRoot(in, indexRoot+1, end+1, level[i]);
			if(index > -1){
				rightLevel[k] = level[i];
				k++;
			}
			i++;
		}	
		
		
		totalLeft = getHeight(in, leftLevel, start, indexRoot-1, leftSize);
		
		totalRight = getHeight(in, rightLevel, indexRoot+1, end, rightSize);
		
		leftLevel = null; rightLevel = null;
		
		return Math.max(totalLeft, totalRight) + 1;
	}
	
	public static void main(String[] args){
		
		int[] in = {4, 8, 10, 12, 14, 20, 22};
		int[]level = {20, 8, 22, 4, 12, 10, 14};
		
		int end = level.length - 1;
		int n = level.length;
		
		Example6 exa = new Example6();
		System.out.println("The height is : " + exa.getHeight(in, level, 0, end, n));
	}
}