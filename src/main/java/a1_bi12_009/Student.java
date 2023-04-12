package a1_bi12_009;

import utils.AttrRef;
import utils.DOpt;
import utils.DomainConstraint;
import utils.NotPossibleException;
import utils.OptType;

public class Student implements Comparable<Student> {
	@DomainConstraint(type = "int", mutable = false, optional = false, min = 1, max = 1000000000)
	protected int id;

	@DomainConstraint(type = "String", mutable = true, optional = false, length = 50)
	protected String name;

	@DomainConstraint(type = "String", mutable = true, optional = false, length = 10)
	protected String phoneNumber;

	@DomainConstraint(type = "String", mutable = true, optional = false, length = 100)
	protected String address;

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
	public void setName(String name) throws NotPossibleException {
		if (!validateName(name)) {
			throw new NotPossibleException("invalid name: " + name);
		}

		this.name = name;
	}

	@DOpt(type = OptType.Mutator)
	@AttrRef("phoneNumber")
	public void setPhoneNumber(String phoneNumber) throws NotPossibleException {
		if (!validatePhoneNumber(phoneNumber)) {
			throw new NotPossibleException("invalid phone number: " + phoneNumber);
		}

		this.phoneNumber = phoneNumber;
	}

	@DOpt(type = OptType.Mutator)
	@AttrRef("address")
	public void setAddress(String address) throws NotPossibleException {
		if (!validateAddress(address)) {
			throw new NotPossibleException("invalid address: " + address);
		}

		this.address = address;
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

	@Override
	public int compareTo(Student other) {
		return this.name.compareTo(other.name);
	}
}