package brahianVT.graphs;

/**
	An omplementation of an iterative DFS with an adjacency list 
	TC: O(V + E)
	
	@author Brahian VT
*/

import java.util.*;


public class BreadthFirstSearchAdjacencyListIterativeFastQueue{
	
	private Map<Integer, List<Edge>> graph;
	
	BreadthFirstSearchAdjacencyListIterativeFastQueue(){
		graph = new HashMap<>();
	}
	/*
	Custom implementation of a integer only queue which is extremely quick 
	and faster.
	You need to know an upper bound on the number of the numbers of elements
	that will be inside the queue at any given time
	*/
	class IntQueue{
		private int[] ar;
		private int front, end, sz;
		
		public IntQueue(int  sz){
			
			front = end = 0;
			this.sz = sz + 1;
			
			ar = new int[this.sz];
		}
		
		public boolean isEmpty(){ return front == end; }
		
		public int peek(){ return ar[front]; }
		
		// add a element to the queue
		
		public void enqueue(int value){
			
			ar[end] = value;
			if(++end == sz) end = 0;
			if(end == front) throw new RuntimeException("Queue too small!");
		}
		
		public int dequeue(){
			int res = ar[front];
			if(++front == sz) front = 0;
			return res;
		}
	}
		
		static class Edge {
			int from, to, cost;
			
			public Edge(int from, int to, int cost){
				this.from = from;
				this.to = to;
				this.cost = cost;
			}
		}
		
		
		public void bfs(int start, int n){
			boolean[] visited = new boolean[n];
			IntQueue queue = new IntQueue( n + 1);
			
			// for each breadth first search layer gets separated by a DEPH_TOKEN
			int DEPH_TOKEN = -1;
			
			queue.enqueue(start);
			queue.enqueue(DEPH_TOKEN);
			visited[start] = true;
			
			while(true){
				Integer node = queue.dequeue();
				
				// if we find a  depth token this means that we have finished the current
				// layer and are about to start the new layer 
				
				if(node == DEPH_TOKEN){
					if(queue.isEmpty()) break;
					
					// add another DEPH_TOKEN
					queue.enqueue(DEPH_TOKEN);
					
				} else {
					
					System.out.print(" " + node);
					
					List<Edge> edges = graph.get(node);
					if( edges != null){
						for(Edge edge: edges){
							
							if(!visited[edge.to]){
								visited[edge.to] = true;
								queue.enqueue(edge.to);
							}
						}
					}
				}
			}
		}
		
		
		public void addDirectedEdge(int from , int to, int cost){
			List<Edge> list = graph.get(from);
			
			if(list == null){
				list = new ArrayList<Edge>();
				graph.put(from, list);
			}
			
			list.add(new Edge(from, to, cost));
		}
		
		
	}
