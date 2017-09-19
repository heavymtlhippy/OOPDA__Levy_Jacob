package lab3;

public class TestDriver {
	
	//@formatter:off
	/* Lesson 03a:
	 * 
	 * a). 
	 * 		Person p1 = new Student() // `Student` is a subtype of `Person`.
	 * 		Person p2 = new PhDStudent() // `PhDStudent` is a subtype of `Student` which is a subtype of `Person`
	 * 		Student s1 = new PhDStudent() // `PhDStudent` is  subtype of `Student`
	 * 		
	 * 		The other two statements are illegal because they are trying to coerce up without explicitly casting
	 * 
	 * b).
	 * 		p1 = s1 // this is a valid statement because it is only getting *more* specific in its typing
	 * 
	 * 		The other two statements are invalid because they are attempting to coerce types *up* the type-tree.
	 */
	//@formatter:on
	
	public static void main(String[] args) {
		final String test = "This is the string that you will use to test the stack and queue classes.";
		final MyQueue myQueue = new MyQueue();
		final MyStack myStack = new MyStack();

		String str = test;
		while (str.indexOf(" ") != -1 && !str.isEmpty()) {
			myQueue.push(str.substring(0, str.indexOf(" ")));
			str = str.substring(str.indexOf(" ") + 1);
		}
		if (!str.isEmpty()) myQueue.push(str);

		System.out.println("Queue: " + myQueue.toString() + "\n");
		while (!myQueue.isEmpty())
			myStack.push(myQueue.pop());

		while (!myStack.isEmpty())
			System.out.println(myStack.pop());
	}
}
