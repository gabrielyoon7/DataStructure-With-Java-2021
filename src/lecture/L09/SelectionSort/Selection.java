package lecture.L09.SelectionSort;

import java.lang.Comparable;
public class Selection {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i+1; j < N; j++) {  // min ã��
                if (isless(a[j], a[min])) min = j;
            }
            swap(a, i, min); // min�� a[i]�� ��ȯ
        }
    }
     private static boolean isless(Comparable i, Comparable j) { // Ű ��
        return (i.compareTo(j) < 0);
    }
    private static void swap(Comparable[] a, int i, int j) {    // ���� ��ȯ
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
