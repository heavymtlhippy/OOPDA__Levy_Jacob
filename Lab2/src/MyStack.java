package src;
import java.util.LinkedList;

/**
 * @author mdr
 *
 *         General implementation of a stack using a <code>LinkedList</code>
 *         internally.
 * @see java.util.LinkedList
 */
public class MyStack {
	private final LinkedList<String> list = new LinkedList<>();

	public boolean isEmpty() {
		return list.isEmpty();
	}

	/**
	 * @return last (top) item of the stack
	 */
	public String pop() {
		return list.pop();
	}

	/**
	 * @param str
	 *            String to be pushed to the top of the stack
	 */
	public void push(String str) {
		list.push(str);
	}

	public static void main(String[] args) {
		final MyStack stack = new MyStack();
		System.out.println(stack.isEmpty()); // true
		stack.push("foo");
		stack.push("bar");
		System.out.println(stack.pop()); // bar
		stack.push("baz");
		System.out.println(stack.isEmpty()); // false
		System.out.println(stack.pop()); // baz
		System.out.println(stack.pop()); // foo
		System.out.println(stack.isEmpty()); // true
	}
}
