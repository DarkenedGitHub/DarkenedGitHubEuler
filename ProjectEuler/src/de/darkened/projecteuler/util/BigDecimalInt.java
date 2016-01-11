package de.darkened.projecteuler.util;

import java.util.Arrays;

public class BigDecimalInt {
	
	private static final int BASE = 10;
	private static final int DIGITS_PER_PART = 5;
	private static final int MODULO = (int) Math.pow(BASE, DIGITS_PER_PART);
	private static final String PART_FORMATSTRING = "_%0" + DIGITS_PER_PART + "d";
	
	private int[] parts; // from lower to upper
	
	public BigDecimalInt(String digits) {
		parts = new int[(int) Math.ceil(digits.length() / (double) DIGITS_PER_PART)];
		for (int partIndex = 0; partIndex < parts.length; partIndex++) {
			int partOffset = digits.length() - (partIndex + 1) * DIGITS_PER_PART;
			parts[partIndex] = 0;
			for (int subIndex = 0; subIndex < DIGITS_PER_PART; subIndex++) {
				int digitIndex = partOffset + subIndex;
				if (digitIndex >= 0) {
					int digitValue = Integer.valueOf(digits.substring(digitIndex, digitIndex + 1));
					parts[partIndex] = parts[partIndex] * BASE + digitValue;
				}
			}
		}
	}
	
	public BigDecimalInt(int x) {
		this(String.valueOf(x));
	}
	
	private BigDecimalInt(int[] _parts) {
		parts = _parts;
	}
	
	public BigDecimalInt add(BigDecimalInt other) {
		int maxLength = Math.max(parts.length, other.parts.length);
		int[] sumParts = new int[maxLength];
		int overflow = 0;
		for (int i = 0; i < maxLength; i++) {
			int partSum = overflow;
			if (i < parts.length) {
				partSum += parts[i];
			}
			if (i < other.parts.length) {
				partSum += other.parts[i];
			}
			overflow = partSum / MODULO;
			sumParts[i] = partSum % MODULO; 
		}
		if (overflow > 0) {
			sumParts = Arrays.copyOf(sumParts, maxLength + 1);
			sumParts[maxLength] = overflow;
		}
		return new BigDecimalInt(sumParts);
	}
	
	public BigDecimalInt multiply(int factor) {
	    int maxLength = parts.length + (int) Math.ceil(Math.log(factor) / Math.log(MODULO));
	    int[] productParts = new int[maxLength];
	    long overflow = 0;
	    for (int i = 0; i < parts.length; i++) {
	        overflow += parts[i] * factor;
	        productParts[i] = (int) (overflow % MODULO);
	        overflow /= (long) MODULO;
	    }
	    int expandedIndex = parts.length;
	    while (overflow > 0L) {
            productParts[expandedIndex] = (int) (overflow % MODULO);
            overflow /= (long) MODULO;
            expandedIndex++;
	    }
	    return new BigDecimalInt(productParts);
	}
	
	public int[] toDigits() {
		int leadingZeros = 0;
		for (int leadingPart = parts[parts.length - 1]; leadingPart > 0; leadingPart /= BASE) {
			leadingZeros++;
		}
		int digitCount = parts.length * DIGITS_PER_PART - leadingZeros;
		int[] digits = new int[digitCount];
		for (int partIndex = 0; partIndex < parts.length; partIndex++) {
			int partValue = parts[partIndex];
			int digitReverseIndex = partIndex * DIGITS_PER_PART;
			while (partValue > 0) {
				digits[digitCount - digitReverseIndex - 1] = partValue % BASE;
				digitReverseIndex++;
				partValue /= BASE;
			}
		}
		return digits;
	}
	
	public int getDigitCount() {
		return (parts.length - 1) * DIGITS_PER_PART + (int) (Math.ceil(Math.log(parts[parts.length - 1]) / Math.log(10)));
	}
		
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int partIndex = 0; partIndex < parts.length; partIndex++) {
			sb.insert(0, String.format(partIndex < parts.length - 1 ? PART_FORMATSTRING : "%d", parts[partIndex]));
		}
		return sb.toString();
	}

}
