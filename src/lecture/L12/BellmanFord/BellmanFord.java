package lecture.L12.BellmanFord;

public class BellmanFord {
	public static final int INF = Integer.MAX_VALUE;
    private int D[];
    private int previous[];  // ��� ������ ����
    private int N;
 
    public BellmanFord(int numOfVertices) { // ������
        N = numOfVertices;
        D = new int[N];          // �ִܰŸ� ����
        previous = new int[N];   // �ִܰ�� �����ϱ� ����
    }
 
    public void shortestPath(int s, int adjMatrix[][]) {
        for (int i = 0; i < N; i++) 
        	D[i] = INF;  //�ʱ�ȭ
        D[s] = 0; previous[s] = 0;
        for (int k = 0; k < N-1; k++) {  // �� N-1�� �ݺ�
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) { 
                	if (adjMatrix[i][j] != INF) { 
                		if (D[j] > D[i] + adjMatrix[i][j]){  
                            D[j] = D[i] + adjMatrix[i][j];  // ���� ��ȭ 
                		    previous[j] = i;  // i ���п� j���� �Ÿ���  �����
                		}
                    }
                }
            }
        }
 /*       // 1�� �� ������ȭ �õ��Ͽ� ������ �߻��ϸ� ��������Ŭ ����
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) { 
            	if (adjMatrix[i][j] != INF) { 
            		if (D[j] > D[i] + adjMatrix[i][j])
                        System.out.println("��������Ŭ ����");
                }
            }
        }*/
    }
    public void printPaths(int s){   // ��� ���
    	System.out.println("���� "+s +"���κ����� �ִܰŸ�");
    	for (int i = 1; i < N; i++) {
    		System.out.printf("[%d,%d] = %3d",s,i,D[i]);
    		System.out.println();
    	}
    	System.out.println();
		System.out.println("���� 0���κ����� �ִܰ��");
		for (int i = 1; i < N; i++){
			int back = i;
			System.out.print(back);
			while (back!= 0) {
				System.out.print("<-" + previous[back]);
				back = previous[back];
			}
			System.out.println();
		}
    }
}
