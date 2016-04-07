import java.util.ArrayList;
import java.util.Arrays;


public class kruskalList {
	private int vertices;
	private Edge[]edges;
	private int counter=0;
	private ArrayList<Edge>mst;
	ArrayList<Edge>[] adjacencyList;
	int numOfEdges;
	public kruskalList(int vertices,ArrayList<Edge>[] adjacencyList,int numOfEdges){
		this.vertices=vertices;
		this.edges=edges;
		this.adjacencyList=adjacencyList;
		this.numOfEdges=numOfEdges;
		this.edges=new Edge[numOfEdges];
	}
	 
	public double MST(){
		double cost =0;
		getEdges();
		Arrays.sort(edges);
		mst=new ArrayList<Edge>();
		DisjointSet verticesSet=new DisjointSet(vertices);
		int edg=0;
		for (int i = 0; i < vertices-1; i++) {
			while(edg<edges.length&&verticesSet.checkUnion(edges[edg].getFrom(), edges[edg].getTo())){
			edg++;	
			}
			if(edg<edges.length){
			verticesSet.union(edges[edg].getFrom(), edges[edg].getTo());
			mst.add(edges[edg]);
			cost=cost+edges[edg].getCost();
			counter++;
			}
		}
		return cost;
	}

	public int getCounter() {
		return counter;
	}

	public ArrayList<Edge> getMst() {
		return mst;
	}
	private void getEdges(){
		int size2=0;
		for (int i = 0; i < adjacencyList.length; i++) {
			for (int j = 0; j < adjacencyList[i].size(); j++) {
				  if(adjacencyList[i].get(j).getTo()>=i){
					  edges[size2]=adjacencyList[i].get(j);
					  size2++;
				  }
			}
			
		}
			
	}
}
