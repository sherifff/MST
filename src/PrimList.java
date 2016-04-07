import java.util.ArrayList;
import java.util.PriorityQueue;


public class PrimList {
    
   private ArrayList<Edge>[]adjacencyList ;
   private int vertices;
   private int numOfEdges;
   private boolean[]visited;
   private ArrayList<Edge>mst;
	public PrimList(int vertices, ArrayList<Edge>[]adjacencyList,int numOfEdges){
		this.adjacencyList=adjacencyList;
		this.vertices=vertices;
		this.visited=new boolean[vertices+1];
		this.numOfEdges=numOfEdges;
	}
	
	public  double MST(){
		PriorityQueue<Edge>priorityQueue=new PriorityQueue<>(numOfEdges);
		mst=new ArrayList<Edge>();
		visited[1]=true;
		double cost=0;
		for (int i = 0; i < adjacencyList[1].size(); i++) {
			 if(adjacencyList[1].get(i).getTo()!=1){
				priorityQueue.add(new Edge(1, adjacencyList[1].get(i).getTo(),adjacencyList[1].get(i).getCost()));	
			 }
		}
		while(priorityQueue.size()>0){
			Edge temp=priorityQueue.poll();
			while(priorityQueue.size()>0&& visited[temp.getTo()]){
			    temp=priorityQueue.poll();
			}
			if(!visited[temp.getTo()]){
			cost=cost+temp.getCost();
			visited[temp.getTo()]=true;
			mst.add(temp);
			for (int j = 0; j <adjacencyList[temp.getTo()].size(); j++) {
				Edge loop=adjacencyList[temp.getTo()].get(j);
				if(loop.getTo()!=temp.getTo() &&!visited[loop.getTo()]){
					priorityQueue.add(new Edge(temp.getTo(),loop.getTo(), loop.getCost() ));	
				}
			}
		  }
		}
		return cost;
	}

	public ArrayList<Edge> getMst() {
		return mst;
	}

	public void setMst(ArrayList<Edge> mst) {
		this.mst = mst;
	}

}
