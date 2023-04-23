package tutorial_01;

import utils.AttrRef;
import utils.DOpt;
import utils.DomainConstraint;
import utils.NotPossibleException;
import utils.OptType;

public class Person {
	@DomainConstraint(type = "int", mutable = false, optional = false, min = 1)
	private int id;

	@DomainConstraint(type = "String", mutable = true, optional = false, length = 30)
	private String name;

	@DomainConstraint(type = "MobilePhone", mutable = true, optional = true)
	private MobilePhone phone;

	public Person(@AttrRef("id") int id, @AttrRef("name") String name) throws NotPossibleException {
		if (!validateId(id)) {
			throw new NotPossibleException("invalid id for person: " + id);
		}

		if (!validateName(name)) {
			throw new NotPossibleException("invalid name for person: " + name);
		}

		this.id = id;
		this.name = name;
	}

	@DOpt(type = OptType.Observer)
	@AttrRef("id")
	public int getId() {
		return id;
	}

	@DOpt(type = OptType.Observer)
	@AttrRef("name")
	public String getName() {
		return name;
	}

	@DOpt(type = OptType.Observer)
	@AttrRef("phone")
	public MobilePhone getPhone() {
		return phone;
	}

	@DOpt(type = OptType.Mutator)
	@AttrRef("name")
	public void setName(String name) throws NotPossibleException {
		if (!validateName(name)) {
			throw new NotPossibleException("invalid name for person: " + name);
		}
		this.name = name;
	}

	@DOpt(type = OptType.Mutator)
	@AttrRef("phone")
	public void setPhone(MobilePhone phone) {
		this.phone = phone;
	}

	public String greet() {
		return "Hello " + name + "!";
	}

	private boolean validateId(int id) {
		if (id < 1) {
			return false;
		}

		return true;
	}

	private boolean validateName(String name) {
		if (name == null || name.length() == 0 || name.length() > 30 || !name.matches("^[a-zA-Z]+(?:\\s[a-zA-Z]+)+$")) {
			return false;
		}

		return true;
	}
}
