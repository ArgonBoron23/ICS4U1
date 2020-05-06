
public class Queue {

	// Inner class for Node
	class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	// private attributes
	private Node head;
	private Node tail;

	// Enqueue (add) a data element to the end of the Queue
	public void enqueue(int data) {
		// if the list is empty, create a new head node and quit the method
		if (head == null) {
			head = new Node(data);
			tail = head;
			return;
		}

		// add a new node onto the old last node. this new node is the new last node.
		tail.next = new Node(data);
		tail = tail.next;
	}

	// dequeue (remove) a data element from the front of the Queue and return its
	// value
	public int dequeue() {

		// if the list is empty, return a message
		if (this.isEmpty()) {
			System.out.print("The list is empty. No value was dequeued.");
			return -1;
		}

		// checks first value
		int peekVal = head.data;

		head = head.next;

		return peekVal;
	}

	// peek (return only) the data element at the front of the Queue without
	// removing it
	public int peek() {

		// if the list is empty, return a message
		if (this.isEmpty()) {
			System.out.print("The list is empty. Nothing to peek. ");
			return -1;
		}

		return head.data;
	}

	// determine if the Queue is empty
	public boolean isEmpty() {

		if (head == null) {
			return true;
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

	// main method
	public static void main(String[] args) {

		Queue queue = new Queue();

		System.out.println(queue.peek());

		System.out.println(queue);
		queue.enqueue(5);
		System.out.println(queue);
		queue.enqueue(7);
		System.out.println(queue);
		queue.enqueue(9);
		System.out.println(queue);

		System.out.println(queue.peek());
		System.out.println(queue);

		System.out.println(queue.dequeue());
		System.out.println(queue);
		queue.enqueue(11);
		System.out.println(queue);
		System.out.println(queue.dequeue());
		System.out.println(queue);
		System.out.println(queue.dequeue());
		System.out.println(queue);
		System.out.println(queue.dequeue());
		System.out.println(queue);
		System.out.println(queue.dequeue());
		System.out.println(queue);

	}

}
