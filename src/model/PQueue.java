package model;
/**
 * Linked implementation of PriorityQueue
 * @author Tyler Stinson
 *
 * @param <T>
 */

 public class PQueue<T extends Comparable<T>> {

	public static void main(String[] args) {
		PQueue<Integer> q = new PQueue<>();
		q.push(5);
		q.push(125);
		q.push(4);
		q.push(1);
		q.push(25);
		q.push(10);
		while (q.peek() != null) {
			System.out.println(q.poll());
		}
	}

	public Node root;
	private int size;
	

	public PQueue() {
		root = null;
		size = 0;
	}
	
	/**
	 * Primary sort method. Check left and right children, swap with lowest weighted node.
	 * called recursively.
	 * @param root
	 */
	private void heapify(Node root) {
		//null check
		if (root == null) return;
		
		//find min weighted node
		Node child = getMinNode(root.left, root.right);

		//if child node < parent swap and recursively call heapify
		if (child != null && root.data.compareTo(child.data) > 0) {
			T temp = child.data;
			child.data = root.data;
			root.data = temp;
		}
	}
	
	/**
	 * Add new data onto queue.
	 * @param data to be added to queue.
	 */
	public void push(T data) {
		size++;
		String bits = getCurBinary(size);
		this.root = push(data, root, bits);
	}
	
	/**
	 * 
	 * @param first
	 * @param second
	 * @return
	 */
	private Node getMinNode(Node first, Node second) {
		if (first == null) return null;
		if (second == null) return first; //dont need to check first as it SHOULD be the left child
		return first.data.compareTo(second.data) < 0 ? first : second;
	}

	private Node push(T data, Node root, String bits) {
		if (root == null) {
			return new Node(data);
		} else if (bits.charAt(0) == '0') {
			root.left = push(data, root.left, bits.substring(1));
		} else {
			root.right = push(data, root.right, bits.substring(1));
		}
		heapify(root);
		return root;
	}
	
	/**
	 * Get binary value first empty slot in tree.
	 * @return
	 */
	private String getCurBinary(int size) {
		String bin = "";
		int temp = size;

		while(temp > 1) {
			bin = temp % 2 + bin;
			temp /= 2;
		}

		return bin;
	}
	
	
	public T poll() {
		if (size <= 0) return null;
		String bits = getCurBinary(this.size);
		this.size--;
		T data = root.data;
		this.root = pollHelp(root, bits);
		return data;
	}
	
	private Node pollHelp(Node root, String bits) {
		if (bits.length() == 0) {
			this.root.data = root.data;
			return null;
		} else if (bits.charAt(0) == '0') {
			root.left = pollHelp(root.left, bits.substring(1));
		} else {
			root.right = pollHelp(root.right, bits.substring(1));
		}
		
		heapify(root);
		return root;
	}
	
	public T peek() {
		return this.size > 0 ? this.root.data : null;
	}
	
	private class Node {
		T data;
		Node left;
		Node right;
		
		Node(T data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
		
	}
}
