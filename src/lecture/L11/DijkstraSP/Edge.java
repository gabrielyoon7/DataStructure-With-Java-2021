package lecture.L11.DijkstraSP;

public class Edge {
	public int vertex;     // ������ ���� �� ����
	public int adjvertex;  // ������ �ٸ��� �� ����
	public int weight;     // ������ ����ġ

	public Edge(int u, int v, int wt) {
		vertex    = u;
		adjvertex = v;
		weight    = wt;
	}
}
