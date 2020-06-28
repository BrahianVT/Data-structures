package brahianVT.binaryTree;
import java.util.*;
/**
	@Autor: Brahian Velazquez Tellez
	Implement Binary Search Tree for Integer values
*/

public class BST{
	Node root = null;
	int size = 0;
	
	public boolean find(Integer data){
		Node iter = root;
		if(iter == null) return false;
		
		while(iter != null){
			if(root.data > data)
				iter = iter.left;
			else if(root.data < data)
				iter = iter.right;
			else return true;
		}
		
		return false;
	}
	
	public boolean add(Integer e){
		Node element = new Node(e);
		if(root == null){ root = element; return true; }
		
		Node iter = root;
		while(iter != null){
			if(root.data > e){
				if(root.left == null){
					size++;
					root.left = element; break; 
				}
				iter = iter.left;
			} else{
				if(root.right == null){
					size++;
					root.right = element; break;					
			}
			}
			
		}
		
		return false;
	}
	
	public boolean remove(Integer e){
		
		if(root == null)return false;
		
		Node iter = root;
		Node parent = null;
		boolean isLeftChild = false;
		
		while(iter != null){
			parent = iter;
			
			if(iter.data > e){
				isLeftChild = true;
				iter = iter.left;
			}else if(iter.data < e){
				isLeftChild = false;
				iter = iter.right;
			}
			
			if(iter.data == e)break;
			if(iter == null) return false;
			
		}

		// Here just if we find the node
		
		if(iter.left == null && iter.right == null){
			if(iter == root){
				root = null; 
			}else{
				if(isLeftChild)
					parent.left = null;
				else
					parent.right = null;
			}
			size--;
			return true;
		}
		else if(iter.left == null){
			if(isLeftChild)
				parent.left = iter.right;
			else
				parent.right = iter.right;
			
			size--;
			return true;
		}
		else if(iter.right == null){
			if(isLeftChild)
				parent.left = iter.left;
			else
				parent.right = iter.left;
			
			size--;
			return true;
		}
		else{
			// when the node to delete has both children
			
			// Search for the most left value in the right sub-true	
			
			Node succesor = mostLeftNode(iter);
			succesor.left = iter.left;
			
			if(isLeftChild)
				parent.left = succesor;
			else
				parent.right = succesor;
			
			iter.right = iter.left = null;
			
			size--;
			return true; 
		}
	}
	
	public Node getRoot(){ return root; }
	
	
	public void printPreOrder(){
		if(root == null)return;
		System.out.println(" " + root.data);
		printPreOrder();
		printPreOrder();
	}

	public void printInOrder(){
		if(root == null)return;
		printInOrder();
		System.out.println(" " + root.data);
		printInOrder();
	}	
	
	public void printPostOrder(){
		if(root == null)return;
		printPostOrder();
		printPostOrder();
		System.out.println(" " + root.data);
	}
	
	
	public void printPreOrder2(){
		if(root == null)return;
		Node iter = root;
		Stack<Node> stack  = new Stack<>();
			stack.push(iter);
			while(!stack.isEmpty()){
				Node aux = stack.pop();
				System.out.print( aux.data + " ");
				if(aux.right != null) stack.push(aux.right);
				if(aux.left != null) stack.push(aux.left);
			}
		}
	
	public void printInOrder2(){
		if(root == null)return;
		Stack<Node> stack = new Stack<>();
		Node iter = root;
		
		stack.push(iter);
		
		while(!stack.isEmpty() || iter != null){
			if(iter != null){ 
				stack.push(iter);
				iter = iter.left;
			}
			else{
				Node aux = stack.pop();
				System.out.print(aux.data + " ");
				if(aux.right != null)iter = aux.right;
			}
			
		}
	}
	
	public void printPostOrder2(){
		if(root == null)return;
		Stack<Node> stack = new Stack<>();
		
		Node iter = root;
		Node previous = null;
		stack.push(root);
		while(!stack.isEmpty() || iter != null){
			if(iter != null){
				stack.push(iter);
				iter = iter.left;
			}else{
				Node peek = stack.peek();
				if(peek.right != null && peek.right != previous)
					iter = peek.right;
				else{
					Node aux = stack.pop();previous = aux;
					System.out.print(aux.data + " ");
				}
			}
		}
	}
	
	public void printLevelOrder(){
		if(root == null)return;
		Queue<Node> queue = new LinkedList<>();
		
		Node iter = root;
		queue.add(iter);
		while(!queue.isEmpty()){
			Node aux = queue.remove();
			
			
			System.out.print(" " + aux.data);
			if(aux.left != null)
				queue.add(aux.left);
			if(aux.right != null)
				queue.add(aux.right);
		}
	}
	public Node mostLeftNode(Node removeNode){
		
		Node succesor = null;
		Node parent = null;
		Node iter = removeNode.right;
		
		while(iter != null){
			
			parent = iter;
			iter = iter.left;
			
			if(iter != null)
				succesor = iter;
		}
		
		if(succesor != removeNode.right){
			parent.left = succesor.right;
			succesor.right = removeNode.right;
		}
		
		return succesor;

	}
	
	public int size(){ return size; }

	private class Node{
		Integer data;
		Node right, left;
		
		public Node(Integer data){
			this.data = data;
			right = null; left = null;
		}
	}	
   
}

