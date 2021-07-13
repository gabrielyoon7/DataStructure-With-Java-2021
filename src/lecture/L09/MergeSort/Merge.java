package lecture.L09.MergeSort;

import java.lang.Comparable;
public class Merge {
	private static void merge(Comparable[] a, Comparable[] b, int low, int mid, int high) {
		int i = low, j = mid+1;
		for (int k = low; k <= high; k++) { // �迭 a�� �պκа� �޺κ��� �պ��Ͽ� �����迭 b�� ����
			if      (i > mid)             b[k] = a[j++];   // �պκ��� ���� ������ ���
			else if (j > high)            b[k] = a[i++];   // �޺κ��� ���� ������ ���
			else if (isless(a[j], a[i]))    b[k] = a[j++]; // a[j]�� ����
			else                          b[k] = a[i++];   // a[i]�� ����
		}
		for (int k = low;k <= high; k++) a[k] = b[k];      // �����迭 b�� �迭 a�� ����	
	}
	private static void sort(Comparable[] a, Comparable[] b, int low, int high) {
		if (high <= low) return;
		int mid = low + (high - low) / 2;
		sort(a, b, low, mid);        // �պκ� ���ȣ��
		sort(a, b, mid + 1, high);   // �޺κ� ���ȣ��
		merge(a, b, low, mid, high); // �պ� ����
	}
	public static void sort(Comparable[] a) {
		Comparable[] b = new Comparable[a.length];
		sort(a, b, 0, a.length-1);
	}
	private static boolean isless(Comparable v, Comparable w) {
		return (v.compareTo(w) < 0);
	}
}
 