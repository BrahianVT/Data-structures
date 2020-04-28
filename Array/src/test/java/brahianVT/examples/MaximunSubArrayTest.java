package brahianVT.examples; 
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MaximunSubArrayTest{

		ByteArrayOutputStream out = null;
		PrintStream stremTest = System.out;
		
		@BeforeEach
		public void setUp(){
			out = new ByteArrayOutputStream();
			System.setOut(new PrintStream(out));
		}
		
		@AfterEach
		public void reset(){
			System.setOut(stremTest);
		}
		@Test
		public void allInteger(){
			int[] array = {1,2,3,4,5};
			MaximunSubArray test = new MaximunSubArray(array);
			test.printMaximumSubArray();
			assertEquals("1 2 3 4 5 ", out.toString());
		}
		
		@Test
		public void check2(){
			int[] array = {-3,4,-10,-1,-6,8,8,-8,-6,-5,-5,-9};
			MaximunSubArray test = new MaximunSubArray(array);
			test.printMaximumSubArray();
			assertEquals("8 8 ", out.toString());
		}
		
		@Test
		public void checkNotPrint(){
			int[] array = {-1,-2,-4,-5,-7};
			MaximunSubArray test = new MaximunSubArray(array);
			test.printMaximumSubArray();
			assertEquals("", out.toString());
		}
		
		@Test
		public void checkEmptyArray(){
			int[] array = {};
			MaximunSubArray test = new MaximunSubArray(array);
			test.printMaximumSubArray();
			assertEquals("", out.toString());
		}
		
		@Test
		public void checkArraySingle(){
			int[] array = {1};
			MaximunSubArray test = new MaximunSubArray(array);
			test.printMaximumSubArray();
			assertEquals("1 ", out.toString());
		}
		
		@Test
		public void check3(){
			int[] array = {8,-1,-2,-3,-4,-5,9};
			MaximunSubArray test = new MaximunSubArray(array);
			test.printMaximumSubArray();
			assertEquals("9 ", out.toString());
		}
}