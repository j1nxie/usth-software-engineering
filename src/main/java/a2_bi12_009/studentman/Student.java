package a2_bi12_009.studentman;

import utils.AttrRef;
import utils.DOpt;
import utils.DomainConstraint;
import utils.NotPossibleException;
import utils.OptType;

// @formatter:off
/**
 * @overview
 *  A student of an university, with two subclasses: UndergradStudent
 *  and PostgradStudent.
 *
 * @attributes
 *  id            int
 *  name          String
 *  phoneNumber   String
 *  address       String
 *
 * @object
 *  An object is of form <pre>s = <i, n, p, a></pre>, where
 *  <pre>id (i), name (n), phoneNumber (p), address (a)</pre>.
 *
 * @abstract_properties
 *  mutable(id) = false | optional(id) = false | min(id) = 1 | max(id) = 1000000000
 *  mutable(name) = true | optional(name) = false | length(name) = 50
 *  mutable(phoneNumber) = true | optional(phoneNumber) = false | length(phoneNumber) = 10
 *  mutable(address) = true | optional(address) = false | length(address) = 100
 *
 * @author BI12-009 Nguyen Pham Quoc An
 */
// @formatter:on
public class Student implements Comparable<Student>, Document {
	@DomainConstraint(type = "int", mutable = false, optional = false, min = 1, max = 1000000000)
	private int id;

	@DomainConstraint(type = "String", mutable = true, optional = false, length = 50)
	private String name;

	@DomainConstraint(type = "String", mutable = true, optional = false, length = 10)
	private String phoneNumber;

	@DomainConstraint(type = "String", mutable = true, optional = false, length = 100)
	private String address;

	// @formatter:off
	/**
	 * @effects
	 *  <pre>
	 *    if id, name, phoneNumber and address are valid
	 *      initialize as <id, name, phoneNumber, address>
	 *    else
	 *      throw NotPossibleException
	 *  </pre>
	 */
	// @formatter:on
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

	// @formatter:off
	/**
	 * @effects
	 *  <pre>
	 *    return <tt>id</tt>
	 *  </pre>
	 */
	// @formatter:on
	@DOpt(type = OptType.Observer)
	@AttrRef("id")
	public int getId() {
		return id;
	}

	// @formatter:off
	/**
	 * @effects
	 *  <pre>
	 *    return <tt>name</tt>
	 *  </pre>
	 */
	// @formatter:on
	@DOpt(type = OptType.Observer)
	@AttrRef("name")
	public String getName() {
		return name;
	}

	// @formatter:off
	/**
	 * @effects
	 *  <pre>
	 *    return <tt>phoneNumber</tt>
	 *  </pre>
	 */
	// @formatter:on
	@DOpt(type = OptType.Observer)
	@AttrRef("phoneNumber")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	// @formatter:off
	/**
	 * @effects
	 *  <pre>
	 *    return <tt>address</tt>
	 *  </pre>
	 */
	// @formatter:on
	@DOpt(type = OptType.Observer)
	@AttrRef("address")
	public String getAddress() {
		return address;
	}

	// @formatter:off
	/**
	 * @effects
	 *  <pre>
	 *    if name is not valid
	 *      return false
	 *    else
	 *      this.name = name
	 *      return true
	 *  </pre>
	 */
	// @formatter:on
	@DOpt(type = OptType.Mutator)
	@AttrRef("name")
	public boolean setName(String name) {
		if (!validateName(name)) {
			return false;
		}

		this.name = name;
		return true;
	}

	// @formatter:off
	/**
	 * @effects
	 *  <pre>
	 *    if phoneNumber is not valid
	 *      return false
	 *    else
	 *      this.phoneNumber = phoneNumber
	 *      return true
	 *  </pre>
	 */
	// @formatter:on
	@DOpt(type = OptType.Mutator)
	@AttrRef("phoneNumber")
	public boolean setPhoneNumber(String phoneNumber) {
		if (!validatePhoneNumber(phoneNumber)) {
			return false;
		}

		this.phoneNumber = phoneNumber;
		return true;
	}

	// @formatter:off
	/**
	 * @effects
	 *  <pre>
	 *    if address is not valid
	 *      return false
	 *    else
	 *      this.address = address
	 *      return true
	 *  </pre>
	 */
	// @formatter:on
	@DOpt(type = OptType.Mutator)
	@AttrRef("address")
	public boolean setAddress(String address) {
		if (!validateAddress(address)) {
			return false;
		}

		this.address = address;
		return true;
	}

	// @formatter:off
	/**
	 * @effects
	 *  <pre>
	 *    if id is valid
	 *      return true
	 *    else
	 *      return false
	 *  </pre>
	 */
	// @formatter:on
	protected boolean validateId(int id) {
		if (id < 1 || id > 1000000000) {
			return false;
		}

		return true;
	}

	// @formatter:off
	/**
	 * @effects
	 *  <pre>
	 *    if name is valid
	 *      return true
	 *    else
	 *      return false
	 *  </pre>
	 */
	// @formatter:on
	protected boolean validateName(String name) {
		if (name.length() > 50) {
			return false;
		}

		return true;
	}

	// @formatter:off
	/**
	 * @effects
	 *  <pre>
	 *    if phoneNumber is valid
	 *      return true
	 *    else
	 *      return false
	 *  </pre>
	 */
	// @formatter:on
	protected boolean validatePhoneNumber(String phoneNumber) {
		if (phoneNumber.length() > 10) {
			return false;
		}

		return true;
	}

	// @formatter:off
	/**
	 * @effects
	 *  <pre>
	 *    if address is valid
	 *      return true
	 *    else
	 *      return false
	 *  </pre>
	 */
	// @formatter:on
	protected boolean validateAddress(String address) {
		if (address.length() > 100) {
			return false;
		}

		return true;
	}

	// @formatter:off
	/**
	 * @effects
	 *  <pre>
	 *    if everything is valid w.r.t. abstract properties
	 *      return true
	 *    else
	 *      return false
	 *  </pre>
	 */
	// @formatter:on
	public boolean repOK() {
		return validateId(id) && validateName(name) && validatePhoneNumber(phoneNumber) && validateAddress(address);
	}

	// @formatter:off
	/**
	 * @effects
	 *  <pre>
	 *    if other is null
	 *      throw NullPointerException
	 *    else
	 *      return this.name.compareTo(other.name)
	 *  </pre>
	 */
	// @formatter:on
	@Override
	public int compareTo(Student other) throws NullPointerException {
		if (other == null) {
			throw new NullPointerException("null pointer exception lol");
		}
		return this.name.compareTo(other.name);
	}

	@Override
	public String toString() {
		return String.format("- ID: %d\n-Name: %s\n- Phone number: %s\n- Address: %s", id, name, phoneNumber, address);
	}

	/**
	 * @effects
	 * 
	 *          <pre>
	 * return a HTML string representation of a student
	 *          </pre>
	 */
	@Override
	@DOpt(type = OptType.Default)
	public String toHtmlDoc() {
		return "<html>\n" +
				"<head><title>Student:" + id + "-" + "name" + "</title></head>\n" +
				"<body>\n" +
				id + " " + name + " " + phoneNumber + " " + address + "\n" +
				"</body></html>";
	}
}
