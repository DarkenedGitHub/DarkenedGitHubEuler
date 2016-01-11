package de.darkened.projecteuler.util;

public class PrimeSieve extends AbstractSieve {

	public PrimeSieve() {
		super(true);
	}

	public PrimeSieve(int maxExclusive) {
		super(maxExclusive, true);
	}

	@Override
	protected boolean processValue(int x, boolean lookupValue) {
		if (x == 1) {
			return false;
		} else {
			if (x == 3) {
				setFillStepWidth(2);
			}
			fillMultiples(x);
			return lookupValue;
		}
	}

}
