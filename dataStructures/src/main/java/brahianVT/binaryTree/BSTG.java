
/**
Implementation of a generic Binary search Tree

 @author Brahian VT
*/

import java.util.*;


public class BSTG< T extends Comparable<T>> {
		
	private Node root;
	int size;


	public T add(T ele){
		
		if(ele == null) throw new IllegalArgumentException("Null element");
		 
		root = add(root, ele);
		size++;
		return ele;
	}
	
	private Node add(Node root, T ele){
		if(ele == null) return new Node(ele);
		int cmp = ele.compareTo(root.data);
		
		if(cmp > 0)
			root.right = add(root.right, ele);
		else
			root.left = add(root.left, ele);
		
	return root;
	}
	
	public boolean remove(T element){
		if(element == null) throw  new IllegalArgumentException("Null element");
		
		if(!find(element) || size == 0) return false;
		else{
			root = remove(root, element);
			size--;
			return true;
		}
	}
	
	private Node remove(Node root, T ele){
		if(root == null) return null;
		int cmp = ele.compareTo(root.data);
		if(cmp > 0){
			root.right = remove(root.right, ele);
		}
		else if(cmp < 0){
			root.left = remove(root.left, ele);
		}
		else{
			if(root.left == null){
				Node right = root.right;
				root.data = null; root.right = null;
				return right;
			}
			else if(root.right == null){
				Node left = root.left;
				root.data = null; root.left = null;
				return left;
			}
			else {
				// find successor most left element in right sub-tree
				Node succesor = findSuccesor(root.right);
				root.data = succesor.data;
				
				root.right = remove(root.right, succesor.data);
				
			}
			
		}
		return root;
	}
	
	private Node findSuccesor(Node root){
		if(root.left == null) return root;
		return findSuccesor(root.left);
	}
	
	
	public int size() { return size; }
	
	public int height(){
		return height(root);
	}
	
	public int height(Node root){
		if(root == null) return 0;
		
		return Math.max(height(root.left), height(root.right))  + 1;
	}
	
	public Iterator<T> preOrderTraversal(){
		final Stack<Node> stack = new Stack<Node>();
		final int auxSize = size;
		stack.push(root);
		
		return new Iterator<T>(){
						
			public boolean hasNext(){
				if(auxSize != size) throw new ConcurrentModificationException();
				return root != null &&  !stack.isEmpty();
				}
			
			public T next(){
				if(auxSize != size) throw new ConcurrentModificationException();
				Node  next = stack.pop();
				if( next.right != null) stack.push(next.right);
				if( next.left != null) stack.push(next.left);
				
				return next.data;
			}
			
			public void remove(){ throw new UnsupportedOperationException(); }
		};
	}
	
	public Iterator<T> inOrderTraversal(){
		final Stack<Node> stack = new Stack<Node>();
		final int auxSize = size;
		stack.push(root);
		return new Iterator<T>(){
			Node iter = root;
			
			public boolean hasNext(){
				if(auxSize != size) throw new ConcurrentModificationException();
				
				return root != null && !stack.isEmpty();
			}
			
			public T next(){
				if(auxSize != size) throw new ConcurrentModificationException();
				while( iter != null && iter.left != null){
					stack.push(iter);
					iter = iter.left;
				}
				
				Node next = stack.pop();
				
				if(next.right != null) iter = next.left;
				return next.data;
			}
			
			public void remove(){
				throw new UnsupportedOperationException();
			}
		};
	}
	
	public Iterator<T> postOrderTraversal(){
		final Stack<Node> stack = new Stack<Node>();
		final Stack<Node> stack2 = new Stack<Node>();
		final int auxSize  = size;
		stack.push(root);
		
		while(!stack.isEmpty()){
			
			Node aux = stack.pop();
			if(aux.left != null) stack.push(aux.left);
			if(aux.right != null) stack.push(aux.right);
			stack2.push(aux);
		}
		return new Iterator<T>(){
			public boolean hasNext(){
				if(auxSize != size) throw new ConcurrentModificationException();
				
				return root != null && !stack.isEmpty();
			}
			
			public T next(){
				if(auxSize != size) throw new ConcurrentModificationException();
				return stack2.pop().data;
			}
			
			public void remove(){
				throw new UnsupportedOperationException();
			}
		};
	}
	
	
	public boolean find(T element){
		if( element == null)throw new IllegalArgumentException("Null element");
			
		return find(root, element);
	}
	
	private boolean find(Node root, T ele){
		if(root == null) return false;
			int  cmp = ele.compareTo(root.data);
			if(cmp > 0)
				return find(root.right, ele);
			else if(cmp < 0)
				return find(root.left, ele);
			else return true;
	}


	private class Node{
	  T data;
	  Node right, left;
	  public Node( T data){
		  this.data = data;
		  this.right = null;
		  this.left = null;
	  }
  }	
}