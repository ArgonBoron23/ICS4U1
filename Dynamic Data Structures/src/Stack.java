
public class Stack {

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

	// Push (add) a data element onto the top of the Stack
	public void push(int data) {

		// if the list is empty, create a new head node and quit the method
		if (head == null) {
			head = new Node(data);
			return;
		}

		// create a new node for the front of the list, and point its next to the old
		// head.
		Node newHead = new Node(data);
		newHead.next = head;
		// update the head pointer in this list to the new node that was created
		head = newHead;
	}

	// pop (remove) a data element off the top of the Stack and return its value
	public int pop() {

		// if the list is empty, return a message
		if (this.isEmpty()) {
			System.out.println("The list is empty. No value was popped. ");
			return -1;
		}

		// checks first value
		int peekVal = head.data;

		head = head.next;

		return peekVal;
	}

	// peek (return only) the top data element of the Stack without removing it
	public int peek() {

		// if the list is empty, return a message
		if (this.isEmpty()) {
			System.out.print("The list is empty. Nothing to peek. ");
			return -1;
		}

		return head.data;
	}

	// determine if the Stack is empty
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

		Stack stack = new Stack();

		System.out.println(stack.peek());

		System.out.println(stack);
		stack.push(5);
		System.out.println(stack);
		stack.push(7);
		System.out.println(stack);
		stack.push(9);
		System.out.println(stack);

		System.out.println(stack.peek());

		stack.pop();
		System.out.println(stack);
		stack.push(11);
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
	}

}
