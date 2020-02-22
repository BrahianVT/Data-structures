/**
	Given an sorted array created a binary search tree
	with the minimum height
	@Author:Brahian Velazquez Tellez
**/
public class Example2{
	Node root = null;
	
	public void add(Integer elem){
		if(elem == null)return;
		root = add(root,elem);
	}

	public Node add(Node node, Integer elem){
		if(node == null)return new Node(elem);
		else if(node.data < elem)
			node.right = add(node.right, elem);
		else 
			node.left = add(node.left, elem);
		
		return node;
	}
	
	public void insert(int[] sortedArray, Node node , int index,int indexDiff){
		
		if(index - indexDiff >=0)add(sortedArray[index - indexDiff]);
		if(index + indexDiff < sortedArray.length)add(sortedArray[index + indexDiff]);
		
		if(index - indexDiff + 1 >=0)add(sortedArray[index - indexDiff + 1]);
		if(index + indexDiff - 1 < sortedArray.length)add(sortedArray[index + indexDiff - 1]);
		
		if(index - indexDiff <= 0 && index + indexDiff >= sortedArray.length -1)return;
		insert(sortedArray, node,index, indexDiff+2);
	}
	public void inOrder(Node root){
		if(root == null)return;
		inOrder(root.left);
		System.out.print(" " + root.data);
		inOrder(root.right);
		
	}
	public static void main(String[] args){
		int []sortedArray = {1,2,3,4,5,6,7,8,9,10,11,12};
		System.out.println("Creating binary Search Tree...");
		int halfIndex =  Math.round(sortedArray.length/2) - 1;
		System.out.println("The Binary Search Tree traver in In-Order");
		Example2 ex = new Example2();
		ex.root = new Node(sortedArray[halfIndex]);
		ex.insert(sortedArray, ex.root, halfIndex, 2);
		ex.inOrder(ex.root);
	}
}