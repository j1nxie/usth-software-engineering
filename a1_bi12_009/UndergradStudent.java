package a1_bi12_009;

import utils.AttrRef;
import utils.DomainConstraint;
import utils.NotPossibleException;

public class UndergradStudent extends Student {
	@DomainConstraint(type = "int", mutable = false, optional = false, min = 10000, max = 10000000)
	private int id;

	public UndergradStudent(@AttrRef("id") int id, @AttrRef("name") String name,
			@AttrRef("phoneNumber") String phoneNumber, @AttrRef("address") String address)
			throws NotPossibleException {
		if (!validateId(id)) {
			throw new NotPossibleException("invalid id: " + id);
		}

		if (!validateName(name)) {
			throw new NotPossibleException("invalid name: " + name);
		}

		if (!validatePhoneNumber(phoneNumber)) {
			throw new NotPossibleException("invalid phone number: " + phoneNumber);
		}

		if (!validateAddress(address)) {
			throw new NotPossibleException("invalid address: " + address);
		}

		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	private validateId(int id) {
		if (id < 10000 || id > 10000000) {
			return false;
		}

		return true;
	}
}
