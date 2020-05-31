package brahianVT.hashtable;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import brahianVT.hashtable.HashTableOpenAddressing;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Random;
import java.util.*;


public class HashTableOpenAddressingTest{
	
	static class HashObject{
		final int hash, data;
		
		public HashObject(int hash, int data){
			this.hash = hash;
			this.data = data;
		}
		
		@Override
		public int hashCode(){
			return hash;
		}
		
		@Override
		public boolean equals(Object o){
			HashObject ho = (HashObject) o;
			return hashCode() == ho.hashCode() && data == ho.data;
		}
	}
	
	static final Random RANDOM = new Random();
	static  int LOOPS, MAX_SIZE, MAX_RAND_NUM;
	
	static{
		LOOPS = 50; MAX_SIZE = RANDOM.nextInt((750 - 1) +1 ) + 1;
		MAX_RAND_NUM = RANDOM.nextInt((350 - 1) + 1) + 1;
	}
	
	HashTableOpenAddressing<Integer,Integer> map;
	
	@BeforeEach
	public void setup(){
		map = new HashTableOpenAddressing<>();
	}
	
	@Test
	public void testThrowExceptions(){
		assertAll("Test All Exceptions",
		() -> assertThrows(IllegalArgumentException.class, () -> map.put(null, 5)),
		() -> assertThrows(IllegalArgumentException.class, () -> new HashTableOpenAddressing(5, Double.POSITIVE_INFINITY)),
		() -> assertThrows(IllegalArgumentException.class, () -> new HashTableOpenAddressing(-3, 0.5)),
		() -> assertThrows(IllegalArgumentException.class, () -> new HashTableOpenAddressing(6, -0.5))
		);
	}
	
	@Test 
	public void testCreation(){
		new HashTableOpenAddressing<>(6, 0.9);
		
	}
	
	@Test public void testUpdatingValue(){
		map.add(1,1);
		assertTrue(1 == map.get(1));
		
		map.add(1, 5);
		assertTrue(5 == map.get(1));
		
		map.add(1, -7);
		assertTrue(-7 == map.get(1));
	}
	
	private void assertCapacityIsPowerOfTwo(HashTableOpenAddressing<Integer, Integer> ht){
		int sz = ht.getCapacity();
		if( sz == 0) return;
		assertTrue((sz & (sz - 1)) == 0);		
	}
	
	@Test
	public void testTableSize(){
		int loops = 10000;
		for(int sz = 1; sz <=32; sz++){
			HashTableOpenAddressing<Integer, Integer> ht;
			ht = new HashTableOpenAddressing<>(sz);
			
			for(int i = 0; i < loops; i++){
				assertCapacityIsPowerOfTwo(ht);
				ht.add(i, i);
			}
		}
	}
	
	@Test 
	public void testIterator(){
		
		HashMap<Integer, Integer> map2 = new HashMap<>();
		
		for(int loop = 0; loop < LOOPS; loop++){
			map.clear(); map2.clear(); 
			assertTrue(map.isEmpty());
			
			map = new HashTableOpenAddressing<>();
			
			List<Integer> random_nums = genRandList(MAX_SIZE);
			for(Integer key: random_nums)assertEquals(map.add(key, key), map2.put(key, key));
			
			int count = 0;
			
			for(Integer key : map){
				assertEquals(key, map.get(key));
				assertEquals(map.get(key), map2.get(key));
				assertTrue(map.hasKey(key));
				assertTrue(random_nums.contains(key));
				count++;
			}
			
			for(Integer key: map2.keySet()){
				assertEquals(key, map.get(key));
			}
			
			Set<Integer> set = new HashSet<>();
			for( int n: random_nums) set.add(n);
			
			assertEquals(set.size(), count);
			assertEquals(map2.size(), count);
			
		}
	}
	
	public void testConcurrentModificationException(){
		assertThrows( java.util.ConcurrentModificationException.class,() -> {
			map.add(1, 1);
			map.add(2, 1);
			map.add(3, 1);
			for (Integer key : map) map.add(4, 4);
		});
	}
	
	public void testConcurrentModificationException2(){
		assertThrows(java.util.ConcurrentModificationException.class, () -> {
			map.add(1, 1);
			map.add(2, 1);
			map.add(3, 1);
			for (Integer key : map) map.remove(2);
		});
	}
	
	@Test
	public void randomRemove(){
		HashTableOpenAddressing<Integer, Integer> map;
		
		for(int loop = 0; loop < LOOPS; loop++){
			map = new HashTableOpenAddressing<>();
			map.clear();
			
			// Add some random values
			
			Set<Integer> keys_set = new HashSet<>();
			
			for(int i = 0; i < MAX_SIZE; i++){
				int  randomVal = RANDOM.nextInt((MAX_RAND_NUM - MAX_RAND_NUM) + MAX_RAND_NUM) + 1;
				keys_set.add(randomVal);
				map.put(randomVal, 5);
			}
			
			assertEquals(map.size(), keys_set.size());
			
			List<Integer> keys = map.keys();
			for(Integer key: keys) map.remove(key);
			
			assertTrue(map.isEmpty());
		}
	}
	
	@Test
	public void removeTest(){
		HashTableOpenAddressing<Integer, Integer> map = new HashTableOpenAddressing<>(7);
		
		map.put(11,0);
		map.put(12,0);
		map.put(13,0);
		assertTrue(map.size() == 3);
		
		// Add ten more
		
		for(int i = 1; i<= 10; i++){
			map.put(i,0);
		}
		assertEquals(13, map.size());
		
		for(int i = 1; i<= 10; i++) map.remove(i);
		
		// remove three
		map.remove(11); map.remove(12); map.remove(13);
		assertEquals(0, map.size());
	}
	
	@Test
	public void removeTestComplex1(){
		
		
		HashTableOpenAddressing<HashObject, Integer> map = new HashTableOpenAddressing<>();
		
		HashObject o1 = new HashObject(88, 1);
		HashObject o2 = new HashObject(88, 2);
		HashObject o3 = new HashObject(88, 3);
		HashObject o4 = new HashObject(88, 4);
		
		map.add(o1, 111); map.add(o2, 111);
		map.add(o3, 111); map.add(o4, 111);
		
		map.remove(o2); map.remove(o4);
		map.remove(o1); map.remove(o3);
		assertEquals(0, map.size());
	}
	
	
	@Test
	public void testRandomMapOperations(){
		HashMap<Integer, Integer> jmap = new HashMap<>();
		
		for(int loop = 0; loop < LOOPS; loop++){
			map.clear(); jmap.clear();
			
			assertEquals(jmap.size(), map.size());
			
			map = new HashTableOpenAddressing<>();
			final double probability1 = Math.random();
			final double probability2 = Math.random();
			
			List<Integer> nums = genRandList(MAX_SIZE);
			
			for(int i = 0; i < MAX_SIZE; i++){
				double r = Math.random();
				
				int key = nums.get(i);
				int val = i;
				
				if(r < probability1){
					assertEquals(jmap.put(key, val), map.put(key, val));
				}
				
				assertEquals(jmap.get(key), map.get(key));
				assertEquals(jmap.containsKey(key), map.containsKey(key));
				assertEquals(jmap.size(), map.size());
				
				if(r > probability2) assertEquals(map.remove(key), jmap.remove(key));
				
				assertEquals(jmap.get(key), map.get(key));
				assertEquals(jmap.containsKey(key), map.containsKey(key));
				assertEquals(jmap.size(), map.size());
			}
		}
	}
	
	
	@Test
	public void randomIteratorTests(){
		HashTableOpenAddressing<Integer, LinkedList<Integer>> m = new HashTableOpenAddressing<>();
		HashMap<Integer, LinkedList<Integer>> hm = new HashMap<>();
		
		for(int loop = 0; loop < LOOPS; loop++){
			m.clear(); hm.clear();
			assertEquals(m.size(), hm.size());
			
			int sz = RANDOM.nextInt((MAX_SIZE -1) +1) + 1;
			m = new HashTableOpenAddressing<>(sz);
			hm = new HashMap<>(sz);
			
			final double probability = Math.random();
			
			for(int i = 0; i < MAX_SIZE; i++){
				int index = RANDOM.nextInt(MAX_SIZE -1);
				LinkedList<Integer> l1 = m.get(index);
				LinkedList<Integer> l2 = hm.get(index);
				
				if(l2 == null){
					l1 = new LinkedList<Integer>();
					l2 = new LinkedList<Integer>();
					m.put(index, l1);
					hm.put(index, l2);
				}
				
				int randVal = RANDOM.nextInt((MAX_SIZE - MAX_SIZE) + MAX_SIZE) + 1;
				if(Math.random() < probability){
					l1.removeFirstOccurrence(randVal);
					l2.removeFirstOccurrence(randVal);
				} else {
					l1.add(randVal); l2.add(randVal);
				}
				
				assertEquals(m.size(), hm.size());
				assertEquals(l1, l2);
			}
		}
	}
	
	static List<Integer> genRandList(int total){
		List<Integer> randomList = new ArrayList<>(total);
		int count = 0;
		for(int i = 0; i < total; i++){
			randomList.add( RANDOM.nextInt((MAX_RAND_NUM - MAX_RAND_NUM) + MAX_RAND_NUM) + 1 );	
		}
		
		return randomList;
	}
	
	static List<Integer> getUniqueRandList(int total){
		List<Integer> listRandom = new ArrayList<>(total);
		for(int i = 0; i < total; i++) listRandom.add(i);
		Collections.shuffle(listRandom);
		return listRandom;
	}
}