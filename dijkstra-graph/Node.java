import java.util.ArrayList;
import java.util.List;


public class Node implements INode,Comparable<Node>{
	public final String name;
	public List<Edge> adjacencies = new ArrayList<Edge>();
	public double minDistance = Double.POSITIVE_INFINITY;
	public Node previous;
	public Node(String argName) { name = argName; }
	public String toString() { return name; }
	public int compareTo(Node other)
	{
		return Double.compare(minDistance, other.minDistance);
	}
	
	public void addEdge(Node n, int w){
		adjacencies.add(new Edge(this,n,w));
	}
	
	public String getName(){
		return name;
	}
	
	public List<IEdge> getEdges(){
		List <IEdge> edges = new ArrayList<IEdge>();
		for (Edge e:adjacencies){
			edges.add(e);
		}
		return edges;
	}
}
