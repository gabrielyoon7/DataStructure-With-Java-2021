package lecture.L09.InsertionSort;

public class main {
	public static void main(String[] args) {
		String a[] = {"I","N","S","E","R","T","I","O","N","S","O","R","T"};
		Insertion.sort(a);
		System.out.printf("���� ���:  ");
		for (int i = 0; i < a.length; i++) {
			System.out.printf(a[i]+"  ");
		}
	}
}
