package brahianVT.BitwiseOperators;

/**
  Examples of some useful hacks with bitwise operators.
  
  @author Brahian VT
*/
public class BitwiseHack{
	
	// counts all bits in a number
	public int countBit(int val){
		
		int i;
		
		for(i = 0; val > 0; i++){
			val &= val - 1 ; // clear the least significant bit set
		}
		
		/*
			 x = x - ((x >> 1) & 0x55555555);
			 x = (x & 0x33333333) + ((x >> 2) & 0x33333333);
			 x = (x + (x >> 4)) & 0x0F0F0F0F;
			 x = x + (x >> 8);
			 x = x + (x >> 16);
			 return x & 0x0000003F;
		*/
		return i;
	}
	
	/*
		designed for 32 bits
		val must be positive and ≤ 2^31, else results are undefined
	*/
	public int nextPowerOfTwo(int x){
		x --;
		x |= x >> 1; // 2 bits numbers
		x |= x >> 2;
		x |= x >> 4;
		x |= x >> 8;
		x |= x >> 16;
		
		x++;
		return x;
	}
	
	/**
		Swap two values
		This is achieve using xor operations		
	*/
	
	public String swap(int a, int b){
		a ^= b;
		b ^= a;
		a ^= b;
		return a+","+b;
	}
	
	
	// Absolute value of an integer
	public int absoluteValue(int x){
		int bit31 = x >> 31;
		return (x ^ bit31) - bit31;
	}
}