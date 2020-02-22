/*
	Find depth of the deepest odd level leaf node
	Depth: Of a leaf node is the number of nodes on the path from 
		   root to leaf.
*/

public class Example4{
	Node root = null;
	
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
	
	int maxLevelOdd = 0;
	public void findDephtOddLevel(Node root, int level){
		
		if(root == null)return;
		
		if(level %2 == 1)
			if(root.left == null && root.right == null)
				if(level > maxLevelOdd)
					maxLevelOdd = level;
		
		findDephtOddLevel(root.left, level + 1);
		findDephtOddLevel(root.right, level + 1);
	}
	public static void main(String[] args){
		
		Example4 tree = new Example4();
		
		 tree.add(2);
		 tree.add(1);
		 tree.add(10);
		 tree.add(5);
		 tree.add(6);
		 tree.add(11);
		 tree.findDephtOddLevel(tree.getRootNode(), 1);
		 System.out.println("Find the depht of the dephtest odd level lead node :" + tree.maxLevelOdd);
	}
}