/**
 * Pravljenje liste, ubacivanje i izbacivanje brojeva
 * @author harisarifovic
 *
 */
public class LinkedListInt {
	private Node head;
	private int size;

	public LinkedListInt() {
		this.head = null;
		this.size = 0;
	}
/**
 * Kreira novi Node
 * @param value Vrijednost node-a
 */
	public void add(int value) {
		Node newNode = new Node(value);
		if (head == null) {
			head = newNode;
			size++;
			return;
		}

		Node current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = newNode;
		size++;
	}
	/**
	 * Dodavanje node-a bilo gdje u listi
	 * @param value Vrijednost node-a
	 * @param index indeks gdje treba postaviti novi node
	 */
	public void add(int value,int index){
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index nije validan!");
		}
		
		Node insert= new Node(value);
		if (index == 0) {
			insert.next=head;
			head=insert;
			size++;
			return;
		}
		if (index==size){
			add(value);
			return;
		}
		
		Node previous = head;
		int counter = 1;
		while (counter < index) {
			previous = previous.next;
			counter++;
		}
		insert.next=previous.next;
		previous.next=insert;
		size++;
	}
/**
 * Ispisuje listu
 */
	public void printList() {
		Node tmp = head;
		while (tmp != null) {
			System.out.println(tmp.value);
			tmp = tmp.next;
		}
	}
/**
 * Node klasa 
 * @author harisarifovic
 *
 */
	private class Node {
		public int value;
		public Node next;

		public Node(int value) {
			this.value = value;
			this.next = null;
		}
	}
/**
 * Brisanje node-a sa liste
 * @param index Index node-a koji se brise
 */
	public void removeAt(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index nije validan!");
		}
		if (index == 0) {
			head = head.next;
			size--;
			return;
		}
		Node current = head.next;
		Node previous = head;
		int counter = 1;
		while (counter < index) {
			current = current.next;
			previous = previous.next;
			counter++;
		}
		previous.next = current.next;
		current.next = null;

	}
/**
 * Pretvara listu u niz integera
 * @return Niz integera
 */
	public int[] toArray() {
		int[]tmp=new int [size];
		Node temp=head;
		for(int i =0;i<size;i++	){
			tmp[i]=temp.value;
			temp=temp.next;
		}
		return tmp;
	}
	/**
	 * Dodavanje liste na listu
	 * @param other Druga lista
	 */
	public void add(LinkedListInt other){
		if(head==null){
			this.head=other.head;
			return;
		}
		Node last=head;
		while(last.next!=null){
			last=last.next;
		}
		last.next=other.head;
		this.size+=other.size;
	}
	
}
