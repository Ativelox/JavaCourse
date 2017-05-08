package timetowords;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * This class is able to read {@link Main#TIMES_TO_READ} times a time from the
 * systems input stream and convert it into the spoken expression of the time
 * given.
 * 
 * @author Ativelox {@literal <juliantischner27@web.de>}
 *
 */
public class Main {

	/**
	 * An integer constant holding the value of how many times to read. A time
	 * is defined by two integer values followed by each other, e.g. 5 51
	 */
	private static final int TIMES_TO_READ = 1;

	/**
	 * The maximum value of minutes.
	 */
	private static final int MAX_MINUTE_VALUE = 60;

	/**
	 * The minimum value of minutes.
	 */
	private static final int MIN_MINUTE_VALUE = 0;

	/**
	 * The maximum value of hours.
	 */
	private static final int MAX_HOUR_VALUE = 12;

	/**
	 * The minimum value of hours.
	 */
	private static final int MIN_HOUR_VALUE = 1;

	/**
	 * This classes main method.
	 * 
	 * @param args
	 *            The command-line arguments.
	 */
	public static void main(final String[] args) {

		try (final Scanner scan = new Scanner(System.in)) {
			for (int i = 0; i < TIMES_TO_READ; i++) {
				String hourAsString = "";
				String minuteAsString = "";
				try {
					hourAsString = scan.next();
					minuteAsString = scan.next();

				} catch (NoSuchElementException e) {
					System.out.println("Wrong Input");
					break;

				}
				try {
					int hour = Integer.parseInt(hourAsString);
					int minute = Integer.parseInt(minuteAsString);

					System.out.println(getExpressionByTime(hour, minute));

				} catch (NumberFormatException e) {
					System.out.println("Wrong Input");
				}

			}
		}

	}

	/**
	 * Gets the spoken expression of the current time as string.
	 * 
	 * @param mHour
	 *            The hour of the expression wanted.
	 * @param mMinute
	 *            The minute of the expression wanted.
	 * @return The expression mentioned above.
	 * 
	 * @see Main#getWordByValue(int)
	 */
	public static String getExpressionByTime(final int mHour, final int mMinute) {

		// given time wasn't in the requested format
		if (!((mHour >= MIN_HOUR_VALUE && mHour <= MAX_HOUR_VALUE)
				&& (mMinute >= MIN_MINUTE_VALUE && mMinute < MAX_MINUTE_VALUE))) {

			return "Wrong Input";
		}

		String hourFormat = getWordByValue(mHour);
		String minuteFormat = getWordByValue(mMinute);

		// from here on checks the current minute and uses the correct pattern
		// to display the message correctly.

		if (mMinute == MIN_MINUTE_VALUE) {
			return hourFormat + " o'clock";

		} else if (mMinute >= 1 && mMinute < 30) {
			if (mMinute == 1) {
				return minuteFormat + " minute past " + hourFormat;

			}
			if (mMinute == 15) {
				return "quarter past " + hourFormat;

			}
			return minuteFormat + " minutes past " + hourFormat;

		} else if (mMinute >= 30 && mMinute <= 45) {
			if (mMinute == 30) {
				return "half past " + hourFormat;

			}
			int minutesToFullHour = MAX_MINUTE_VALUE - mMinute;
			minuteFormat = getWordByValue(minutesToFullHour);
			if(mHour != 11){
				hourFormat = getWordByValue((mHour + 1) % 12);
				
			}else{
				hourFormat = getWordByValue(12);
				
			}

			if (mMinute == 45) {
				return "quarter to " + hourFormat;

			}
			return minuteFormat + " minutes to " + hourFormat;

		} else if (mMinute > 45 && mMinute < MAX_MINUTE_VALUE) {
			int minutesToFullHour = MAX_MINUTE_VALUE - mMinute;
			minuteFormat = getWordByValue(minutesToFullHour);
			if(mHour != 11){
				hourFormat = getWordByValue((mHour + 1) % 12);
				
			}else{
				hourFormat = getWordByValue(12);
				
			}
			if (minutesToFullHour == 1) {
				return minuteFormat + " minute to " + hourFormat;

			}
			return minuteFormat + " minutes to " + hourFormat;

		}
		return "Couldn't determine an appropriate pattern for the time given.";
	}

	/**
	 * Returns the written equivalent of the integer given, up to twenty nine
	 * (29).<br>
	 * 
	 * @see ETimeWords
	 * 
	 * @param mValue
	 *            The value of which to get the written equivalent of.
	 * @return The written equivalent of the value given or an empty string if
	 *         the value is greater than 29 or less than 1.
	 */
	public static String getWordByValue(final int mValue) {
		if (mValue == 1) {
			return ETimeWords.ONE.toString().toLowerCase();

		} else if (mValue == 2) {
			return ETimeWords.TWO.toString().toLowerCase();

		} else if (mValue == 3) {
			return ETimeWords.THREE.toString().toLowerCase();

		} else if (mValue == 4) {
			return ETimeWords.FOUR.toString().toLowerCase();

		} else if (mValue == 5) {
			return ETimeWords.FIVE.toString().toLowerCase();

		} else if (mValue == 6) {
			return ETimeWords.SIX.toString().toLowerCase();

		} else if (mValue == 7) {
			return ETimeWords.SEVEN.toString().toLowerCase();

		} else if (mValue == 8) {
			return ETimeWords.EIGHT.toString().toLowerCase();

		} else if (mValue == 9) {
			return ETimeWords.NINE.toString().toLowerCase();

		} else if (mValue == 10) {
			return ETimeWords.TEN.toString().toLowerCase();

		} else if (mValue == 11) {
			return ETimeWords.ELEVEN.toString().toLowerCase();

		} else if (mValue == 12) {
			return ETimeWords.TWELVE.toString().toLowerCase();

		} else if (mValue == 13) {
			return ETimeWords.THIRTEEN.toString().toLowerCase();

		} else if (mValue == 14) {
			return ETimeWords.FOURTEEN.toString().toLowerCase();

		} else if (mValue == 15) {
			return ETimeWords.FIFTEEN.toString().toLowerCase();

		} else if (mValue == 16) {
			return ETimeWords.SIXTEEN.toString().toLowerCase();

		} else if (mValue == 17) {
			return ETimeWords.SEVENTEEN.toString().toLowerCase();

		} else if (mValue == 18) {
			return ETimeWords.EIGHTEEN.toString().toLowerCase();

		} else if (mValue == 19) {
			return ETimeWords.NINETEEN.toString().toLowerCase();

		} else if (mValue == 20) {
			return ETimeWords.TWENTY.toString().toLowerCase();

		} else if (mValue == 21) {
			return ETimeWords.TWENTY_ONE.toString().toLowerCase().replace("_", " ");

		} else if (mValue == 22) {
			return ETimeWords.TWENTY_TWO.toString().toLowerCase().replace("_", " ");

		} else if (mValue == 23) {
			return ETimeWords.TWENTY_THREE.toString().toLowerCase().replace("_", " ");

		} else if (mValue == 24) {
			return ETimeWords.TWENTY_FOUR.toString().toLowerCase().replace("_", " ");

		} else if (mValue == 25) {
			return ETimeWords.TWENTY_FIVE.toString().toLowerCase().replace("_", " ");

		} else if (mValue == 26) {
			return ETimeWords.TWENTY_SIX.toString().toLowerCase().replace("_", " ");

		} else if (mValue == 27) {
			return ETimeWords.TWENTY_SEVEN.toString().toLowerCase().replace("_", " ");

		} else if (mValue == 28) {
			return ETimeWords.TWENTY_EIGHT.toString().toLowerCase().replace("_", " ");

		} else if (mValue == 29) {
			return ETimeWords.TWENTY_NINE.toString().toLowerCase().replace("_", " ");

		} else {
			return "";
		}

	}
}
