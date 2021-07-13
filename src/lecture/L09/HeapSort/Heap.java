package lecture.L09.HeapSort;

import java.lang.Comparable;
public class Heap {
	public static void sort(Comparable[] a) {
		int heapSize = a.length-1;           // a[0]�� ��� ����
		for (int i = heapSize/2; i > 0; i--) // �� ����� 
			downheap(a, i, heapSize);
		while (heapSize > 1) {        // �� ����
			swap(a, 1, heapSize--);   // ���� ������ ���� ū ���� ���� a[1]�� ���� ������ ���ҿ� ��ȯ
			downheap(a, 1, heapSize); // ����� �� �Ӽ� ��ġ��
		}
	}
	private static void downheap(Comparable[] a, int p, int heapSize) {
		while (2*p <= heapSize) {
			int s = 2*p;    //s=���� �ڽ��� �ε���
			if (s < heapSize && isless(a[s], a[s+1])) s++; // ������ �ڽ��� ū ���
			if (!isless(a[p], a[s])) break; // �θ�(p)��  �ڽ� ����(s)���� ũ�� �� ���� ����
			swap(a, p, s);  // �� �Ӽ� ���� ���ϸ�  �θ�(p)��  �ڽ� ����(s) ��ȯ
			p = s;          // ���� �ڽ� ������ �ڸ��� �θ� �ְԵ�
		}
	}
	private static boolean isless(Comparable i, Comparable j) {
		return (i.compareTo(j) < 0);
	}
    private static void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
