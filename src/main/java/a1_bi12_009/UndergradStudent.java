package a1_bi12_009;

import utils.AttrRef;
import utils.NotPossibleException;

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
 *
 * @object
 *  An object is of form <pre>s = <i, n, p, a></pre>, where
 *  <pre>id (i), name (n), phoneNumber (p), address (a)</pre>.
 *
 * @abstract_properties
 *  P_Student | min(id) = 100000 | max(id) = 100000000
 *
 * @author BI12-009 Nguyen Pham Quoc An
 **/
// @formatter:on
public class UndergradStudent extends Student {

	// @formatter:off
	/**
	 * @effects
	 *  <pre>
	 *    if id, name, phoneNumber and address are valid
	 *      initialize as <id, name, phoneNumber, address>
	 *    else
	 *      throw NotPossibleException
	 *  </pre>
	 **/
	// @formatter:on
	public UndergradStudent(@AttrRef("id") int id, @AttrRef("name") String name,
			@AttrRef("phoneNumber") String phoneNumber, @AttrRef("address") String address)
			throws NotPossibleException {
		super(id, name, phoneNumber, address);
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
	 **/
	// @formatter:on
	@Override
	protected boolean validateId(int id) {
		if (id < 100000 || id > 100000000) {
			return false;
		}

		return true;
	}
}
