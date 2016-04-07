
public class Edge implements Comparable<Edge> {

    private int from;
    private int to;
    private double cost;
    public Edge(int from, int to, double cost){
    	this.from=from;
    	this.to=to;
    	this.cost=cost;
    }
	public int getFrom() {
		return from;
	}
	public void setFrom(int from) {
		this.from = from;
	}
	public int getTo() {
		return to;
	}
	public void setTo(int to) {
		this.to = to;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	@Override
	public int compareTo(Edge o) {
		return (int) (this.cost-o.cost);
	}
    
}
