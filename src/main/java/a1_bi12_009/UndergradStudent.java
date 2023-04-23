package a1_bi12_009;

import utils.AttrRef;
import utils.NotPossibleException;

public class UndergradStudent extends Student {
	public UndergradStudent(@AttrRef("id") int id, @AttrRef("name") String name,
			@AttrRef("phoneNumber") String phoneNumber, @AttrRef("address") String address)
			throws NotPossibleException {
		super(id, name, phoneNumber, address);
	}

	@Override
	protected boolean validateId(int id) {
		if (id < 10000 || id > 10000000) {
			return false;
		}

		return true;
	}
}
