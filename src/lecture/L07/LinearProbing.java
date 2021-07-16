package lecture.L07;

public class LinearProbing<K, V> {
	private int M = 11;  // ���̺� ũ��
	private K[] a = (K[]) new Object[M]; // �ؽ����̺�
	private V[] d = (V[]) new Object[M]; // key���� ������ ����
	private int hash(K key){ // �ؽ��ڵ�
		return (key.hashCode() & 0x7fffffff) % M;  // ������ �Լ�
	}
	private void put(K key, V data) {  // ���� ����
		int initialpos = hash(key);    // �ʱ� ��ġ 
		int i = initialpos, j = 1;
		do {
			if (a[i] == null){  // ���� ��ġ �߰�
				a[i] = key;     // key�� �ؽ����̺� ����
				d[i] = data;    // key���� �����͸� ������ �ε����Ͽ� ���� 
				return;
			}
			if (a[i].equals(key)) {  // �̹� key ����
				d[i] = data;    // �����͸� ����
				return; 
			}            
			i = (initialpos + j++) % M; // i = ���� ��ġ           
		} while (i != initialpos); // ���� i�� �ʱ���ġ�� ���ԵǸ� ���� ����   
	}
	public V get(K key) {  // Ž�� ����
		int initialpos = hash(key);
		int i = initialpos, j = 1;
		while (a[i] != null) {  // a[i]�� empty�� �ƴϸ�
			if (a[i].equals(key))
				return d[i];    // Ž�� ����
			i = (initialpos + j++) % M; // i = ���� ��ġ
		}            
		return null; // Ž�� ����
	}

	public V Delete(int index) {
		int i = index-1;
		V temp = d[i];
		a[i]=null;
		d[i]=null;
		return temp;
	}
//	public V delete(K key) {
//		int i = hash(key);
//		Node pre=null;
//		for (Node x = a[i]; x != null; x = x.next) {   // ���Ḯ��Ʈ Ž��
//			if (key.equals(x.key)) {
//				V temp = (V)x.data;
//				if(pre!=null) {
//					pre.setNext(x.next);
//				}else {
//					a[i]=null;
//				}
//				return temp;
//			}  // Ž�� ����
//			pre = x;
//		}
//
//		return null;
//	}
	public static class Node {  // Node Ŭ����
		private Object key;
		private Object data;
		private Node   next;
		public Node(Object newkey, Object newdata, Node ref){  // ������
			key  = newkey;
			data = newdata;
			next = ref;
		}
		public Object getKey()  { return key; }
		public Object getData() { return data;}
		public void setNext(Node next) {
			this.next=next;
		}
	}
	public static void main(String[] args){ 
		LinearProbing t = new LinearProbing();
/*		//25, 37, 18, 55, 22, 35, 50, 63�� ���ʷ� �ؽ����̺� ����
		t.put(25, "grape"); t.put(37, "apple");	t.put(18, "bananna");
		t.put(55, "cherry");t.put(22, "mango");	t.put(35, "lime");
		t.put(50, "orange");t.put(63, "watermelon");
		
		System.out.println("Ž�� ���:");
		System.out.println("50�� data = "+t.get(50));
		System.out.println("63�� data = "+t.get(63));
		System.out.println();
*/
		t.put(71, "grape"); t.put(23, "apple");	t.put(73, "bananna");
		t.put(49, "cherry");t.put(54, "mango");	t.put(89, "lime");
		t.put(39, "orange");
//		t.delete(39);

		System.out.println("�ؽ� ���̺�:");   
		for(int i=0;i<t.M;++i) System.out.printf("\t%2d",i);
		System.out.println();
		for(int i=0;i<t.M;++i) System.out.print("\t"+t.a[i]);
		System.out.println();
	}
}
