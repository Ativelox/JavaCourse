package formatsi;

import static formatsi.Util.log;

public class Format {

	/**
	 * The maximum exponent representable with SI-symbols.
	 */
	public static final int SI_SYMBOL_MAX_EXP = 24 + 2;

	/**
	 * Return a human-friendly, SI-based representation of a physical measure.
	 *
	 * If possible, the result is formatted as a number rounded to three digits
	 * before and one digit after the decimal point, followed by the matching
	 * SI-symbol and the SI-unit. E.g. formatSI(1000, "g") returns "1.0kg". If
	 * the measure is not zero, there are no leading zeros before the decimal
	 * point. Also, there is always exactly one digit after the decimal point.
	 *
	 * If the result is not representable with SI-symbols as described above, it
	 * is formatted as a scientific floating point number, rounded to three
	 * digits after the decimal point, and followed by the SI-unit.
	 *
	 * @param x
	 *            The amount of the measure.
	 * @param unit
	 *            The SI-unit of the measure.
	 * @return The formatted result.
	 */
	public static String formatSI(double x, String unit) {
		if (x == 0) {
			log("formatSI:zero");
			return "0.0" + unit;
		}

		// the exponent of x, i.e. the number of digits before the decimal
		// point.
		int l = (int) Math.floor(Math.log10(Math.abs(x)));

		// x not representable with SI-symbol
		if (Math.abs(l) > SI_SYMBOL_MAX_EXP) {
			log("formatSI:no-fit:" + (l >= 0));
			return String.format("%.3E" + unit, Double.valueOf(x));
		}

		// get the unit
		String bigSymbols = " kMGTPEZY";
		String littleSymbols = "mµnpfazy";
		String siSymbol;
		int shift; // the shift for x s.t. there are three digits before the
					// decimal point
		if (l <= 0) {
			log("formatSI:smaller-1");
			siSymbol = "" + littleSymbols.charAt(Math.abs(l / 3));
			shift = -l + (3 - Math.abs(l) % 3);
		} else { // l > 0
			log("formatSI:bigger-1");
			int siIndex = Math.abs(l / 3);
			if (siIndex == 0) {
				log("formatSI:no-symbol");
				siSymbol = "";
			} else {
				log("formatSI:symbol");
				siSymbol = "" + bigSymbols.charAt(siIndex);
			}
			shift = -l + (l % 3);
		}

		double n = x * Math.pow(10, shift);
		String str = String.format("%.1f", Double.valueOf(n));

		return str + siSymbol + unit;
	}
}
