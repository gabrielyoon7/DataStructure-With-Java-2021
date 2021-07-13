package lecture.L09.SelectionSort;

public class main {
	public static void main(String[] args) {
		String a[] = {"S","E","L","E","C","T","I","O","N","S","O","R","T"};
		Selection.sort(a);
		System.out.printf("���� ���: ");
		for (int i = 0; i < a.length; i++) {
			System.out.printf(a[i]+"  ");
		}
	}
}
