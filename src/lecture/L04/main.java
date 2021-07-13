package lecture.L04;

public class main {

	public static void main(String[] args) {

		Node n1 = new Node(100,null,null); 	Node n2 = new Node(200,null,null);
		Node n3 = new Node(300,null,null);	Node n4 = new Node(400,null,null);	
		Node n5 = new Node(500,null,null);	Node n6 = new Node(600,null,null);
		Node n7 = new Node(700,null,null);	Node n8 = new Node(800,null,null);

		n1.setLeft(n2); n1.setRight(n3);  // n1�� ���� �ڽ�-> n2, n1�� ������ �ڽ�-> n3
		n2.setLeft(n4);	n2.setRight(n5);  // n2�� ���� �ڽ�-> n4, n2�� ������ �ڽ�-> n5
		n3.setLeft(n6);	n3.setRight(n7);  // n3�� ���� �ڽ�-> n6, n3�� ������ �ڽ�-> n7
		n4.setLeft(n8); 				  // n4�� ���� �ڽ�-> n8
		
		BinaryTree t = new BinaryTree();  // ���� Ʈ�� ��ü t ���� 
		t.setRoot(n1); 					  // t�� ��Ʈ ��带 n1����
		
		System.out.print("Ʈ�� ��� ��  = "+ t.size(t.getRoot())+"\nƮ�� ����      = "+ t.height(t.getRoot()));
		System.out.printf("\n���� ��ȸ:  ");
		t.preorder(t.getRoot());
		System.out.printf("\n���� ��ȸ:  ");
		t.inorder(t.getRoot());
		System.out.printf("\n���� ��ȸ:  ");
		t.postorder(t.getRoot());
		System.out.printf("\n���� ��ȸ:  ");
		t.levelorder(t.getRoot());
		System.out.println();

		// �ι�° ���� Ʈ���� ����� isEqual() �׽�Ʈ�ϱ� ����
		Node n10 = new Node(100,null,null);	Node n20 = new Node(200,null,null);
		Node n30 = new Node(300,null,null);	Node n40 = new Node(400,null,null);	
		Node n50 = new Node(500,null,null);	Node n60 = new Node(600,null,null);
		Node n70 = new Node(700,null,null);	Node n80 = new Node(800,null,null);

		n10.setLeft(n20); n10.setRight(n30);
		n20.setLeft(n40); n20.setRight(n50);
		n30.setLeft(n60); n30.setRight(n70);
		n40.setLeft(n80);
		
		BinaryTree t2 = new BinaryTree();
		t2.setRoot(n10);

		System.out.printf("���ϼ� �˻�:   "+BinaryTree.isEqual(t.getRoot(), t2.getRoot()));
		System.out.println();
		
		BinaryTree t3 = new BinaryTree();
		t3.setRoot(t3.copy(t.getRoot()));
		System.out.printf("copy �׽�Ʈ: "+BinaryTree.isEqual(t.getRoot(), t3.getRoot()));
		System.out.println();

	}
}

