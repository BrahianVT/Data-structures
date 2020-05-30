
package brahianVT.hashtable;

/**
	Fair Candy Swap
	
	Given two arrays with number
	exchange one element of each other
	so after the exchange, they both
	have the same  total amount.
	return the two elements as an array
	Example 1:

	Input: A = [1,1], B = [2,2]
	Output: [1,2]
	Example 2:

	Input: A = [1,2], B = [2,3]
	Output: [2,3]
	Example 3:

	Input: A = [2], B = [1,3]
	Output: [2,3]
	Example 4:

	Input: A = [1,2,5], B = [2,4]
	Output: [5,4]
	
	@author Brahian VT
*/

public class HashProblem{
	
	public int[] getSwap(int[] a, int[] b){
		
		int[] res = new int[2];
		boolean[] frecB = new boolean[100001];
		
		int tolA = 0; int tolB = 0;
		for(int i: a) tolA+=i;
		
		for(int j = 0; j < b.length; j++){
			tolB+=b[j];
			frecB[b[j]] = true;
		}
		
		int diff = (tolB - tolA) /2;
		
		for(int i = 0; i < a.length; i++){
			int pair = diff + a[i];
			if(pair >= 0 && pair < 100001 && frecB[pair]){
				res[0] = a[i]; res[1] = pair;
			}
		}
		return res;
	}
}