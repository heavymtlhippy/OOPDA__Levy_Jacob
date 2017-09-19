package lab3;

public class MyQueue extends MyStructure {
	@Override
	public void push(String str) {
		list.offer(str);
	}
}
