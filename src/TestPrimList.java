import java.util.ArrayList;
import java.util.Scanner;
public class TestPrimList {

	public static void main(String[] args) {
		 Scanner sc=new Scanner(System.in);
		 ArrayList<Edge>[]adjacencyList ;
		// System.out.println("Number of vertices :");
		 int vertices= sc.nextInt();
		// System.out.println("Number of edges :");
		 adjacencyList=new ArrayList[vertices+1];
		 for (int i = 0; i < adjacencyList.length; i++) {
			adjacencyList[i]=new ArrayList<Edge>();
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
			 Edge e1=new Edge(from, to, cost);
			 Edge e2=new Edge(to, from, cost);
			 adjacencyList[from].add(e1);
			 adjacencyList[to].add(e2);
		}
		PrimList p=new PrimList(vertices, adjacencyList,edges);
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
