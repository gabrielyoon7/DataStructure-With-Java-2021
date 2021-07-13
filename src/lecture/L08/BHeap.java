package lecture.L08;

public class BHeap<Key extends Comparable<Key>, Value> {
	private Entry[] a;      // a[0]�� ��� ����
	private int N;          // ���� ũ��, ��, ���� �ִ� �׸� ��
	public BHeap(Entry[] harray, int initialSize) {  // ������  
		a = harray;
		N = initialSize;
	}
	public int size() { return N; } // ���� ũ�� ����     
	public void createHeap() {      // �ʱ� �� �����     
		for(int i = N/2; i > 0; i--){
			downheap(i);
		}
	}
	public void insert(Key newKey, Value newValue) { // ���ο� �׸� ����
		Entry temp = new Entry(newKey, newValue);	 // Entry ���� 
		a[++N] = temp;        // ���ο� Ű(�׸�)�� �迭 ������ ���� ������ ����
		upheap(N);            // ���� �ö󰡸� ���Ӽ� ȸ����Ű�� ����
	} 	
	public Entry deleteMin() {   // �ּڰ� ����
		Entry min = a[1];     // a[1]�� �ּڰ��� min���� �����Ͽ� ����
		swap(1, N--);         // ���� ������ �׸�� ��ȯ�ϰ� �� ũ�� 1 ����
		a[N+1] = null;        // ������ �׸��� null�� ó��
		downheap(1);          // ���Ӽ��� ȸ����Ű�� ����
		return min;
	}
	private void downheap(int i) {   // i�� ���� ����� �ε���
		while (2*i <= N) {           // i�� ���� �ڽĳ�尡 ���� ������
			int k = 2*i;             // k�� ���� �ڽĳ���� �ε���
			if (k < N && greater(k, k+1)) k++; //���ʰ� ������ �ڽ��� ���ڸ� �����Ͽ� k�� ������ �ε�������
			if (!greater(i, k)) break;  // ���� ��尡 �ڽ� ���ڿ� ���ų� ũ�� ������ �ߴ��ϰ�
			swap(i, k);              // ���� ��尡 �ڽ� ���ں��� ������ ���� ���� �ڽ� ���ڿ� ��ȯ
			i = k;                   // �ڽ� ���ڰ� ���� ��尡 �Ǿ� �ٽ� �ݺ��ϱ� ����
		}
	}	
	private void upheap(int j) {     // j�� ���� ����� �ε���
		while (j > 1 && greater(j/2, j)) { // �����尡 ��Ʈ�� �ƴϰ� ���ÿ� �θ� ������
			swap(j/2, j);            // �θ�� ���� ��� ��ȯ
			j = j/2;                 // �θ� ���� ��尡 �Ǿ� �ٽ� �ݺ��ϱ� ����
		}
	}	
	private boolean greater(int i, int j) { // Ű ��
		return a[j].getKey().compareTo(a[i].getKey()) < 0;  }	
	private void swap(int i, int j) {      // a[i]�� a[j]�� ��ȯ
		Entry temp = a[i];   a[i] = a[j];   a[j] = temp; }	
	public void print(){  
		for (int i = 1; i < N+1; i++) {
			System.out.printf("["+a[i].getKey()+" "+a[i].getValue() + "] ");
		}
		System.out.println(); 	System.out.printf("�� ũ�� = "+size()+"\n\n");
	}
}

