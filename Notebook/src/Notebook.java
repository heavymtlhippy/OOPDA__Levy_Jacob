package src;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

/**
 * @author mdr
 * 
 *         Uses an ArrayList of Strings to represent a notebook that can be used
 *         for note taking and lookup.
 */
public class Notebook {
	private final ArrayList<String> notebook = new ArrayList<>();

	/**
	 * Adds notes that are distinct only.
	 * 
	 * @param str distinct note to be added
	 * @return <code>true</code> if note was added, <code>false</code> if the note
	 *         already existed
	 */
	public boolean addNote(String str) {
		if(notebook.contains(str)) return false;
		notebook.add(str);
		return true;
	}
	/**
	 * @param str exact String of the note to be deleted
	 * @throws NoSuchElementException no such String could be found in the notebook
	 */
	public void deleteNote(String str) throws NoSuchElementException {
		if(!notebook.contains(str)) throw new NoSuchElementException("No such note exists!");
		notebook.remove(str);
	}
	public int getNoteNumber(String str) {
		return notebook.indexOf(str);
	}
	/**
	 * @param n index in the notebook
	 * @return note at index <code>n</code>
	 * @throws IndexOutOfBoundsException <code>n &lt; o || n &gt; this.length</code>
	 */
	public String getNote(int n) throws IndexOutOfBoundsException {
		return notebook.get(n);
	}
	/**
	 * Swaps the specified note with the one below. No action is performed if it is
	 * the last note in the notebook. Does nothing if the note can't be found.
	 * 
	 * @param str exact String representation of the note
	 */
	public void moveNoteDown(String str) {
		int i = notebook.indexOf(str);
		if (i == -1 || i == notebook.size() - 1) return;
		else Collections.swap(notebook, i, i + 1);
	}
	/**
	 * Swaps the specified note with the one above. No action is performed if it is
	 * the first note in the notebook. Does nothing if the note can't be found.
	 * 
	 * @param str exact String representation of the note
	 */
	public void moveNoteUp(String str) {
		int i = notebook.indexOf(str);
		if (i == -1 || i == 0) return;
		else Collections.swap(notebook, i, i - 1);
	}
	/**
	 * Does not swap notes. This method removes the selected note from the notebook
	 * and reinserts it at the end.
	 * 
	 * @param str exact String representation of the note
	 */
	public void moveToBottom(String str) {
		if(!notebook.contains(str)) return;
		notebook.remove(str);
		notebook.add(str);
	}
	/**
	 * Does not swap notes. This method removes the selected note from the notebook
	 * and reinserts it at the start.
	 * 
	 * @param str exact String representation of the note
	 */
	public void moveToTop(String str) {
		if(!notebook.contains(str)) return;
		notebook.remove(str);
		notebook.add(0, str);
	}
	public int numberOfNotes() {
		return notebook.size();
	}
	/**
	 * Sets the text of the <code>n</code>th note to <code>str</code>.
	 * 
	 * @param n index in the notebook
	 * @param str String representation of the replacement note
	 * @throws NoSuchElementException index out of bounds
	 */
	public void setNote(int n, String str) throws NoSuchElementException {
		if (n < 0 || n >= notebook.size()) throw new NoSuchElementException("No note exists there!");
		notebook.set(n, str);
	}
	@Override
	public String toString() {
		return notebook.stream().collect(Collectors.joining("\n"));
	}

	public static void main(String[] args) {
		final Notebook test=new Notebook();
		
		Arrays.stream(new String[]{	"elit", "ipsum", "dolor", "amet", "sit", "consectetur", "placeholder", "adipiscing",
									"Lorem"}).forEach(test::addNote);
		System.out.println(test.numberOfNotes() == 9);
		System.out.println(!test.addNote("Lorem"));
		System.out.println(test.getNote(5).equals("consectetur"));
		test.moveNoteUp("sit");
		test.deleteNote("placeholder");
		System.out.println(test.numberOfNotes() == 8);
		test.moveToBottom("elit");
		test.moveToTop("Lorem");
		System.out.println(test.toString().equals("Lorem\nipsum\ndolor\nsit\namet\nconsectetur\nadipiscing\nelit"));
	}
}
