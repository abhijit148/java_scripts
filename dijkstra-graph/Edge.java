public class Edge implements IEdge{
	public final Node source;
	public final Node target;
    public final double weight;
  
    public Edge(Node argSource, Node argTarget, double argWeight)
    { source=argSource; target = argTarget; weight = argWeight; }
    
    public int getWeight(){
    	int i=(int) weight;
    	return i;
    }
    
    public Node getOriginNode(){
    	return source;
    }
    
    public Node getTargetNode(){
    	return target;
    }
}
