package zodiac;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

/**
 * <em>"Driver class"</em> for the Zodiac project. Completed
 * 2017&middot;09&middot;17.
 * 
 * @author mdr Matt Rabitsky (OOPDA&sect;6)
 */
public class Main {
	private static final Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println(ZodiacTable.determineSign(getBirthday()));
		System.out.println("\nZodiac calendar for 2017:");
		ZodiacTable.displaySigns();
	}

	/**
	 * Recursive error-handled method for getting user birthday.
	 * 
	 * @return birthday as entered by user (YYYY/MM/DD format)
	 */
	private static LocalDate getBirthday() {
		System.out.println("Enter your birthday (YYYY/MM/DD): ");
		try {
			Integer[] arr = Arrays.stream(in.nextLine().split("/")).map(Integer::parseInt).toArray(Integer[]::new);
			return LocalDate.of(arr[0], arr[1], arr[2]);
		} catch (NumberFormatException nfe) {
			System.err.println(
					"Hmm, that doesn't look like a number date. Check to make sure you input your birthday correctly!");
			return getBirthday();
		} catch (DateTimeException dte) {
			System.err.println(
					"Oops, it doesn't look like that date was formatted correctly!\nMake sure you are putting the date in in the format YYYY/MM/DD...");
			return getBirthday();
		}
	}
}
