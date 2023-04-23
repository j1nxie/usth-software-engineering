package a1_bi12_009;

import utils.AttrRef;
import utils.DOpt;
import utils.DomainConstraint;
import utils.NotPossibleException;
import utils.OptType;

public class PostgradStudent extends Student {
	@DomainConstraint(type = "float", mutable = true, optional = false, min = 0.0, max = 4.0)
	protected float gpa;

	public PostgradStudent(@AttrRef("id") int id, @AttrRef("name") String name,
			@AttrRef("phoneNumber") String phoneNumber, @AttrRef("address") String address, @AttrRef("float") float gpa)
			throws NotPossibleException {
		super(id, name, phoneNumber, address);

		if (!validateGpa(gpa)) {
			throw new NotPossibleException("invalid gpa: " + gpa);
		}

		this.gpa = gpa;
	}

	@DOpt(type = OptType.Observer)
	@AttrRef("gpa")
	public float getGpa() {
		return gpa;
	}

	@DOpt(type = OptType.Mutator)
	@AttrRef("gpa")
	public boolean setGpa(float gpa) {
		if (!validateGpa(gpa)) {
			return false;
		}

		this.gpa = gpa;
		return true;
	}

	@Override
	protected boolean validateId(int id) {
		if (id < 100000001 || id > 1000000000) {
			return false;
		}

		return true;
	}

	private boolean validateGpa(float gpa) {
		if (gpa < 0.0 || gpa > 4.0) {
			return false;
		}

		return true;
	}

	@Override
	public String toString() {
		return String.format("- ID: %d\n-Name: %s\n- Phone number: %s\n- Address: %s\n- GPA: %f", this.getId(),
				this.getName(),
				this.getPhoneNumber(), this.getAddress(), gpa);
	}
}
