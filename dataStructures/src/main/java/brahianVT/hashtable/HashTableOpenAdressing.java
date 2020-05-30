package brahianVT.hashtable;

/**
	Implementation of a hahtable with open addressing technique
	using a quadratic probing to deal with collisions
	@author Brahian VT
*/

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

public class HashTableOpenAddressing<K, V> implements Iterable<K>{

	private double loadFactor;
	private int capacity, threshold, modificationCount;
	
	/* usedBuckets' counts the total number of used buckets inside the 
	   hash-table (includes cells marked as deleted). While 'keyCount'
	   tracks the number of unique keys, currently inside the hash-table */
	   
	private int usedBuckets, keyCount;
	
	// Two arrays to store the key-value  hashmap elements 
	
	private K[] keys;
	private V[] values;
	
	// Special token used to indicate the deletion of a key-value pair
	
	private final K TOMBSTONE = (K) (new Object());
	
	// Should be a prime number
	private static final int DEFAULT_CAPACITY = 7;
	private static final double DEFAULT_LOAD_FACTOR = 0.65;
	
	public HashTableOpenAddressing(){
		this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
	}
	
	public HashTableOpenAddressing(int capacity) {
		this(capacity, DEFAULT_LOAD_FACTOR);
	}
	
	public HashTableOpenAddressing(int capacity, double loadFactor){
		if(capacity <= 0) throw new IllegalArgumentException("Negative capacity");
		
		if(loadFactor <= 0 || Double.isNaN(loadFactor) || Double.isInfinite(loadFactor))
			throw new IllegalArgumentException("Illegal loadFactor " + loadFactor);
		
		this.loadFactor = loadFactor;
		this.capacity = Math.max(capacity, DEFAULT_CAPACITY);
		
		threshold = (int) (this.capacity * loadFactor);
		
		keys = (K[]) new Object[this.capacity];
		value = (V[]) new Object[this.capacity];
	}
	
	
	public int probe(int x){
		// quadratic probing f(x) = (x^2+x)/2
		return (x * x + x) >> 1;
	}
	
	
	// find the next power of two number above n
	private static int nextPowerOfTwo(int n){
		return Integer.highestOneBit(n) << 1;
	}
	private void increaseCapacity(){
		capacity = nextPowerOfTwo(capacity);
	}
	
	private  void adjustCapacity(){
		int pow2 = Integer.highestOneBit(capacity);
		if(capacity == pow2) return;	
		increaseCapacity();
	}
	
	public void clear(){
		for(int i = 0; i < capacity; i++){
			keys[i] = null; values[i] = null;
		}
		
		keyCount = usedBuckets = 0;
		modificationCount++;
	}
	
	public int size(){ return keyCount; }
	
	public int getCapacity(){ return capacity; }
	
	public boolean isEmpty(){ return keyCount == 0; }
	
	public V put(K key, V value){
		return insert(key, value);
	}
	
	public V add(K key, V value){
		return insert(key, value);
	}
	
	public boolean containsKey(K key){
		return hasKey(key);
	}
	
}