/**
 * 
 */
package lab2;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @author mdr
 * 
 *         Uses iterators to show the basic functionality of a HashMap data
 *         structure.
 *
 */
public class MyHashMap {
	@SuppressWarnings("unchecked") // because not all of the iterators are String iterators, the compiler is getting upset
	public static void main(String[] args) {
		final HashMap<String, String> hashmap = new HashMap<>();
		hashmap.put("foo", "bar");
		hashmap.put("baz", "quux");
		hashmap.put("magic", "xyzzy");

		@SuppressWarnings("rawtypes") // non-generic because entries is of a different type than the other two
		Iterator keys = hashmap.keySet().iterator(), values = hashmap.values().iterator(),
				entries = hashmap.entrySet().iterator();
		System.out.println("Keys:");
		keys.forEachRemaining(System.out::println); // foo, baz, magic
		System.out.println("\nValues:");
		values.forEachRemaining(System.out::println); // bar, quux, xyzzy
		System.out.println("\nEntries:");
		entries.forEachRemaining((x) -> System.out.println(x.toString())); // foo=bar, baz=quux, magic=xyzzy

	}
}
