package lecture.L03.ListQueue;

import java.util.NoSuchElementException;
public class ListQueue <E> {
	private Node<E> front, rear;
	private int size;

	public ListQueue() {   // ������
		front = rear = null;
		size  = 0;
	}
	
	public int     size()    { return size; }        // ť�� �׸��� ���� ����
	public boolean isEmpty() { return size() == 0; } // ť�� empty�̸� true ����

	public void add(E newItem){
		Node newNode = new Node(newItem, null);      // �� ��� ����
		if (isEmpty()) front = newNode; // ť�� empty�̾�����  front�� newNode�� ����Ű�� �Ѵ�
		else rear.setNext(newNode);		// �׷��������� rear�� next�� newNode�� ����Ű�� �Ѵ�
		rear = newNode;					// ���������� rear�� newNode�� ����Ű�� �Ѵ�
		size++;							// ť �׸� �� 1 ����
	}

	public E remove() {
		if (isEmpty()) throw new NoSuchElementException(); // underflow ��쿡 ���α׷� ����
		E frontItem = front.getItem();	// front�� ����Ű�� ����� �׸��� frontItem�� ����
		front = front.getNext();		// front�� front ���� ��带 ����Ű�� �Ѵ�.
		if (isEmpty()) rear = null;		// ť�� empty�̸� rear = null
		size--;							// ť �׸� �� 1 ����
		return frontItem;
	}
	
	public void print() { // ť�� �׸���� front���� ���ʷ� ���
		if (isEmpty()) System.out.print("ť�� empty��");      
		else 
			for (Node p = front; p != null; p = p.getNext()) 
				System.out.print(p.getItem()+"\t ");
		System.out.println();
	}

	public static void main(String[] args) {
		ListQueue<String> q = new ListQueue<String>();

			q.add("apple");		q.add("orange");
			q.add("cherry");	q.add("pear");
			q.print();
			
			q.remove(); q.print();
			q.remove(); q.print();
			
			q.add("grape"); 	q.print();
	}
}
