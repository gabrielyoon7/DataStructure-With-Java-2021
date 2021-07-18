package lecture.L11.DijkstraSP;

public class Edge {
	public int vertex;     // 간선의 한쪽 끝 정점
	public int adjvertex;  // 간선의 다른쪽 끝 정점
	public int weight;     // 간선의 가중치

	public Edge(int u, int v, int wt) {
		vertex    = u;
		adjvertex = v;
		weight    = wt;
	}
}
