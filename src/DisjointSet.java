
public class DisjointSet {
     int parent[];
     
     public DisjointSet(int vertices){
    	 parent=new int [vertices+1];
    	 for (int i = 0; i < parent.length; i++) {
			parent[i]=i;
		}
     }
     
     public int find(int vertix){
    	 int [] path=new int [parent.length];
    	 int size=0;
    	 while(parent[vertix]!=vertix){
    		 path[size++]=vertix;
    		 vertix=parent[vertix];
    	 }
    	 for (int i = 0; i <size; i++) {
			parent[path[i]]=vertix;
		}
    	 return vertix;
     }
     
     public void union(int from, int to){
    	 parent[find(from)]=find(to);
     }
     boolean checkUnion(int from , int to){
    	 return find(from)==find(to);
     }
}
