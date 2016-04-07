import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class FinalTest {
	public static int[][] dense(int vertix){
		Random rand = new Random();
		int limit=(vertix*(vertix-1)/2)-(vertix-1);
		int min=(vertix*(vertix-1)/4);
		int number=rand.nextInt((limit - min) + 1)+min ;
		int[][]input=new int[number+vertix-1][3];
		int [][] connected=connected(vertix);
		ArrayList<Integer>[]check=new ArrayList[vertix+1];
		 for (int i = 0; i < check.length; i++) {
			check[i]=new ArrayList<Integer>();
		}
		for (int i = 0; i < connected.length; i++) {
			input[i][0]=connected[i][0];
			input[i][1]=connected[i][1];
			input[i][2]=connected[i][2];
		}
		int loop=vertix-1;
		while(number!=0){
			int one=rand.nextInt((vertix - 1) + 1)+1 ;
		    int two=rand.nextInt((vertix - 1) + 1)+1 ;
		    if(one!=two &&Math.abs(one-two)!=1&&!check[one].contains(two)){
		    	input[loop][0]=one;
		    	input[loop][1]=two;
		    	input[loop][2]=rand.nextInt((200 - 2) + 1) + 2;
		    	loop++;
		    	number--;
		    	check[one].add(two);
		    	check[two].add(one);
		    }
		}
		return input;
		
	}
	public static int [][] connected(int vertix){
		int [][]input=new int [vertix-1][3];
		Random rand = new Random();
		for (int i = 0; i < vertix-1; i++) {
			input[i][0]=i+1;
			input[i][1]=i+2;
			input[i][2]=rand.nextInt((200 - 2) + 1) + 2;
		}
		return input;
		
	}
	public static int [][] sparse (int vertix){
		Random rand = new Random();
		int limit=(vertix*(vertix-1)/4)-(vertix-1);
		int number=rand.nextInt((limit - 0) + 1) ;
		int[][]input=new int[number+vertix-1][3];
		int [][] connected=connected(vertix);
		ArrayList<Integer>[]check=new ArrayList[vertix+1];
		 for (int i = 0; i < check.length; i++) {
			check[i]=new ArrayList<Integer>();
		}
		//System.out.println("jjjjjjj   :"+number);
		for (int i = 0; i < connected.length; i++) {
			input[i][0]=connected[i][0];
			input[i][1]=connected[i][1];
			input[i][2]=connected[i][2];
		}
		int loop=vertix-1;
		while(number!=0){
			int one=rand.nextInt((vertix - 1) + 1)+1 ;
		    int two=rand.nextInt((vertix - 1) + 1)+1 ;
		    if(one!=two &&Math.abs(one-two)!=1&&!check[one].contains(two)){
		    	input[loop][0]=one;
		    	input[loop][1]=two;
		    	input[loop][2]=rand.nextInt((200 - 2) + 1) + 2;
		    	loop++;
		    	number--;
		    	check[one].add(two);
		    	check[two].add(one);
		    	//System.out.println(check[one].contains(two));
		    }
		}
		return input;

	}
	
	public static int[][] randomly(int vertix){
		Random rand = new Random();
		int limit=(vertix*(vertix-1)/2)-(vertix-1);
		int number=rand.nextInt((limit - 0) + 1) ;
		int[][]input=new int[number+vertix-1][3];
		int [][] connected=connected(vertix);
		ArrayList<Integer>[]check=new ArrayList[vertix+1];
		 for (int i = 0; i < check.length; i++) {
			check[i]=new ArrayList<Integer>();
		}
		for (int i = 0; i < connected.length; i++) {
			input[i][0]=connected[i][0];
			input[i][1]=connected[i][1];
			input[i][2]=connected[i][2];
		}
		int loop=vertix-1;
		while(number!=0){
			int one=rand.nextInt((vertix - 1) + 1)+1 ;
		    int two=rand.nextInt((vertix - 1) + 1)+1 ;
		    if(one!=two &&Math.abs(one-two)!=1&&!check[one].contains(two)){
		    	input[loop][0]=one;
		    	input[loop][1]=two;
		    	input[loop][2]=rand.nextInt((200 - 2) + 1) + 2;
		    	loop++;
		    	number--;
		    	check[one].add(two);
		    	check[two].add(one);
		    }
		}
		return input;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int vertices = 1000;
		int[][]input=dense(vertices);
		double[][] adjacencyMatrix;
		ArrayList<Edge>[] adjacencyList;
		//int vertices = sc.nextInt();
//		int edges = sc.nextInt();
		int edges=input.length;
		System.out.println("number of edges    :  "+edges);
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
			int from = input[i][0];
			int to = input[i][1];
			double cost = input[i][2];
		//	System.out.println(from+" , "+to+" , "+cost);
			 edgeArray[i]=new Edge(from, to, cost);
			Edge e1 = new Edge(from, to, cost);
			Edge e2 = new Edge(to, from, cost);
			adjacencyList[from].add(e1);
			adjacencyList[to].add(e2);
			adjacencyMatrix[from][to] = cost;
			adjacencyMatrix[to][from] = cost;
		}
		kruskal k = new kruskal(vertices, edgeArray);
		Prim p1=new Prim(vertices, adjacencyMatrix, edges);
		PrimList p2=new PrimList(vertices, adjacencyList, edges);
	    long lDateTime = System.nanoTime();
		double finalist = k.MST();
	     long lDateTime2 = System.nanoTime();
		ArrayList<Edge>minimal=k.getMst();
		if(minimal.size()==vertices-1){
			System.out.println("minimal cost spanning tree  :  "+finalist);
			for (int i = 0; i < minimal.size(); i++) {
				System.out.println(minimal.get(i).getFrom()+"-------"+minimal.get(i).getTo()+ "  cost :"+minimal.get(i).getCost());
			}
		}
		else{
			System.out.println("There isn't  minimum spanning tree!!");
		}
		System.out.println("Time kruskal   :"   +((lDateTime2-lDateTime)/1000));
		System.out.println("******************************************************************");
	    lDateTime = System.nanoTime();
		double finalist2 = p1.MST();
	     lDateTime2 =System.nanoTime();
		ArrayList<Edge>minimal2=p1.getMst();
		if(minimal2.size()==vertices-1){
			System.out.println("minimal cost spanning tree  :  "+finalist2);
			for (int i = 0; i < minimal2.size(); i++) {
				System.out.println(minimal2.get(i).getFrom()+"-------"+minimal2.get(i).getTo()+ "  cost :"+minimal2.get(i).getCost());
			}
		}
		else{
			System.out.println("There isn't  minimum spanning tree!!");
		}
		System.out.println(" prim adjacency matrix     :   "+((lDateTime2-lDateTime)/1000));
		System.out.println("******************************************************************");
	    lDateTime = System.nanoTime();
		double finalist3 = p2.MST();
	    lDateTime2 = System.nanoTime();
		ArrayList<Edge>minimal3=p2.getMst();
		if(minimal3.size()==vertices-1){
			System.out.println("minimal cost spanning tree  :  "+finalist3);
			for (int i = 0; i < minimal3.size(); i++) {
				System.out.println(minimal3.get(i).getFrom()+"-------"+minimal3.get(i).getTo()+ "  cost :"+minimal3.get(i).getCost());
			}
		}
		else{
			System.out.println("There isn't  minimum spanning tree!!");
		}
		
		System.out.println("prime adjacency list   :   "+((lDateTime2-lDateTime)/1000));
	   //   System.out.println("Date() - Time in milliseconds: " + lDateTime);

	}

}
