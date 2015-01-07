public class LinkedListTest {

	public static void main(String[] args) {
		LinkedListInt test = new LinkedListInt();
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.printList();
		test.removeAt(0);
		test.printList();
		test.add(50, 0);
		test.printList();
		test.add(55, 3);
		test.printList();
		test.add(59,5);
		test.printList();
		System.out.println();
		int [] niz=test.toArray();
		for(int meh:niz){
			System.out.println(meh);
		}
		LinkedListInt test2= new LinkedListInt();
		test2.add(99);
		test2.add(98);
		test.add(test2);
		test.printList();
	}

}
