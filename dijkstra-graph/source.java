import java.util.List;


public class source {
	public static void main(String Args[]){
		  	/*Node A = new Node("A");
		    Node B = new Node("B");
		    Node D = new Node("D");
		    Node F = new Node("F");
		    Node K = new Node("K");
		    Node J = new Node("J");
		    Node M = new Node("M");
		    Node O = new Node("O");
		    Node P = new Node("P");
		    Node R = new Node("R");
		    Node Z = new Node("Z");

		    // set the edges and weight
		    A.adjacencies = new Edge[]{ new Edge(M, 8) };
		    B.adjacencies = new Edge[]{ new Edge(D, 11) };
		    D.adjacencies = new Edge[]{ new Edge(B, 11) };
		    F.adjacencies = new Edge[]{ new Edge(K, 23) };
		    K.adjacencies = new Edge[]{ new Edge(O, 40) };
		    J.adjacencies = new Edge[]{ new Edge(K, 25) };
		    M.adjacencies = new Edge[]{ new Edge(R, 8) };
		    O.adjacencies = new Edge[]{ new Edge(K, 40) };
		    P.adjacencies = new Edge[]{ new Edge(Z, 18) };
		    R.adjacencies = new Edge[]{ new Edge(P, 15) };
		    Z.adjacencies = new Edge[]{ new Edge(P, 18) };
		    
		    System.out.println(getShortestPath(A,Z));*/
		
		Node A = new Node("A");
	    Node B = new Node("B");
	    Node C = new Node("C");
	    Node D = new Node("D");
	    Node E = new Node("E");
	 
	    A.addEdge(B,4);
	    A.addEdge(C,1);
	    B.addEdge(E,4);
	    C.addEdge(D,4);
	    C.addEdge(B,2);
	    D.addEdge(E,4);
	    
	    System.out.println(getShortestPath(A,E));
	}
	public static List<Node> getShortestPath(Node initNode, Node endNode){
		 	Path shortest=new Path();
		    shortest.calcPath(initNode); // run Dijkstra
		    System.out.println("Distance to " + endNode + ": " + endNode.minDistance);
		    List<Node> path = shortest.getShortestPathTo(endNode);
		    return path;
		}
}
