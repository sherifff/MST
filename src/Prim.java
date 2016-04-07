import java.util.ArrayList;
import java.util.PriorityQueue;


public class Prim {
    
	private double[][]adjacencyMatrix;
   private int vertices;
   private int numOfEdges;
   private boolean[]visited;
   private ArrayList<Edge>mst;
	public Prim(int vertices, double[][]adjacencyMatrix,int  numOfEdges){
		this.adjacencyMatrix=adjacencyMatrix;
		this.vertices=vertices;
		this.numOfEdges=numOfEdges;
		this.visited=new boolean[vertices+1];
		
	}
	
	public  double MST(){
		PriorityQueue<Edge>priorityQueue=new PriorityQueue<>(numOfEdges);
		mst=new ArrayList<Edge>();
		visited[1]=true;
		double cost=0;
		for (int i = 0; i < adjacencyMatrix.length; i++) {
			if(i!=1 &&  adjacencyMatrix[1][i]!=-1){
				priorityQueue.add(new Edge(1, i, adjacencyMatrix[1][i]));	
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
			for (int j = 0; j <adjacencyMatrix.length; j++) {
				if(j!=temp.getTo() &&  adjacencyMatrix[temp.getTo()][j]!=-1 &&!visited[j]){
					priorityQueue.add(new Edge(temp.getTo(), j, adjacencyMatrix[temp.getTo()][j]));	
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
