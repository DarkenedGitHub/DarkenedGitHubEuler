package de.darkened.projecteuler.util;

public class AbundantSieve extends AbstractSieve {

	private DivisorFinder divisorFinder = new DivisorFinder();

	public AbundantSieve(int maxExclusive) {
		super(maxExclusive, false);
	}

	@Override
	protected boolean processValue(int x, boolean lookupValue) {
		int divisorSum = divisorFinder.getDivisorSum(x);
		if (divisorSum >= x) { // fill for perfect numbers too
			fillMultiples(x);
			return divisorSum > x;
		} else {
			return false;
		}
	}

}
