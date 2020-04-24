/**
	Convert binary tree to Sum Binary Tree
	Explanation: Given a node in the tree sum up all the
	nodes that has a value greather that the current node
	and replace it with the sum of all these nodes.
	@Author: BrahianVT
*/
public class Example8{
	
	Node root = null;
	
	int currentSum = 0;
	
	void fillTreeSum(Node root){
		if(root == null)return;
		
		fillTreeSum(root.right);
		
		int aux = root.data;
		root.data = currentSum;
		currentSum+= aux;
		
		fillTreeSum(root.left);
		
	}
	void printInOrder(Node root){
		if( root == null) return;
		
		printInOrder(root.left);
		System.out.print(" " + root.data);
		printInOrder(root.right);
	}
	public static void main(String [] args){
		Node root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(15);
		root.left.left = new Node(2);
		root.left.right = new Node(7);
		root.right.left = new Node(12);
		root.right.right = new Node(20);
		
		Example8 tree = new Example8();
		System.out.println("InOrder before : ");
		tree.printInOrder(root);
		
		System.out.println("InOrder With tree sum");
		tree.fillTreeSum(root);
		tree.printInOrder(root);
	}
}