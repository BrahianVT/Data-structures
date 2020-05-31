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
		adjustCapacity();
		threshold = (int) (this.capacity * loadFactor);
		
		keys = (K[]) new Object[this.capacity];
		values = (V[]) new Object[this.capacity];
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
	
	// return the keys
	public List<K> keys(){
		List<K> hashtableKeys = new ArrayList<>(size());
		for(int i = 0; i < keys.length; i++){
			if(keys[i] != null && keys[i] != TOMBSTONE) hashtableKeys.add(keys[i]);
			
		}
		
		return hashtableKeys;
		
	}
	
	// Returns a List of non-unique values found in the hashtable	
	public List<V> values(){
		List<V> hashtableValue = new ArrayList<>(size());
		for(int i = 0; i < keys.length; i++){
			if(keys[i] != null && keys[i] != TOMBSTONE) hashtableValue.add(values[i]);
		}
		return hashtableValue;
	}
	
	// Double the size of the table

	private void resizeTable(){
		increaseCapacity();
		adjustCapacity();
		
		threshold = (int) (capacity * loadFactor);
		K[] oldKeyTable = (K[]) new Object[capacity];
		V[] oldValueTable = (V[]) new Object[capacity];
		
		// Perform swap with the keys
		K[] keyTableTmp = keys;
		keys = oldKeyTable;
		oldKeyTable = keyTableTmp;
		
		// Perform swap with the values 
		V[] valueTableTmp = values;
		values = oldValueTable;
		oldValueTable = valueTableTmp;
		
		keyCount = usedBuckets = 0;
		
		for(int i = 0; i < oldKeyTable.length; i++ ){
			if(oldKeyTable[i] != null && oldKeyTable[i] != TOMBSTONE)
				insert(oldKeyTable[i] , oldValueTable[i]);
			
			oldKeyTable[i] = null; oldValueTable[i] = null;
		}
	}

	// Converts a hash value to an index. This strips the negative sign
	private int normalizeIndex(int keyHash){
		return (keyHash & 0x7FFFFFFF) % capacity;
	}
	
	// Finds the greatest common denominator
	private int gcd( int a, int b){
		if(b == 0) return a;
		
		return gcd(b, a % b);
	}
	
	// Insert the K,V in  the hashtable if the value already exists the value is updated
	public V insert(K key, V value){
		if(key == null) throw new IllegalArgumentException("Null key");
		if(usedBuckets > threshold) resizeTable();

		int offset = normalizeIndex(key.hashCode());
		
		for(int i = offset, j =-1, x= 1; ; i = normalizeIndex(offset + probe(x++))){
			// The current slot was previously deleted
			if(keys[i] == TOMBSTONE){
				if(j == -1) j = i;
			}
			else if(keys[i] != null){
				// The key we're trying to insert already exists in the hash.table
				if(keys[i].equals(key)){
					V oldValue = values[i];
					if( j == -1){
						values[i] = value;
					} else {
						keys[i] = TOMBSTONE; values[i] = null;
						keys[j] = key; values[j] = value;
					}
				
					modificationCount++;
					return oldValue;
				}
				
			} else {  // it is null so we insert or update
				
				// no previously encountered deleted buckets
				if( j == -1){
					usedBuckets++; keyCount++; 
					keys[i] = key; values[i] = value;
				} else { /* instead of inserting  the new element at i  where the 
							null element  is insert it where the deleted token was found.							
							*/
						keyCount++;
						keys[j] = key;
						
						values[j] = value;
				}
				modificationCount++;
				return null;
			} 
		}
	}
	
	
	// Returns true/false on whether a given key exists within the hash-table
	public boolean hasKey( K key){
		if( key == null) throw new IllegalArgumentException("Null key");
		
		
		int offset = normalizeIndex(key.hashCode());
		
		// Start at the original hash value and probe until we find a spot where our key
		// is or hit a null element in which case our element does not exist.
		
		for(int i = offset , j = -1, x = 1 ;; i = normalizeIndex(offset + probe(x++))){
			// ignore deleted cells, but record where the first index of a deleted cell is found
			if(keys[i] == TOMBSTONE){
				if(j == -1) j = i;
			
			} else if(keys[i] != null){
				
				// The key we want is in the hash-table! 
				if(keys[i].equals(key)){
					
					/* if j != null means we previously encountered a deleted cell(TOMBSTONE)
					   Here perform an optimization by swapping the entries in cells
					   i and j so  that the next time we search for this key it will be
					   found faster. This is called lazy deletion/relocation
					 */
					 if( j != -1){
						 keys[j] = keys[i]; values[j] = values[i];
						 keys[i] = TOMBSTONE; values[i] = null;
					 }
					 return true;
				}	
				
			} else return false;
		}
	}
	
	public V get (K key){
		if(key == null) throw  new IllegalArgumentException("Null key");
		
		int offset = normalizeIndex(key.hashCode());
		
		/* Start at the original hash value and probe until we find a spot
		  or we hit a null element in which case our element does not exist
		*/

		for(int i = offset, j = -1, x = 1 ;; i = normalizeIndex(offset + probe(x++))){
			// record where the first index where found a TOMBSTONE
			if(keys[i] == TOMBSTONE){
				if( j == -1) j = i;
				
			} else if(keys[i] != null){
				
				if(keys[i].equals(key)){
					
					if(j != -1){
						keys[j] = keys[i]; values[j] = values[i];
						keys[i] = TOMBSTONE; values[i] = null;
						return values[j];
					} else return values[i];
				}
			} else return null;
		}	

	}
	
	public V remove(K key){
		if(key == null) throw new IllegalArgumentException(" Null key");
		
		int offset = normalizeIndex(key.hashCode());
		
		// Find the element or null
		for(int i = offset, x = 1 ;; i = normalizeIndex(offset + probe(x++))){
			if(keys[i] == TOMBSTONE) continue;
			
			if(keys[i] == null) return null;
			
			if(keys[i].equals(key)){
				keyCount--; modificationCount--;
				V oldValue = values[i];
				keys[i] = TOMBSTONE;
				values[i] = null;
				return oldValue;
			}
		}	
	}
	
	@Override
	public java.util.Iterator<K> iterator(){
		// Record the number of modifications . This value should not change as we iterate
		
		final int MOD_COUNT = modificationCount;
		
		return new java.util.Iterator<K>(){
			int index, keysLeft = keyCount;
			
			@Override
			public boolean hasNext(){ 
				if(MOD_COUNT != modificationCount) throw new ConcurrentModificationException();
				return keysLeft != 0;	
			}
			
			@Override
			public K next(){
				while( keys[index] == null || keys[index] == TOMBSTONE)index++;
				keysLeft--;
				return keys[index++];
			}
			
			@Override
			public void remove(){
				throw new UnsupportedOperationException();
			}
		};
	}
}