package zodiac;
import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.util.Arrays;

/**
 * Utility representation of the 12 zodiac signs of Western Astrology.
 * 
 * @author mdr Matt Rabitsky (OOPDA&sect;6)
 */
public final class ZodiacTable {
	private ZodiacTable() {} // suppress default constructor for noninstantiability

	/**
	 * Checks for the sign whose start and end dates <code>date</code> falls
	 * between.
	 * 
	 * @param date determines under which sign this date falls
	 * @return zodiac sign under which the given sign falls
	 */
	public static String determineSign(LocalDate date) {
		return Arrays.stream(ZodiacSign.values()).filter(x -> {
			final MonthDay y = MonthDay.from(date);
			return (x.getStart().isBefore(y) && x.getEnd().isAfter(y)) || x.getStart().compareTo(y) == 0
					|| x.getEnd().compareTo(y) == 0;
		}).findFirst().get().toString();
	}
	/**
	 * Prints all zodiac signs to the <code>STDOUT</code>.
	 */
	public static void displaySigns() {
		Arrays.stream(ZodiacSign.values()).forEach(System.out::println);
	}
	
	@SuppressWarnings("unused")
	private static enum ZodiacSign {
		ARIES("Aries", '♈', MonthDay.of(Month.MARCH, 21), MonthDay.of(Month.APRIL, 19)), 
		TAURUS("Taurus", '♉', MonthDay.of(Month.APRIL, 20), MonthDay.of(Month.MAY, 20)),
		GEMENI("Gemeni", '♊', MonthDay.of(Month.MAY, 21), MonthDay.of(Month.JUNE, 20)),
		CANCER("Cancer", '♋', MonthDay.of(Month.JUNE, 21), MonthDay.of(Month.JULY, 22)),
		LEO("Leo", '♌', MonthDay.of(Month.JULY, 23), MonthDay.of(Month.AUGUST, 22)),
		VIRGO("Virgo", '♍', MonthDay.of(Month.AUGUST, 23), MonthDay.of(Month.SEPTEMBER, 22)),
		LIBRA("Libra", '♎', MonthDay.of(Month.SEPTEMBER, 23), MonthDay.of(Month.OCTOBER, 22)),
		SCORPIO("Scorpio", '♏', MonthDay.of(Month.OCTOBER, 23), MonthDay.of(Month.NOVEMBER, 21)),
		SAGITTARIUS("Sagittarius", '♐', MonthDay.of(Month.NOVEMBER, 22), MonthDay.of(Month.DECEMBER, 21)),
		CAPRICORN("Capricorn", '♑', MonthDay.of(Month.DECEMBER, 22), MonthDay.of(Month.JANUARY, 19)),
		AQUARIUS("Aquarius", '♒', MonthDay.of(Month.JANUARY, 20), MonthDay.of(Month.FEBRUARY, 18)),
		PISCES("Pisces", '♓', MonthDay.of(Month.FEBRUARY, 19), MonthDay.of(Month.MARCH, 20));

		private final MonthDay start, end;
		private final String name;
		private final char sign;
		
		private ZodiacSign(final String name, final char sign, final MonthDay start, final MonthDay end) {
			this.name=name;
			this.sign=sign;
			this.start=start;
			this.end=end;
		}

		public MonthDay getEnd() {
			return end;
		}
		public String getName() {
			return name;
		}
		public char getSign() {
			return sign;
		}
		public MonthDay getStart() {
			return start;
		}
		@Override
		public String toString() {
			return String.format("%s (%c) [%3$tb %3$te - %4$tb %4$te]", name, sign, start, end);
		}
	}
}
