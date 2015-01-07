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

	public void printList() {
		Node tmp = head;
		while (tmp != null) {
			System.out.println(tmp.value);
			tmp = tmp.next;
		}
	}

	private class Node {
		public int value;
		public Node next;

		public Node(int value) {
			this.value = value;
			this.next = null;
		}
	}

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

	public int[] toArray() {
		int[]tmp=new int [size];
		Node temp=head;
		for(int i =0;i<size;i++	){
			tmp[i]=temp.value;
			temp=temp.next;
		}
		return tmp;
	}
	public void add(LinkedListInt other){
		Node last=head;
		while(last.next!=null){
			last=last.next;
		}
		last.next=other.head;
	}
	
}
