import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class projects {
	enum State 
	{ 
	    visited, visiting, notvisited; 
	} 
	public class Node{
		char ch;
		State state ;
		int start;
		int end;
		Node(char ch){
			this.ch=ch;
			this.state=State.notvisited;
		}
		public int hashCode() {
			return ch;
			}
		public boolean equals(Object o) {
		    if (o == this) {
		      return true;
		    }
		    if (!(o instanceof Node)) {
		      return false;
		    }
		    Node node = (Node)o;
		    return node.ch == ch;
		  }
	}
	String sort="";
	public Map<Character, List<Node>> Edges;
	public Map<Character, Node> Vertices;
	projects(){
		this.Edges = new HashMap<Character,List<Node>>();
		this.Vertices=new HashMap<Character, Node>();
		
	}
	public void addVertex(char ch) {
		Node node = new Node(ch);
		if(Edges.containsKey(ch))
			System.out.print("Vertex already there");
		else {
			Vertices.put(ch,node);
			Edges.put(ch, new LinkedList<Node>());
		}
	}
	
	public void addEdge(char[] edge) {
		//Node start = new Node(edge[0]);
		Node end = new Node(edge[1]);
		if(Vertices.containsKey(edge[0])&&Edges.containsKey(edge[0])) {
			//List<Node> temp=new LinkedList<Node>();
			List<Node> temp=Edges.get(edge[0]);
			temp.add(end);
			Edges.put(edge[0],temp);
		}
			
	}
	public List<Character> getVertex() {
		List<Character> verteces= new LinkedList<Character>();
		Set<Character> keys = Vertices.keySet();

		   for (final char key : keys) {
			   verteces.add(key);
		   }
		return verteces;
	}
	public List<Node> getChild(char parent){
		if(Edges.containsKey(parent)) {
			return Edges.get(parent);
		}
		else
			return null;
	}
	public void dfs() {
		List<Character> vertices = getVertex() ;
		int time=0;
		for(char vertex: vertices) {
			if(Vertices.get(vertex).state==State.notvisited)
				time=dfs(vertex,time);
				
		}
		
	}
	public int dfs(char vertex,int time) {
		System.out.print("\nworking for vertex:::");
		System.out.print(vertex);
		time =time+1;
		Vertices.get(vertex).start = time;
		Vertices.get(vertex).state=State.visiting;
		List<Node> Children=getChild(vertex);
		if(Children!=null) {
			for(Node child:Children) {
				if(Vertices.get(child.ch).state==State.notvisited)
					time=dfs(child.ch,time);
			}
		}
		Vertices.get(vertex).state=State.visited;
		time=time+1;
		Vertices.get(vertex).end=time;
//		System.out.print(vertex.ch);
		System.out.print("\nvertex done:::");
		System.out.print(vertex);
		sort=vertex+sort;
		return time;
	}
	
	public static void main(String[] args) {
		char[] arr= {'a','b','c','d','e','f'};
		char[][] edge = {{'a','d'},{'f','b'},{'b','d'},{'f','a'},{'d','c'}};
		projects pr=new projects();
		for(char ch:arr) {
			pr.addVertex(ch);
		}
		for(char[] ch:edge) {
			pr.addEdge(ch);
		}
		pr.dfs();
		System.out.print("\n Topological Sort is\n");
		System.out.print(pr.sort);
		
		
		
	}
}
