import java.util.ArrayList;
import java.util.Scanner;
public class TestPrim {
	
	public static void main(String[] args) {
		 Scanner sc=new Scanner(System.in);
		 double[][]adjacencyMatrix;
		// System.out.println("Number of vertices :");
		 int vertices= sc.nextInt();
		// System.out.println("Number of edges :");
		 adjacencyMatrix=new double[vertices+1][vertices+1];
		 for (int i = 0; i < adjacencyMatrix.length; i++) {
			for (int j = 0; j < adjacencyMatrix.length; j++) {
				adjacencyMatrix[i][j]=-1;
			}
		}
		 int edges=sc.nextInt();
		// System.out.println("input the edges :");
		 for (int i = 0; i < edges; i++) {
			 String[] input;
			 String s=sc.next();
			 input=s.split(",");
			 int from=Integer.parseInt(input[0]);
			 int to=Integer.parseInt(input[1]);
			 double cost=Double.parseDouble(input[2]);
			 adjacencyMatrix[from][to]=cost;
			 adjacencyMatrix[to][from]=cost;
		}
		Prim p=new Prim(vertices, adjacencyMatrix,edges);
		double finalist=p.MST();
		ArrayList<Edge>minimal=p.getMst();
		if(minimal.size()==vertices-1){
			System.out.println("minimal cost spanning tree  :  "+finalist);
			for (int i = 0; i < minimal.size(); i++) {
				System.out.println(minimal.get(i).getFrom()+"-------"+minimal.get(i).getTo()+ "  cost :"+minimal.get(i).getCost());
			}
		}
		else{
			System.out.println("There isn't  minimum spanning tree!!");
		}


	}

}
