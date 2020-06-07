
package brahianVT.BitwiseOperators;
/**
  Examples with bitwise operators
  @author Brahian VT
*/

public class Bitwise{
	
	public int setBit(int val, int positions){
		int mask = 1 << positions;
		return mask | val;
	}
	
	public int cleanBit(int val, int positions){
		int mask = 1 << positions;
		return ~ mask & val;
	}
	
	public int flipBit(int val, int positions){
		int mask = 1 << positions;
		return mask ^ val; 
	}
	
	public int ckeckBit(int val, int positions){
		int mask = val >> positions;
		return mask & 1;
	}
	
	public int modifiyBit(int val, int positions, int newVal){
		int mask = 1 << positions;
		return (~mask & val) | (-newVal & mask);
	}
	
	public boolean isOdd(int val){ return (val & 1) == 0; }
	
	public boolean isPowOfTwo(int val){ return (val & val-1) == 0; }
	
	public static void main(String args[]) {
		Bitwise test = new Bitwise();
		
		System.out.println(" -----BitWise operators");
		
		int x = 10, y = 5;
		int and = x | y;
		int or = x & y;
		int not = ~x;
		int xor = x ^ y;
		
		System.out.println(" And " + and);
		System.out.println(" Or " + or);
		System.out.println(" Not " + not);
		System.out.println(" Xor " + xor);
		
		int val = 5;
		System.out.println(" Original bit: " + Integer.toString(val, 2)); 
  
		int res = test.setBit(val, 1);
		System.out.println(" After set a bit: " + Integer.toString(res, 2)); 
		
		 res = test.cleanBit(val, 0);
		System.out.println(" After clean a bit: " + Integer.toString(res, 2));

		 res = test.flipBit(val, 2);
		System.out.println(" After flip a bit: " + Integer.toString(res, 2));

		res = test.ckeckBit(val, 1);
		System.out.println(" After ckeck bit at 1: " + Integer.toString(res, 2));	
		
		res = test.modifiyBit(val, 0, 0);
		System.out.println(" modify position : "+0 + " to " + 0 +" : "   + Integer.toString(res, 2));	
		
		System.out.println(val + " is even ? : "+ test.isOdd(val));
      
        System.out.println(val + " is power of two ? : " + test.isPowOfTwo(val));
	}
	
	
}