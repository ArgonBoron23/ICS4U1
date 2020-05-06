
public class LinkedList {

	private int size = 0;

	// Inner Class Node. The attributes are accessible within the LinkedList class
	class Node {
		int data;
		Node next; // points to the address of the next node

		Node(int data) {
			this.data = data;
		}
	}

	// Attributes for the LinkedList class
	private Node head;
	private Node tail;

	// append method to add a piece of data to the END of the list.
	public void append(int data) {

		// if the list is empty, create a new head node and quit the method
		if (head == null) {
			head = new Node(data);
			tail = head;
			return;
		}

		// add a new node onto the old last node. this new node is the new last node.
		tail.next = new Node(data);
		tail = tail.next;
		size++;
	}

	// prepend method to add a piece of data to the FRONT of the list
	public void prepend(int data) {

		// if the list is empty, create a new head node and quit the method
		if (head == null) {
			head = new Node(data);
			tail = head;
			return;
		}

		// create a new node for the front of the list, and point its next to the old
		// head.
		Node newHead = new Node(data);
		newHead.next = head;
		// update the head pointer in this list to the new node that was created
		head = newHead;

		size++;
	}

	// deleteWithValue method to delete a Node from the list with specific data
	// value. the return type indicates if the data was either found and deleted, or
	// not found in the list so it could not be deleted.
	public boolean deleteWithValue(int data) {
		// if the list is empty, return false
		if (head == null) {
			return false;
		}
		// if the the start of the list contains the data element, move the head pointer
		// to the next element in the list and return true.
		if (head.data == data) {
			head = head.next;
			size--;
			return true;
		}
		// otherwise:
		// - start at the front of the list
		// - while the next thing in the list is not null, check if the data value for
		// the next thing is what we need to delete, and if it is, change the current
		// node's next to "skip" over the next node to the one after (current.next.next)
		Node current = head;
		while (current.next != null) {
			if (current.next.data == data) {
				current.next = current.next.next;
				tail = current;
				size--;
				return true;
			}
			current = current.next;
		}
		return false;
	}

	public String toString() {
		if (head == null) {
			return "{}";
		} else {
			String s = "{" + head.data;
			Node currentNode = head;
			while (currentNode.next != null) {
				currentNode = currentNode.next;
				s += "," + currentNode.data;
			}
			s += "}";
			return s;
		}
	}

	// method to check size of the linked list
	public int getSize() {
		return size;
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();

		System.out.println(list);
		list.append(5);
		System.out.println(list);

		list.append(6);
		System.out.println(list);
		list.prepend(4);
		System.out.println(list);

		boolean wasDeleted = list.deleteWithValue(6);

		if (wasDeleted) {
			System.out.println("6 was deleted");
		} else {
			System.out.println("6 was not deleted");
		}
		System.out.println(list);

		list.append(8);
		System.out.println(list);

		wasDeleted = list.deleteWithValue(7);
		if (wasDeleted) {
			System.out.println("7 was deleted");
		} else {
			System.out.println("7 was not deleted");
		}
		System.out.println(list);
	}

}
