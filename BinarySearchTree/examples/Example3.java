/*
	Another example using trees, or binary trees:
	Get the size of a given binary tree
	Get the highest value in the tree
	Print the left view of the tree
	Print Level-Order without stack 
	@Author: Brahian Velazquez Tellez
*/

public class Example3{
	
	Node root = null;
	
	// Recursive fuction that get the size of the tree
	public Integer getSize(Node root){
		if(root == null)return 0;
		return getSize(root.left) + getSize(root.right) + 1;
	}
	
	// get the highest value in the tree
	
	public Integer getMaxValue(Node root){
		if(root == null)return 0;
		return Math.max(root.data, Math.max(getMaxValue(root.left),getMaxValue(root.right)));
	}
	
	//Print the left view of the tree
	int maxLevel = 0;
	public void printLeftView(Node root, int level){
		if(root == null)return;
		
		if( level > maxLevel){
			System.out.print(" " + root.data);
			maxLevel = level;
		}
		printLeftView(root.left, ++level);
		printLeftView(root.right, ++level);
	}
	
	// Print Level-Order without stack part 1
	public void printLevelOrder(Node root){
		int height = getHeight(root);
		for(int i = 1; i <= height; i++){
			printLevelOrder(root, i);
			System.out.println("");
		}
	}
	// Print Level-Order without stack part 2
	private void printLevelOrder(Node root, int level){
		if(root == null || level < 1)return;
		if(level == 1)System.out.print(" " + root.data);
		
		printLevelOrder(root.left, level-1);
		printLevelOrder(root.right,level-1);
	}
	
	// Calculate the height of the tree
	public Integer getHeight(Node root){
		
		if(root == null)return 0;
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}
	public  boolean add(Integer data){
		if(data == null)return false;
		else
			root = add(data, root);
		return true;
	}
	
	public Node getRootNode(){
		return root;
	}
	
	public Node add(Integer data, Node root){
		if(root == null)return new Node(data);
		
		if(root.data < data)
			root.right = add(data, root.right);
		else if(root.data > data)
			root.left = add(data, root.left);
		
		return root;
		
	}
	
	

	public static void main(String[] args){
		Example3 tree = new Example3();
		
		 tree.add(1);
		 tree.add(8);
		 tree.add(2);
		 tree.add(3);
		 tree.add(5);
		 tree.add(4);
		 tree.add(9);
		 tree.add(10);		
		 
		 System.out.println(" Print level order:");
		 tree.printLevelOrder(tree.getRootNode());
		 System.out.println("");
		 
		 System.out.println("Size= " + tree.getSize(tree.getRootNode())); 
		 System.out.println("Height: " + tree.getHeight(tree.getRootNode()));
		 System.out.println(" Max Value = " + tree.getMaxValue(tree.getRootNode()));
		 System.out.println("");
		 
		 System.out.println(" Left-View ");
		 tree.printLeftView(tree.getRootNode(), 1);
		 System.out.println("");
		 
	}
}