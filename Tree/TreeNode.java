/**
	Construction of a undirected  tree
	Operations: add, print, delete and delete all leaf nodes
   @author Brahian VT
*/
import java.util.List;
import java.util.ArrayList;
public class TreeNode<T> {
	
	private T data = null;
	private TreeNode<T> parent = null;
	private List<TreeNode<T>> children = new ArrayList<>();
	
	public TreeNode(T data){ this.data = data;}
	
	// Insert a child
	public TreeNode<T> addChild(TreeNode<T>  child){
		child.setParent(this);
		getChildren().add(child);
		return child;
	}
	
	// Insert a List of children
	public void addChildren(List<TreeNode<T>> children){
		children.forEach( child -> child.setParent(this));
		getChildren().addAll(children);
	}
	
	// Delete a Node	
	public void removeNode(){
		if(parent != null){
			int index = getParent().getChildren().indexOf(this);
			
			
			children.forEach( child -> child.setParent(getParent()));
			getParent().getChildren().remove(index);
			getParent().getChildren().addAll(index, children);
			this.setParent(null);			
		} else removeRootNode();
		
		getChildren().clear();
	}
	
	private TreeNode<T> removeRootNode(){
		if(parent != null) return null;
		
		TreeNode newNode = null;
		if(!children.isEmpty()){
			newNode = getChildren().get(0);
			getChildren().remove(0);
			
			newNode.children.addAll(getChildren());
		}
		
		getChildren().clear();
		return newNode;
	}
	
	// print all nodes
	public void print(TreeNode<T> node, String space){
		if(node == null) return;
		
		System.out.println(space + node.getData());
		space+=" ";
		
		for (int i = 0; i < node.getChildren().size(); i++)
			print(node.getChildren().get(i), space);
		
		
	}
	
	// remove all the leaf nodes
	public void removeAllLeafNodes(){
		List<TreeNode<T>> leafNodes = new ArrayList<>();
		
		fillListLeafNode(getChildren(), leafNodes);
		
		leafNodes.forEach(TreeNode::removeNode);
	}
	
	private void fillListLeafNode(List<TreeNode<T>> children, List<TreeNode<T>> leafNodes){
		children.forEach( child ->{
			if(child.getChildren().isEmpty()){ leafNodes.add(child); return;}
			
			fillListLeafNode(child.getChildren(), leafNodes);
		});
	}
	
	// get the root 
	public TreeNode<T> getRoot(TreeNode<T> node){
		if(node.getParent() == null)return this;
		return getRoot(node.getParent());
	}
	
	public void setData(T data){ this.data = data; }
	public void setParent(TreeNode<T> parent){ this.parent = parent;}
	public void setChildren(List<TreeNode<T>> children){ this.children = children;}
	
	public T getData(){ return data; }
	public TreeNode<T> getParent(){ return parent; }
	public List<TreeNode<T>> getChildren(){ return children; }
	
	
	public static void main(String[] args){
		
		TreeNode<Integer> root = new TreeNode(1);
		TreeNode<Integer> child1 = root.addChild(new TreeNode(2));
		TreeNode<Integer> child2 = root.addChild(new TreeNode(3));
		TreeNode<Integer> child3 = root.addChild(new TreeNode(4));
		TreeNode<Integer> child4 = child2.addChild(new TreeNode(5));
		
		
		root.print(root, " ");
		
		
		System.out.println("Removing all leaf nodes :");
		root.removeAllLeafNodes();
		root.print(root, "");
		
	}
	
}