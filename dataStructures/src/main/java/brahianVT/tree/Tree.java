package brahianVT.tree;


/**

  Implementation of a tree
 @author Brahian VT	
*/

import java.util.List;
import java.util.ArrayList;
public class Tree<T>{
	private T data;
	private Tree<T> parent;
	private List<Tree<T>> children = new ArrayList<>();
	public Tree(){}
	public Tree(T data){
		this.data = data;
	}
	
	public Tree addChild(Tree child){
		children.add(child);
		child.setParent(this);
		
		return child;
	}
	
	public void addChildren(List<Tree> children){
		children.forEach(child -> child.setParent(this));
		children.addAll(children);
	}
	
	public void removeChild(){
		if(getParent() != null){
			int index = getParent().getChildren().indexOf(this);
			children.forEach(child -> child.setParent(getParent()));
			getParent().getChildren().remove(index);
			getParent().getChildren().addAll(index, children);
			this.setParent(null);
		}else removeRootNode();
		children.clear();
	}
	
	private Tree<T> removeRootNode(){
	
		Tree<T> newRoot = null;
		
		if(!children.isEmpty()){
			newRoot = children.get(0);
			newRoot.setParent(null);
			children.remove(0);
			newRoot.getChildren().addAll(children);
			for(int i = 0; i < children.size(); i++){
				children.get(i).setParent(newRoot);
			}
		}
		
		return newRoot;
	}
	
	public void printTree(Tree<T> node , String space){
		if(node == null) return;
		System.out.println(space + node.getData());
		
		for(int i = 0; i < node.getChildren().size(); i++){
			printTree(node.getChildren().get(i), space + " ");
		}
	}
	
	
	public void removeAllLeafNode(){
		List<Tree<T>> leafNodes = new ArrayList<>();
		findLeafNodes(leafNodes, children);
		
		leafNodes.forEach(Tree::removeChild);
	}
	
	private void findLeafNodes(List<Tree<T>> leafNodes , List<Tree<T>> children){
		children.forEach( child ->{
			if(child.getChildren().size() == 0)leafNodes.add(child);
			
			if(child.getChildren().size() != 0)
				findLeafNodes(leafNodes, child.getChildren());
		});
	}
	
	public Tree<T> getRoot(Tree<T> node){
		if(node.getParent() == null) return node;
		else return getRoot(node.getParent());
	}
	
	public void setData(T data){ this.data = data; }
	public T getData(){ return data; }
	public void setParent(Tree<T> parent){ this.parent = parent;}
	public void setChildren(List<Tree<T>> children){ this.children = children; }
	public List<Tree<T>> getChildren(){ return children; }
	public Tree<T> getParent(){ return parent; }
}