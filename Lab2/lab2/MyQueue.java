package lab2;
import java.util.LinkedList;

public class MyQueue {
	private final LinkedList<String> list = new LinkedList<>();

	public boolean isEmpty() {
		return list.isEmpty();
	}

	/**
	 * @return first item in the queue
	 */
	public String pop() {
		return list.poll();
	}

	/**
	 * @param str
	 *            String to be pushed to the end of the queue
	 */
	public void push(String str) {
		list.offer(str);
	}

	public static void main(String[] args) {
		final MyQueue queue = new MyQueue();
		System.out.println(queue.isEmpty()); // true
		queue.push("foo");
		queue.push("bar");
		System.out.println(queue.pop()); // foo
		queue.push("baz");
		System.out.println(queue.isEmpty()); // false
		System.out.println(queue.pop()); // bar
		System.out.println(queue.pop()); // baz
		System.out.println(queue.isEmpty()); // true
	}

}
