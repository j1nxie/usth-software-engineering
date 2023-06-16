package a2_bi12_009.studentman;

import utils.AttrRef;
import utils.DOpt;
import utils.DomainConstraint;
import utils.NotPossibleException;
import utils.OptType;

// @formatter:off
/**
 * @overview
 *  A subclass of Student.
 *
 * @attributes
 *  id            int
 *  name          String
 *  phoneNumber   String
 *  address       String
 *  gpa           float
 *
 * @object
 *  An object is of form <pre>s = <i, n, p, a, g></pre>, where
 *  <pre>id (i), name (n), phoneNumber (p), address (a), gpa (g)</pre>.
 *
 * @abstract_properties
 *  P_Student | min(id) = 100000001
 *  mutable(gpa) = true | optional(gpa) = false | min(gpa) = 0.0 | max(gpa) = 4.0
 *
 * @author BI12-009 Nguyen Pham Quoc An
 */
// @formatter:on
public class PostgradStudent extends Student {
	@DomainConstraint(type = "float", mutable = true, optional = false, min = 0.0, max = 4.0)
	protected float gpa;

	// @formatter:off
	/**
	 * @effects
	 *  <pre>
	 *    if id, name, phoneNumber, address and gpa are valid
	 *      initialize as <id, name, phoneNumber, address, gpa>
	 *    else
	 *      throw NotPossibleException
	 *  </pre>
	 */
	// @formatter:on
	public PostgradStudent(@AttrRef("id") int id, @AttrRef("name") String name,
			@AttrRef("phoneNumber") String phoneNumber, @AttrRef("address") String address, @AttrRef("float") float gpa)
			throws NotPossibleException {
		super(id, name, phoneNumber, address);

		if (!validateGpa(gpa)) {
			throw new NotPossibleException("invalid gpa: " + gpa);
		}

		this.gpa = gpa;
	}

	// @formatter:off
	/**
	 * @effects
	 *  <pre>
	 *    return <tt>gpa</tt>
	 *  </pre>
	 */
	// @formatter:on
	@DOpt(type = OptType.Observer)
	@AttrRef("gpa")
	public float getGpa() {
		return gpa;
	}

	// @formatter:off
	/**
	 * @effects
	 *  <pre>
	 *    if gpa is not valid
	 *      return false
	 *    else
	 *      this.gpa = gpa
	 *      return true
	 *  </pre>
	 */
	// @formatter:on
	@DOpt(type = OptType.Mutator)
	@AttrRef("gpa")
	public boolean setGpa(float gpa) {
		if (!validateGpa(gpa)) {
			return false;
		}

		this.gpa = gpa;
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
	@Override
	protected boolean validateId(int id) {
		if (id < 100000001 || id > 1000000000) {
			return false;
		}

		return true;
	}

	// @formatter:off
	/**
	 * @effects
	 *  <pre>
	 *    if gpa is valid
	 *      return true
	 *    else
	 *      return false
	 *  </pre>
	 */
	// @formatter:on
	private boolean validateGpa(float gpa) {
		if (gpa < 0.0 || gpa > 4.0) {
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
	@Override
	public boolean repOK() {
		return validateId(this.getId()) && validateName(this.getName()) && validatePhoneNumber(this.getPhoneNumber())
				&& validateAddress(this.getAddress()) && validateGpa(gpa);
	}

	@Override
	public String toString() {
		return String.format("- ID: %d\n-Name: %s\n- Phone number: %s\n- Address: %s\n- GPA: %f", this.getId(),
				this.getName(),
				this.getPhoneNumber(), this.getAddress(), gpa);
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
				"<head><title>Student:" + this.getId() + "-" + "name" + "</title></head>\n" +
				"<body>\n" +
				this.getId() + " " + this.getName() + " " + this.getPhoneNumber() + " " + this.getAddress() + " " + gpa
				+ "\n" +
				"</body></html>";
	}
}
