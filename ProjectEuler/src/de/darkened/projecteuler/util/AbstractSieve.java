package de.darkened.projecteuler.util;

import java.util.Arrays;

public abstract class AbstractSieve {
	
	private static final int SIEVE_SIZE = 1000000;
	
	private boolean[] values;
	private int maxCheckedValue = 0;
	private boolean initialValue = false;
	private int fillStepWidth = 1;
	
	public AbstractSieve(boolean _initialValue) {
		this(SIEVE_SIZE, _initialValue);
	}

	public AbstractSieve(int maxExclusive, boolean _initialValue) {
		values = new boolean[maxExclusive];
		initialValue = _initialValue;
		if (initialValue) {
			Arrays.fill(values, true);
		}
	}
	
	public void fill() {
		fill(values.length - 1);
	}
	
	protected final void setFillStepWidth(int _fillStepWidth) {
		fillStepWidth = _fillStepWidth;
	}
	
	protected final void fillMultiples(int value) {
		for (int multiple = value * 2; multiple < values.length; multiple += value) {
			values[multiple] = !initialValue;
		}
	}
	
	private void fill(int bound) {
		for (int i = maxCheckedValue + 1; i <= bound; i += fillStepWidth) {
			values[i] = processValue(i, values[i]);
		}
		maxCheckedValue = bound;
	}
	
	// override this for more complex logic
	protected abstract boolean processValue(int x, boolean lookupValue);
	
	public boolean isValid(int x) {
		if (x >= values.length) {
			throw new IllegalArgumentException();
		}
		if (x > maxCheckedValue) {
			fill(x);
		}
		return values[x];
	}
	
}
