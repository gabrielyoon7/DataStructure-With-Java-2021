package lecture.L11.KruskalMST;

import lecture.L11.DijkstraSP.Edge;

import java.util.*;
public class KruskalMST {
	int N, M; // �׷��� ����, ������ ��
	List<lecture.L11.DijkstraSP.Edge>[] graph;
	UnionFind uf; // Union-Find ������ ����ϱ� ����	
	lecture.L11.DijkstraSP.Edge[] tree;
	static class Weight_Comparison implements Comparator<lecture.L11.DijkstraSP.Edge> { //weight�� �������� �켱����ť��  ����ϱ� ����
		public int compare(lecture.L11.DijkstraSP.Edge e, lecture.L11.DijkstraSP.Edge f) {
			if(e.weight > f.weight)
				return 1;
			else if(e.weight < f.weight)
				return -1;		
			return 0;
		}		
	}
	public KruskalMST(List<lecture.L11.DijkstraSP.Edge>[] adjList, int numOfEdges) {
		N = adjList.length;
		M = numOfEdges;
		graph = adjList;
		uf = new UnionFind(N);	// Union-Find ������ ����ϱ� ����	
		tree = new lecture.L11.DijkstraSP.Edge[N-1];
	}
	public lecture.L11.DijkstraSP.Edge[] mst()	{  // Kruskal �˰���
		Weight_Comparison BY_WEIGHT = new Weight_Comparison();  // �켱����ť��  weight �������� �����ϱ� ����		
		PriorityQueue<lecture.L11.DijkstraSP.Edge> pq = new PriorityQueue<lecture.L11.DijkstraSP.Edge>(M, BY_WEIGHT);  // �ڹ� ���̺귯���� �켱����ť ���
								    // �켱����ť�� ũ��� M(������ ��)�� ����, BY_WEIGHT�� line 24�� comparator
		for (int i = 0; i < N; i++){ 
			for (lecture.L11.DijkstraSP.Edge e : graph[i]){
				pq.add(e);  // edgeArray�� ���� ��ü���� pq�� ����
			}
		}		
		int count = 0;	
		while (!pq.isEmpty() && count < N-1) {
			Edge e = pq.poll();          // �ּ� ����ġ�� ���� ������ pq���� �����ϰ� ������
			int u = e.vertex;            // ������ ������ �� �� ����
			int v = e.adjvertex; 	     // ������ ������ �ٸ� �� �� ����
			if (!uf.isConnected(u, v)) { // v�� w�� ���� �ٸ� ���տ� ���� ������
				uf.union(u, v);          // v�� ���� ���հ� u�� ���� ������ ������ ����
				tree[count++] = e;       // e�� MST�� �������μ� tree�� �߰�
			}
		}			
		return tree;
	}
}
 