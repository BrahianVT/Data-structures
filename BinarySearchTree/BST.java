import java.util.*;
/**
	@Autor: Brahian Velazquez Tellez
	Implement Binary Search Tree for Integer values
*/

public class BST{
	
	private Node root;
	public BST(){ this.root = null; }
	public boolean find(Integer data){
		Node current = root;
		while(current != null){
			
			if(data == current.data) return true;
			if(current.data < data)
				current = current.right;
			else
				current = current.left;
			
		}
		return false;
	}
	
	public boolean add(Integer elem){
		
		Node newNode = new Node(elem);
		if(root == null){ root = newNode; return true; }
		Node current = root;
		Node parent = null;
		while(current != null){
			parent = current;
			
			if(current.data < elem){
				current = current.right;
				if(current == null){
					parent.right = newNode; return true;
				}
			}else{
				current = current.left;
				if(current == null){
					parent.left = newNode; return true;
				}
			}
		}
		return false;
	}
	
	public boolean remove(Integer elem){
		if(elem == null || root == null) return false;
		
		Node current = root;
		Node parent = null;
		boolean isLeftChild = false;
		while(current != null){
			parent = current;
				
			
			if(current.data < elem){
				current = current.right;
				isLeftChild = false;
			}else if(current.data > elem){
				current = current.left;
				isLeftChild = true;
			}
			if(current == null) return false;
			if(current.data == elem) break;	
		}
		
		
		if(current.left == null && current.right == null){
			if(current == root) root = null;
			else if(isLeftChild) parent.left = null;
			else parent.right = null;
			
		}else if(current.right == null){
			if(current == root) root = root.left;
			else if(isLeftChild)
				parent.left = current.left;
			else
				parent.right = current.left;
		}else if(current.left == null){
			if(current == root) root = root.right;
			else if(isLeftChild)
				parent.left = current.right;
			else
				parent.right = current.right;
		}else{
			
			Node successor = findSuccessor(current);
			
			if(isLeftChild)
				parent.left = successor;
			else
				parent.right = successor;
			
			successor.left = current.left;
		}
		return true;
	}
	
	public Node getRootNode(){ return root;}
	public void print(Node root){
		if(root == null)return;
		print(root.left);
		System.out.print(" " + root.data);
		print(root.right);
	}
	private Node findSuccessor(Node removeNode){
		Node succesor = null;
		Node parentSuccessor = null;
		Node current = removeNode.right;
		while(current != null){
			
			succesor = current;
			parentSuccessor = current;
			current = current.left;
		}
		
		if(succesor != removeNode.right){
			parentSuccessor.left = succesor.right;
			succesor.right = parentSuccessor;
		}
		return succesor;
	}
	 public static void main(String args[]){
		 
		 BST tree = new BST();
		 tree.add(1);
		 tree.add(8);
		 tree.add(2);
		 tree.add(3);
		 tree.add(5);
		 tree.add(4);
		 tree.add(9);
		 tree.add(10);
		 
		 System.out.println(" mostrar " );
		 tree.print(tree.getRootNode());
		 System.out.println(" eliminar 1 : " + tree.remove(1));
		 tree.print(tree.getRootNode());
		 System.out.println(" eliminar 5 : " + tree.remove(5));
		 tree.print(tree.getRootNode());
		 
		 System.out.println(" se encontro valor 9 : " + tree.find(9));
  }
  
  private class Node{
	  Integer data;
	  Node right , left;
	  
	  public Node(Integer data){
		  this.data = data;
		  right = null; left = null;
	  }
  }
}