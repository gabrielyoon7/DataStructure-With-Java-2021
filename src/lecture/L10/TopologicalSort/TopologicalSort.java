package lecture.L10.TopologicalSort;

import java.util.*;
public class TopologicalSort {
    int N;                        // �׷����� ���� ��
    boolean[] visited;            // DFS ���� �� �湮���� üũ ��
    List<Integer>[] adjList;      // ��������Ʈ ������ �Է� �׷���
    List<Integer> sequence;       // ���� ���� ������ ���� ����Ʈ
    public TopologicalSort(List<Integer>[] graph) {  //������
        N = graph.length;
        visited = new boolean[N];
        adjList = graph;
        sequence = new ArrayList<>();
    }
    public List<Integer> tsort() {     // ���������� ���� DFS ����
        for (int i = 0; i < N; i++)    if (!visited[i]) dfs(i);
        Collections.reverse(sequence); // sequence�� �������� �����
        return sequence;
    }
    public void dfs(int i) {       // DFS ����
        visited[i] = true;
        for (int v : adjList[i]) { // u�� �湮�� ������ ������ �湮�ؾ��ϴ� �� ���� v�� ����
            if (!visited[v]) dfs(v);
        }
        sequence.add(i);           // u���� �����ϴ� ������ �� �̻� �����Ƿ� u�� sequence�� �߰�
    }
}