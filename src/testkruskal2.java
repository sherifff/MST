import java.util.ArrayList;
import java.util.Scanner;

public class testkruskal2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double[][] adjacencyMatrix;
		ArrayList<Edge>[] adjacencyList;
		// System.out.println("Number of vertices :");
		int vertices = sc.nextInt();
		// System.out.println("Number of edges :");
		int edges = sc.nextInt();
		// System.out.println("input the edges :");
		adjacencyList = new ArrayList[vertices + 1];
		for (int i = 0; i < adjacencyList.length; i++) {
			adjacencyList[i] = new ArrayList<Edge>();
		}
		adjacencyMatrix = new double[vertices + 1][vertices + 1];
		for (int i = 0; i < adjacencyMatrix.length; i++) {
			for (int j = 0; j < adjacencyMatrix.length; j++) {
				adjacencyMatrix[i][j] = -1;
			}
		}
		Edge[] edgeArray = new Edge[edges];
		for (int i = 0; i < edges; i++) {
			String[] input;
			String s = sc.next();
			input = s.split(",");
			int from = Integer.parseInt(input[0]);
			int to = Integer.parseInt(input[1]);
			double cost = Double.parseDouble(input[2]);
			// edgeArray[i]=new Edge(from, to, cost);
			Edge e1 = new Edge(from, to, cost);
			Edge e2 = new Edge(to, from, cost);
			adjacencyList[from].add(e1);
			adjacencyList[to].add(e2);
			adjacencyMatrix[from][to] = cost;
			adjacencyMatrix[to][from] = cost;
		}
		/*
		int size = 0;
		for (int i = 0; i < adjacencyMatrix.length; i++) {
			for (int j = i; j < adjacencyMatrix.length; j++) {
				if (adjacencyMatrix[i][j] != -1) {
					edgeArray[size] = new Edge(i, j, adjacencyMatrix[i][j]);
					size++;
				}
			}
		}
		*/
//		int size2=0;
//		for (int i = 0; i < adjacencyList.length; i++) {
//			for (int j = 0; j < adjacencyList[i].size(); j++) {
//				  if(adjacencyList[i].get(j).getTo()>i){
//					  edgeArray[size2]=adjacencyList[i].get(j);
//					  size2++;
//				  }
//			}
//			
//		}
		kruskalList k = new kruskalList(vertices, adjacencyList,edges);
		double finalist = k.MST();
		int counter = k.getCounter();
		if (counter == (vertices - 1)) {
			System.out.println("minimal cost spanning tree  :  " + finalist);
			ArrayList<Edge> minimal = k.getMst();
			for (int i = 0; i < minimal.size(); i++) {
				System.out.println(minimal.get(i).getFrom() + "-------"
						+ minimal.get(i).getTo() + "  cost :"
						+ minimal.get(i).getCost());
			}
		} else {
			System.out.println("There isn't  minimum spanning tree!!");
		}

	}

}
