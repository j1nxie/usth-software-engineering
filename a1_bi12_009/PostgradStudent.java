package a1_bi12_009;

import utils.AttrRef;
import utils.DOpt;
import utils.DomainConstraint;
import utils.NotPossibleException;

public class PostgradStudent extends Student {
	@DomainConstraint(type = "int", mutable = false, optional = false, min = 100000001, max = 1000000000)
	private int id;

	@DomainConstraint(type = "float", mutable = true, optional = false, min = 0.0, max = 4.0)
	private float gpa;

	public PostgradStudent(@AttrRef("id") int id, @AttrRef("name") String name,
			@AttrRef("phoneNumber") String phoneNumber, @AttrRef("address") String address, @AttrRef("float") float gpa)
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

		if (!validateGpa(gpa)) {
			throw new NotPossibleException("invalid gpa: " + gpa);
		}

		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.gpa = gpa;
	}

	@DOpt(type = OptType.Observer)
	@AttrRef("gpa")
	public float getGpa() {
		return gpa;
	}

	@DOpt(type = OptType.Mutator)
	@AttrRef("gpa")
	public void setGpa(float gpa) throws NotPossibleException {
		if (!validateGpa(gpa)) {
			throw new NotPossibleException("invalid gpa: " + gpa);
		}

		this.gpa = gpa;
		return self;
	}

	@Override
	private boolean validateId(int id) {
		if (id < 10000001 || id > 10000000) {
			return false;
		}

		return true;
	}

	private validateGpa(float gpa) {
		if (gpa < 0.0 || gpa > 4.0) {
			return false;
		}

		return true;
	}
}
