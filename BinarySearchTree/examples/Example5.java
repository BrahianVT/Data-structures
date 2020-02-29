/**
	Check if  all the leaf nodes are in the same level
  @Author: Brahian Velazquez Tellez
*/
public class Example5{
	
	Node root = null;
	
	/* recursive Functions that checks if all leaf nodes are in the same level*/
	int levelLeafNode = 0;
	public boolean checkLeafNodesSameLevel(Node root, int level){
		if(root == null) return true;
		
		if(root.left == null && root.right == null){
			if( levelLeafNode != 0 && levelLeafNode != level)
				return false;
			levelLeafNode = level;
		}
		
		return checkLeafNodesSameLevel(root.left, level+1) && checkLeafNodesSameLevel(root.right, level+1);
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
		
		Example5 tree = new Example5();
		
		 tree.add(5);tree.add(6);
		 tree.add(7);tree.add(4);tree.add(1);
		 
		 System.out.println(" All the leaf nodes in the same level: " + tree.checkLeafNodesSameLevel(tree.getRootNode(), 1));
		 Example5 tree2 = new Example5();
		
		 tree2.add(12);tree2.add(13);
		 tree2.add(5);tree2.add(3);
		 
		 System.out.println(" All the leaf nodes in the same level: " + tree2.checkLeafNodesSameLevel(tree2.getRootNode(), 1));
	}
}