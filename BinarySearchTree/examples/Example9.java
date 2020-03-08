/*
	Diameter of a binary tree
	What is Diameter of a tree: The longest path between any two nodes in a tree.
	@Author: BrahianVT
*/
public class Example9{
	int diameter = 0;
	int findDiameter(Node node){
		if(node == null)return 0;
		
		int leftHeight = findDiameter(node.left);
		int rightHeigt = findDiameter(node.right);
		int auxDiameter = leftHeight + rightHeigt + 1;
		
		if(auxDiameter > diameter)diameter = auxDiameter;
		return Math.max(leftHeight, rightHeigt) + 1;
	}
	public static void main(String[] args){
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.left = new Node(6);
		root.left.right.left.right = new Node(7);
		root.left.left.left = new Node(8);

		Example9 tree = new Example9();
		
		tree.findDiameter(root);
		System.out.println("the diameter is :" + tree.diameter);
		

	}
}