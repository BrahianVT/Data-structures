/**
	Given a Binary Tree Determine if is a BST or Not	
	I consider tha the binary tree is right when 
	the following condition is satisfied:	
	left<= root < right
   @Author: Brahian Velazquez Tellez
**/
public class Example1{
	Node root = null;
	Node lastNode = null;
	public boolean add(Integer elem){
		if(elem == null) return false;
		else
			root = add(root,elem);
		return true;
	}
		
	private Node add(Node root, Integer elem){
		if(root == null){
			root = new Node(elem);
			lastNode = root;
			return root;
		}
		if(root.data >= elem)root.left = add(root.left, elem); 
		if(root.data < elem)root.right = add(root.right, elem);
		
		return root;
	}
	
	public Node getRoot(){ return root; }
	
	public void inOrder(Node root){
		if(root == null)return;
		inOrder(root.left);
		System.out.print(" " + root.data);
		inOrder(root.right);
	}
	
	public boolean isValidBst(Node root){
		if(root == null) return true;
		Node left = root.left; Node right = root.right;
		if(left != null)
			if(left.data > root.data)return false;
		
		if(right!= null)
			if(right.data <= root.data)return false;
		
	return isValidBst(root.left) && isValidBst(root.right);
	}
	

	public static void main(String[] args){
		
		Example1 tree = new Example1();
		
		 tree.add(1);
		 tree.add(8);
		 tree.add(2);
		 tree.add(3);
		 tree.add(5);
		 tree.add(4);
		 tree.add(9);
		 tree.add(10);		
		 
		 tree.lastNode.right = new Node(11);
		 System.out.print(" In Order: ");
		 tree.inOrder(tree.getRoot());
		 System.out.print("\n Is valid Binary Search Tree : "  + tree.isValidBst(tree.getRoot()));
	}
}

 class Node{
	Integer data;
	Node right, left;
	public Node(Integer data){
		this.data = data;
	}
}