package brahianVT.hashtable;
/**
	Implementation of a HashTable with the Separate Chaining approach,
	using linked lists to deal with collisions
	
	@author Brahian VT
**/

import java.util.*;
class Entry<K,V>{
	int hash;
	K key;
	V value;
	
	public Entry(K key, V value){
		this.key = key;
		this.value = value;
	//	System.out.println("key.hasHcode: " + key.hashCode());
		this.hash = key.hashCode();
	}
	
	// This isn't the equals method defined in the equals method class
	public boolean equals(Entry<K, V> other){
		if(other.hash != hash) return false;
		return key.equals(other.key);
	}
	
	@Override
	public String toString(){ return  key + "-> " + value; }
}

public class HashTableSeparateChaining<K,V>  implements Iterable<K> {
	
	private static final int DEFAULT_CAPACITY = 3;
	private static final double DEFAULT_LOAD_FACTOR = 0.75;
	private double maxLoadFactor;
	private int capacity, threshold, size = 0;
	
	private LinkedList<Entry<K, V>>[] table;
	
	public HashTableSeparateChaining(){ this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR); }
	public HashTableSeparateChaining(int capacity){ this(capacity, DEFAULT_LOAD_FACTOR); }
	
	public HashTableSeparateChaining(int capacity, double maxLoadFactor){
		
		if(capacity < 0) throw new IllegalArgumentException("Illegal Capacity");
		if(maxLoadFactor <= 0 || Double.isNaN(maxLoadFactor) || Double.isInfinite(maxLoadFactor))
			throw new IllegalArgumentException("Illegal maxLoadFactor");
	
		this.maxLoadFactor = maxLoadFactor;
		this.capacity = Math.max(DEFAULT_CAPACITY, capacity);
		threshold = (int) (this.capacity * maxLoadFactor);
		table = new LinkedList[this.capacity];
	}
	
	public int size(){ return size; }
	public boolean isEmpty(){ return size == 0; }
	
	// Converts a hash value to an index, this strips the negative sign and 
	// return a value between [0, capacity]
	private int normalizeIndex(int keyHash){
	//	System.out.println("normalizeIndex: " + (keyHash & 0x7FFFFFFF) % capacity);
		return (keyHash & 0x7FFFFFFF) % capacity;
	}
	
	public void clear(){
		Arrays.fill(table, null);
		size = 0;
	}
	
	public boolean constainsKey(K key){
		return hasKey(key);
	}
	
	
	
	//  If we find a key in the hashTable return true
	public boolean hasKey(K key){
		int bucketIndex = normalizeIndex(key.hashCode());
		return bucketSeekEntry(bucketIndex, key) != null;
	}
	
	public V put(K key, V value){ return insert(key, value); }
	public V add(K key, V value){ return insert(key, value); }
	
	// Insert Element in the hashTable
	public V insert(K key, V value){
		if(key == null) throw new IllegalArgumentException("Null Key");
		
		Entry<K, V> newEntry = new Entry<>(key, value);
		int bucketIndex = normalizeIndex(newEntry.hash);
	//	System.out.println("insert: " + bucketIndex +"  key: "+ newEntry.hash);
		return bucketInsertEntry(bucketIndex, newEntry);
	}
	
	// get value from hashTable return null if the key is null 
	//and if the value is null
	public V get(K key){
		if(key == null) return null;
		int bucketIndex = normalizeIndex(key.hashCode());
		//System.out.println("get: " + bucketIndex +"  key: "+ key.hashCode());
		Entry<K, V> entry = bucketSeekEntry(bucketIndex, key);
		if(entry != null)return entry.value;
		return null;
	}

	// remove element from hashTable return null if the key is null 
	//and if the value is null	
	public V remove(K key){
		if(key == null) return null;
		int bucketIndex = normalizeIndex(key.hashCode());
		return bucketRemoveEntry(bucketIndex, key);
	}
	
	// remove  entry from bucket if it exists
	public V bucketRemoveEntry(int bucketIndex, K key){
		Entry<K, V> entry = bucketSeekEntry(bucketIndex, key);
		if(entry != null){
			LinkedList<Entry<K, V>> links = table[bucketIndex];
			links.remove(entry); --size;
			return entry.value;
 		} else return null;
	}
	
	// Insert an entry in a bucket if the entry does not exist
	// But if it exists update the entry value
	private V bucketInsertEntry(int bucketIndex, Entry<K, V> entry){
		LinkedList<Entry<K ,V>> bucket = table[bucketIndex];
		if(bucket == null) table[bucketIndex] = bucket = new LinkedList<>();
		
		Entry<K, V> existentEntry = bucketSeekEntry(bucketIndex, entry.key);
		if(existentEntry == null){
			bucket.add(entry);
			if(++size > threshold) resizeTable();
			return null;
		} else {
			V oldVal = existentEntry.value;
			existentEntry.value = entry.value;
			return oldVal;
		}
	}
	
	private Entry<K, V> bucketSeekEntry(int bucketIndex, K key){
		if (key == null) return null;
		LinkedList<Entry<K, V>> bucket = table[bucketIndex];
		if(bucket == null) return null;
		for(Entry<K, V> entry: bucket) if(entry.key.equals(key)) return entry;
		return null;
	}
	
	// resize the table if the size is greater than the threshold
	private void resizeTable(){
		capacity *= 2;
		threshold = (int)(capacity * maxLoadFactor);
		LinkedList<Entry<K, V>>[] newTable = new LinkedList[capacity];
		for(int i = 0; i < table.length; i++){
			if(table[i] != null){
				for(Entry<K, V> entry : table[i]){
					int bucketIndex = normalizeIndex(entry.hash);
					LinkedList<Entry<K, V>> bucket = newTable[bucketIndex];
					if(bucket == null) newTable[bucketIndex] = bucket = new LinkedList<>();
					bucket.add(entry);
				}
				table[i].clear(); table[i] = null;
			}
		}
		table = newTable;
		
	}
	
	public List<K> keys(){
		List<K> keys = new ArrayList<>();
		
		for(LinkedList<Entry<K, V>> bucket: table)
			if(bucket != null) for(Entry<K, V> entry: bucket)keys.add(entry.key);
		return keys;
	}
	
	public List<V> values(){
		List<V> values = new ArrayList<>();
		
		for(LinkedList<Entry<K ,V>> bucket: table)
			if(bucket != null) for(Entry<K, V> entry: bucket)values.add(entry.value);
		return values;
	}
	
	// Mandatory override iterator() method
	public java.util.Iterator<K> iterator(){
		final int elementCount = size();
		return new java.util.Iterator<K>(){
			
			int bucketIndex = 0;
			java.util.Iterator<Entry<K, V>> bucketIter = (table[0] == null)?null:table[0].iterator();
			@Override public boolean hasNext(){
				// An item was added or removed while itarating
				if(elementCount != size) throw new java.util.ConcurrentModificationException();
				
				// No iterator or the current iterator is empty
				if(bucketIter == null || !bucketIter.hasNext()){
					while( ++bucketIndex < capacity){
						if(table[bucketIndex] != null){
							java.util.Iterator<Entry<K, V>> nextIter = table[bucketIndex].iterator();
							if(nextIter.hasNext()){
								bucketIter = nextIter;
								break;
							}
						}
					}
				}
				return bucketIndex < capacity;
			}
			
			@Override public K next(){
				return bucketIter.next().key;
			}
			
			@Override public void remove(){ throw new UnsupportedOperationException(); }
		};
	}
	
}