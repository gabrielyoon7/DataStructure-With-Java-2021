package lecture.L04;

import java.util.*;
public class BinaryTree<Key extends Comparable<Key>>  {
	private Node root;

	public BinaryTree( ) { root = null; }      // Ʈ�� ������

	public Node getRoot( )            { return root; }
	public void setRoot(Node newRoot) { root = newRoot; }

	public boolean isEmpty( ) { return root == null; }

	public void preorder(Node n) {     // ���� ��ȸ
		if (n != null) {
			System.out.print(n.getKey()+" ");  // ��� n �湮
			preorder(n.getLeft());  // n�� ����    ���� Ʈ���� ��ȸ�ϱ� ����
			preorder(n.getRight()); // n�� ������ ���� Ʈ���� ��ȸ�ϱ� ����
		}
	}

	public void inorder(Node n){       // ���� ��ȸ
		if (n != null) {
			inorder(n.getLeft());   // n�� ���� ���� Ʈ���� ��ȸ�ϱ� ����
			System.out.print(n.getKey()+" ");  // ��� n �湮
			inorder(n.getRight());  // n�� ������ ���� Ʈ���� ��ȸ�ϱ� ����
		}
	}

	public void postorder(Node n) {     // ���� ��ȸ 
		if (n != null) {
			postorder(n.getLeft());  // n�� ����    ���� Ʈ���� ��ȸ�ϱ� ����   
			postorder(n.getRight()); // n�� ������ ���� Ʈ���� ��ȸ�ϱ� ����
			System.out.print(n.getKey()+" "); // ��� n �湮
		}
	}
	
	public void levelorder(Node root) { // ���� ��ȸ
		Queue<Node> q = new LinkedList<Node>(); // ť �ڷᱸ�� �̿�
		Node t;
		q.add(root);  // ��Ʈ ��� ť�� ����
		while (!q.isEmpty()) { 
			t = q.remove();   //ť���� ���� �տ� �ִ� ��� ����
			System.out.print(t.getKey()+" "); // ���ŵ� ��� ���(�湮)
			if (t.getLeft() != null)      // ���ŵ� ���� �ڽ��� null�� �ƴϸ�
				q.add(t.getLeft());       // ť�� ���� �ڽ� ����
			if (t.getRight() != null)     // ���ŵ� ������ �ڽ��� null�� �ƴϸ�
				q.add(t.getRight());      // ť��  ������ �ڽ� ����
		} 
	}
	
	public int size(Node n)	{  // n�� ��Ʈ���ϴ� (����)Ʈ���� �ִ� ��� ��
		if (n == null)   
			return 0;   // null�̸� 0 ����
		else  
			return (1 + size( n.getLeft() ) + size( n.getRight() )); 
	}

	public int height(Node n) {  // n�� ��Ʈ���ϴ� (����)Ʈ���� ����
		if (n == null)   
			return 0;    // null�̸� 0 ����
		else  
			return (1 + Math.max(height(n.getLeft()), height(n.getRight()))); 
	}
	
	public static boolean isEqual(Node n, Node m){  // �� Ʈ���� ���ϼ� �˻�
		if(n==null || m==null)  // ���߿� �ϳ��� null�̸�
			return n == m;      // �Ѵ� null�̸� true, �ƴϸ� false

		if (n.getKey().compareTo(m.getKey()) != 0) // �Ѵ� null�� �ƴϸ� item ��
			return false; 
		
		return( isEqual(n.getLeft(), m.getLeft()) &&  // item�� ������ ����/������ �ڽ����� ��� ȣ��
				isEqual(n.getRight(), m.getRight()) );
	}
	
	public Node copy (Node n) {
		Node left, right;
		if (n == null) return null;
		else {
			left  = copy(n.getLeft());
			right = copy(n.getRight());
			return new Node(n.getKey(),left, right);
		}
	}
}
