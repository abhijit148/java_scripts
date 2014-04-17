import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Path implements IPath{
	private List<Node> path=new ArrayList<Node>();
	
	public List<Node> getPath(){
		return path;
	}
	
	public int getTotalWeight(){
		if(path.isEmpty()){
			return 0;
		}
		else
			return (int) path.get(path.size()-1).minDistance;
	}
	
	
    public List<Node> calcPath(Node source)
    {
        source.minDistance = 0.;
        PriorityQueue<Node> NodeQueue = new PriorityQueue<Node>();
        
        NodeQueue.add(source);

    while (!NodeQueue.isEmpty()) {
        Node u = NodeQueue.poll();
      
            // Visit each edge exiting u
            for (Edge e : u.adjacencies)
            {
                Node v = e.target;
                double weight = e.weight;
                double distanceThroughU = u.minDistance + weight;
        if (distanceThroughU < v.minDistance) {
            NodeQueue.remove(v);
            
            v.minDistance = distanceThroughU ;
            v.previous = u;
 
            NodeQueue.add(v);
        }
            }
        }
    path.addAll(NodeQueue);
    return path;
    }
  
    public List<Node> getShortestPathTo(Node target)
    {
        List<Node> path = new ArrayList<Node>();
        for (Node Node = target; Node != null; Node = Node.previous)
            path.add(Node);

        Collections.reverse(path);
        return path;
    }
    
}