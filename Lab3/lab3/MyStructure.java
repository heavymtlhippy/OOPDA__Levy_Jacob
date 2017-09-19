package lab3;
import java.util.LinkedList;

public abstract class MyStructure {
	protected final LinkedList<String> list = new LinkedList<String>();

	public final boolean isEmpty() {
		return list.isEmpty();
	}
	public final String pop() {
		return list.pop();
	}
	public abstract void push(String str);
	@Override
	public String toString() {
		return list.toString();
	}
}
