/**
	Check if the tree is balanced or not
	@Author: BrahianVT
*/
public class Example7{
	Node root = null;
	
	public int isBalancedTree(Node root){
		if(root == null)return 0;
		
		int leftHight = isBalancedTree(root.left); 
		if(leftHight == -1) return -1;
		int rightHight = isBalancedTree(root.right);
		
		if(rightHight == -1) return -1;
		if(Math.abs(leftHight - rightHight) > 1) return -1;
	return Math.max(leftHight, rightHight) + 1;
	}
	public void add(Integer elem){
		if(elem == null)return;
		root = add(root,elem);
	}

	public Node getRootNode(){
		return root;
	}
	
	public Node add(Node node, Integer elem){
		if(node == null)return new Node(elem);
		else if(node.data < elem)
			node.right = add(node.right, elem);
		else 
			node.left = add(node.left, elem);
		
		return node;
	}
	
	public void printInOrder(Node root){
		if(root == null)return;
		printInOrder(root.left);
		System.out.print(root.data);
		printInOrder(root.right);
	}
	public static void main(String[] args){
		 Example7 tree = new Example7();
		 tree.add(5);
		 tree.add(4);
		 tree.add(9);
		 tree.add(10);		
		 tree.add(1);
		 tree.add(8);
		 tree.add(2);
		 tree.add(3);
		
		 
		 System.out.println(" Print level order:");
		 tree.printInOrder(tree.getRootNode());
		 System.out.println("");
		 int res = tree.isBalancedTree(tree.getRootNode());
		 
		 System.out.println("Is a balanced tree :" + (res > 0));
	}
}