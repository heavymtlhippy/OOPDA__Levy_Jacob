package university;
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * University project (with associated Lab4 comment). Completed
 * 2017&middot;09&middot;26.
 * 
 * @author mdr Matt Rabitsky (&sect;3)
 */
public class PersonApp {
	private static final Scanner in = new Scanner(System.in);
	private static final Logger logger=Logger.getGlobal();
	private static final Predicate<String> TAUTOLOGY = (t) -> true;

	public static void main(String[] args) {
		final HashMap<String, Person> whyAHashMap = new HashMap<String, Person>();

		System.out.println("Enter the following details for the person:\n");
		final Person test = new Person(
				input("Age:", Integer::parseInt, Person::validateAge),
				input("Email:", Function.identity(), Person::validateEmail),
				input("First name:", Function.identity(), TAUTOLOGY),
				input("Middle name:", Function.identity(), TAUTOLOGY),
				input("Last name:", Function.identity(), TAUTOLOGY),
				input("SSN (XXX-XX-XXXX):", Function.identity(), Person::validateSsn)
				);
		final Instructor profLevy = new Instructor(33, "levyj63@rowan.edu",
				"Jacob", "Ross", "Levy", "100-20-3000", "Computer Science");
		final Student mdr = new Student(18, "rabitskym6@students.rowan.edu", "M", "D", "R",
				"400-50-6000", "Computer Science");

		whyAHashMap.put("User", test);
		whyAHashMap.put("Professor", profLevy);
		whyAHashMap.put("Student", mdr);

		whyAHashMap.values().stream().forEach((x) -> {
			System.out.println(
					"\n" + String.format("%s : %s", x.toString(), x.getClass().getSimpleName()));
			System.out.println(x.getEmailDomain());
			System.out.println(x.getLast4Ssn());
			System.out.println(x.getAge()==Person.getOldest()?"Oldest":"Not oldest");
			System.out.println((x instanceof Instructor)
					? ((Instructor) x).getDepartment()
						: (x instanceof Student) ? ((Student) x).getMajour() : x.getId());
		});

		/*
		 * So, I'm not too sure why we're using a HashMap here instead of just a list (I
		 * wasn't really sure what the keys were supposed to be so I just put
		 * indentifiers in); but, I figured looping over the values of the map and then
		 * printing the desired information for each would be a good way to get part 7
		 * done. I just checked each value with an `instanceof` operator, and then
		 * coerced it to the appropriate subclass (`Student <: Person`, `Instructor <:
		 * Person`).
		 */
	}

	private static <T> T input(String prompt, Function<String, T> mapper, Predicate<T> validator) {
		System.out.println(prompt);
		T output = mapper.apply(in.nextLine());
		
		try { // uses System.out instead of System.err to ensure synchronicity of messages
			if (validator.test(output)) return output;
			else {
				logger.log(Level.WARNING, "Bad input");
				System.out.println("Oops, that doesn't look like a valid "
						+ (prompt.toLowerCase().substring(0, prompt.length() - 1)) + "...");
				return input(prompt, mapper, validator);
			}
		} catch (Exception e) {
			logger.log(Level.WARNING, "Bad input", e.getCause());
			System.out.println("Hmm, I didn't quite catch that...");
			return input(prompt, mapper, validator);
		}
	}
}
