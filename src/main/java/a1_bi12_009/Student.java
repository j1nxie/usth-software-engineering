package a1_bi12_009;

import utils.AttrRef;
import utils.DOpt;
import utils.DomainConstraint;
import utils.NotPossibleException;
import utils.OptType;

public class Student implements Comparable<Student> {
	@DomainConstraint(type = "int", mutable = false, optional = false, min = 1, max = 100000000)
	private int id;

	@DomainConstraint(type = "String", mutable = true, optional = false, length = 50)
	private String name;

	@DomainConstraint(type = "String", mutable = true, optional = false, length = 10)
	private String phoneNumber;

	@DomainConstraint(type = "String", mutable = true, optional = false, length = 100)
	private String address;

	public Student(@AttrRef("id") int id, @AttrRef("name") String name, @AttrRef("phoneNumber") String phoneNumber,
			@AttrRef("address") String address) throws NotPossibleException {

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
	@AttrRef("phoneNumber")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	@DOpt(type = OptType.Observer)
	@AttrRef("address")
	public String getAddress() {
		return address;
	}

	@DOpt(type = OptType.Mutator)
	@AttrRef("name")
	public boolean setName(String name) {
		if (!validateName(name)) {
			return false;
		}

		this.name = name;
		return true;
	}

	@DOpt(type = OptType.Mutator)
	@AttrRef("phoneNumber")
	public boolean setPhoneNumber(String phoneNumber) {
		if (!validatePhoneNumber(phoneNumber)) {
			return false;
		}

		this.phoneNumber = phoneNumber;
		return true;
	}

	@DOpt(type = OptType.Mutator)
	@AttrRef("address")
	public boolean setAddress(String address) {
		if (!validateAddress(address)) {
			return false;
		}

		this.address = address;
		return true;
	}

	protected boolean validateId(int id) {
		if (id < 1 || id > 1000000000) {
			return false;
		}

		return true;
	}

	protected boolean validateName(String name) {
		if (name.length() > 50) {
			return false;
		}

		return true;
	}

	protected boolean validatePhoneNumber(String phoneNumber) {
		if (phoneNumber.length() > 10) {
			return false;
		}

		return true;
	}

	protected boolean validateAddress(String address) {
		if (address.length() > 100) {
			return false;
		}

		return true;
	}

	public boolean repOK() {
		return validateId(id) && validateName(name) && validatePhoneNumber(phoneNumber) && validateAddress(address);
	}

	@Override
	public int compareTo(Student other) {
		return this.name.compareTo(other.name);
	}
}
