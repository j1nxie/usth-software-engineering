package tutorial_01;

import utils.NotPossibleException;

import java.util.Set;

public class EvenIntSet {
	private Set<Integer> set;

	public Set<Integer> getSet() {
		return set;
	}

	public void addToSet(int i) throws NotPossibleException {
		if (i % 2 != 0) {
			throw new NotPossibleException("number must be even!");
		}

		this.set.add(i);
	}
}
