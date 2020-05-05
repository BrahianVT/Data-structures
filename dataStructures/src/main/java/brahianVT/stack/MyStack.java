package brahianVT.stack;

import java.util.LinkedList;

public class MyStack<T>  implements Iterable<T> {
	
	LinkedList<T> list = new LinkedList<T>();
	
	public MyStack(){}
	
	public MyStack(T elem){
		push(elem);
	}
	
	public int size(){
		return list.size();
	}
	
	public boolean isEmpty(){
		return size() == 0;
	}
	
	public void push(T elem){
		list.addLast(elem);
	}
	
	public T pop(){
		if(list.size() == 0) throw new java.util.EmptyStackException();
		return list.removeLast();
	}
	
	public T  peek(){
		if(list.size() == 0) throw new java.util.EmptyStackException();
		return list.peekLast();
	}
	
	@Override
	public java.util.Iterator<T> iterator(){
		return list.iterator();
	}
}