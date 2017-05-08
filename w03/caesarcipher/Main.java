package caesarcipher;

/**
 * Utility class providing a method to encode given String inputs with the
 * caesar cipher.
 *
 * @author Ativelox {@literal <ativelox.dev@web.de>}
 *
 * @see Main#encode(String, int)
 *
 */
public class Main {

	/**
	 * Encodes the given String by the shift given. Implementation of the all
	 * known caesar cipher.
	 * 
	 * @param mInput
	 *            The input to be encoded.
	 * @param mShift
	 *            The shift by which the input should be shifted.
	 * 
	 * @return The encoded string
	 */
	public static String encode(final String mInput, final int mShift) {

		// if the shift is negative return the initial input.
		if (mShift < 0) {
			return mInput;
		}

		// if there was no input return an empty string.
		if (mInput.length() <= 0) {
			return "";
		}

		// the string builder used to build the new String after encoding
		StringBuilder strBuilder = new StringBuilder();

		// iterate over every character in the string and encode it by the given
		// shift
		for (char c : mInput.toCharArray()) {
			// holds the first number of the interval the chars can be.
			int start = 'a';

			// holds the last number of the interval the chars can be.
			int end = 'z';

			// if the current char is upper case make sure to change the
			// interval so the upper case is preserved.
			if (Character.isUpperCase(c)) {
				start = 'A';
				end = 'Z';
			}

			// if the character is out of the given bounds don't shift it and
			// append it to the string is it is and start with the next
			// iteration.
			if (c < start || c > end) {
				strBuilder.append(c);
				continue;
			}

			// now shift the char by the given shift
			char shiftedChar = (char) (c + mShift);

			// if there's an overflow adjust the the char so it starts back from
			// the start of the interval accordingly.
			if (shiftedChar >= end) {
				shiftedChar = (char) ((shiftedChar % end) + (start - 1));
			}

			// finally append the shifted char to the final string.
			strBuilder.append(shiftedChar);

		}
		// return the result
		return strBuilder.toString();
	}

}
