import java.util.*;

/**
	@Autor: Brahian Velazquez Tellez
	Implement Binary Search Tree for Objects that can be compare
*/

public class BSTG <T extends Comparable<T>> {
	
	private int treeSize;
	private Node root = null;
	
	public boolean add(T data){
		if(contains(data)) return false;
		
		root = add(root,data);
		treeSize++;
		return true;
	}
	
	private Node add(Node root, T data){
		if(root == null)return new Node(data);
		else{
			int cmp = data.compareTo(root.data);
			if(cmp > 0)
				root.right = add(root.right, data);
			else
				root.left = add(root.left, data);
		}
		return root;
	}
	
	public boolean remove(T data){
		if(!contains(data)) return false;
		else{
			root =  remove(root, data);
			treeSize--;
			return true;
		}
	}
	private Node remove(Node root, T data){
		if(root == null)return null;
		
		int cmp = data.compareTo(root.data);
		if(cmp > 0)
			root.right = remove(root.right, data);
		else if( cmp < 0)
			root.left = remove(root.left, data);
		else{
			if(root.left == null){
				Node right = root.right;
				root.data = null;
				root = null;
				return right;
			}
			else if(root.right == null){
				Node left = root.left;
				root.data = null;
				root = null;
				return left;
			}
			else{
				Node successor = findSuccesor(root.right);
				root.data = successor.data;
				root.right = remove(successor.right, successor.data);
			}
			
		}
		return root;
	}
	
	private Node findSuccesor(Node data){
		while(data.left != null)
			data = data.left;
		
		return data;
	}
	
	public boolean contains(T data){
		if(data == null) return false;
		
		return contains(root, data);
	}
	
	private boolean contains(Node root, T data){
		if(root == null) return false;
		
		int cmp = data.compareTo(root.data);
		if(cmp > 0)
			return contains(root.right, data);
		else if(cmp < 0)
			return contains(root.left, data);
		else return true;
	}
	
	public int height(){
		return height(root);
	}
	
	public int height(Node root){
		if(root == null)return 0;
		
		return Math.max(height(root.left), height(root.right)) + 1;
	}
	
	public java.util.Iterator <T> traverse(TreeTraversalOrder order){
		switch(order){
			case PRE_ORDER: return preOrderTraversal();
			case IN_ORDER: return inOrderTraversal();
			case POST_ORDER: return postOrderTraversal();
			case LEVEL_ORDER: return levelOrderTraversal();
			default : return null;
		}
	}
	
	private java.util.Iterator<T> preOrderTraversal(){
		final int expectedNodeCount = treeSize;
		final java.util.Stack<Node> stack = new java.util.Stack<>();
		
		stack.push(root);
		
		return new java.util.Iterator<T>(){
			@Override
			public boolean hasNext(){
				if(expectedNodeCount != treeSize)throw new java.util.ConcurrentModificationException();
				return root != null && !stack.isEmpty(); 
			}
			
			@Override
			public T next(){
				if(expectedNodeCount != treeSize)throw new java.util.ConcurrentModificationException();
				Node node = stack.pop();
				if(node.right != null)stack.push(node.right);
				if(node.left != null)stack.push(node.left);
				return node.data;
			}
			
			@Override 
			public void remove(){
				throw new UnsupportedOperationException();
			}
		};
	}
	
	private java.util.Iterator<T> inOrderTraversal(){
		final int expectedNodeCount = treeSize;
		final java.util.Stack<Node> stack = new java.util.Stack<>();
		stack.push(root);
		
		return new java.util.Iterator<T>(){
			Node trav = root;
			
			@Override
			public boolean hasNext(){
				if(expectedNodeCount != treeSize)throw new java.util.ConcurrentModificationException();
				return root != null && !stack.isEmpty();
			}
			
			@Override
			public T next(){
				if(expectedNodeCount != treeSize)throw new java.util.ConcurrentModificationException();
				
				while( trav != null && trav.left != null){
					stack.push(trav.left);
					trav = trav.left;
				}
				
				Node node = stack.pop();
				
				if(node.right != null){
					stack.push(node.right);
					trav = node.right;
				}
				
				return node.data;
			}
			
			@Override 
			public void remove(){
				throw new UnsupportedOperationException();		
			}
		};
	}
	
	private java.util.Iterator<T> postOrderTraversal(){
		final int expectedNodeCount = treeSize;
		final java.util.Stack<Node> stack = new java.util.Stack();
		final java.util.Stack<Node> stack2 = new java.util.Stack();
		
		stack.push(root);
		while(!stack.isEmpty()){
			Node node = stack.pop();
			if(node != null){
				stack2.push(node);
				if(node.left != null)stack.push(node.left);
				if(node.right != null)stack2.push(node.right);
			}
		}
		return new java.util.Iterator<T>(){
			@Override
			public boolean hasNext(){
				if(expectedNodeCount != treeSize) throw new UnsupportedOperationException();
				return root != null && !stack2.isEmpty();
			}
			
			@Override
			public T next(){
				return stack2.pop().data;
			}
			
			@Override 
			public void remove(){
				throw new UnsupportedOperationException();
			}
		};
	}
	private java.util.Iterator<T> levelOrderTraversal(){
		final int expectedNodeCount = treeSize;
		final java.util.Queue<Node> queue = new java.util.LinkedList<>();
		queue.add(root);
		
		return new java.util.Iterator<T>(){
			@Override
			public boolean hasNext(){
				if(expectedNodeCount != treeSize) throw new UnsupportedOperationException();
				return root != null && !queue.isEmpty();
			}
			@Override
			public T next(){
				if(expectedNodeCount != treeSize) throw new UnsupportedOperationException();
				Node node = queue.poll();
				if(node.left != null)queue.add(node.left);
				if(node.right != null)queue.add(node.right);
				return node.data;		
			}
			@Override
			public void remove(){
				throw new UnsupportedOperationException();
			}
			
		};
	}
	
	 public static void main(String args[]){
		 
		 BSTG<Integer> tree = new BSTG<>();
		 tree.add(1);
		 tree.add(8);
		 tree.add(2);
		 tree.add(3);
		 tree.add(5);
		 tree.add(4);
		 tree.add(9);
		 tree.add(10);
		 
		 System.out.println(" In Order");
		
		 Iterator<Integer> inOrder = tree.traverse(TreeTraversalOrder.IN_ORDER);
		 while(inOrder.hasNext()){
			 System.out.print(" " + inOrder.next());
		 }
		 System.out.println("\n eliminar 1 : " + tree.remove(1));
		 inOrder = tree.traverse(TreeTraversalOrder.IN_ORDER);
		 while(inOrder.hasNext()){
			 System.out.print(" " + inOrder.next());
		 }
		 System.out.println("\n eliminar 5 : " + tree.remove(5));
		 
		 inOrder = tree.traverse(TreeTraversalOrder.IN_ORDER);
		 while(inOrder.hasNext()){
			 System.out.print(" " + inOrder.next());
		 }
		 
		 System.out.println("\n eliminar 8 : " + tree.remove(8));
		 inOrder = tree.traverse(TreeTraversalOrder.IN_ORDER);
		 while(inOrder.hasNext()){
			 System.out.print(" " + inOrder.next());
		 }
		
		System.out.println("\n PreOrder ");
		Iterator<Integer> preOrder = tree.traverse(TreeTraversalOrder.PRE_ORDER);
		while(preOrder.hasNext()){
			 System.out.print(" " + preOrder.next());
		 }
		 
		System.out.println("\n PostOrder");
		Iterator<Integer> postOrder = tree.traverse(TreeTraversalOrder.POST_ORDER);
		while(postOrder.hasNext()){
			 System.out.print(" " + postOrder.next());
		 }
		 
		 System.out.println("\n LevelOrder");
		Iterator<Integer> levelOrder = tree.traverse(TreeTraversalOrder.LEVEL_ORDER);
		while(levelOrder.hasNext()){
			 System.out.print(" " + levelOrder.next());
			 
		 }
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