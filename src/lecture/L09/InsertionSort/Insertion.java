package lecture.L09.InsertionSort;

import java.lang.Comparable;
public class Insertion {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {      // i�� ���� ������ �ε���
        	for (int j = i; j > 0; j--) {  // ���� ���Ҹ� ���ĵ� �պκп� ����
                if ( isless(a[j], a[j-1]) )
                  swap(a, j, j-1);
               else break;
        	}
        }
    }

    private static boolean isless(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }

    private static void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
