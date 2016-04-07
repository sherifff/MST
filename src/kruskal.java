import java.util.ArrayList;
import java.util.Arrays;


public class kruskal {
	private int vertices;
	private Edge[]edges;
	private int counter=0;
	private ArrayList<Edge>mst;
	public kruskal(int vertices, Edge[]edges){
		this.vertices=vertices;
		this.edges=edges;
	}
	 
	public double MST(){
		double cost =0;
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
}
