package a1_bi12_009;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import utils.NotPossibleException;

class TestStudent {
	@Test
	void testCreateStudentSuccess() {
		Student student = new Student(727, "Rylie", "0123456727", "Grove St.");

		assertEquals(727, student.getId());
		assertEquals("Rylie", student.getName());
		assertEquals("0123456727", student.getPhoneNumber());
		assertEquals("Grove St.", student.getAddress());
	}

	@Test
	void testCreateStudentFailureId() {
		assertThrows(NotPossibleException.class, () -> {
			new Student(-1, "Rylie", "0123456727", "Grove St.");
		});
	}

	@Test
	void testCreateStudentFailureName() {
		assertThrows(NotPossibleException.class, () -> {
			new Student(1, "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "0123456727",
					"Grove St.");
		});
	}

	@Test
	void testCreateStudentFailurePhoneNumber() {
		assertThrows(NotPossibleException.class, () -> {
			new Student(1, "Rylie", "01234567270", "Grove St.");
		});
	}

	@Test
	void testCreateStudentFailureAddress() {
		assertThrows(NotPossibleException.class, () -> {
			new Student(1, "Rylie", "0123456727",
					"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		});
	}

	@Test
	void testMutateStudentNameSuccess() {
		Student student = new Student(727, "Rylie", "0123456727", "Grove St.");

		student.setName("Lumine");
		assertEquals("Lumine", student.getName());
	}

	@Test
	void testMutateStudentNameFailure() {
		Student student = new Student(727, "Rylie", "0123456727", "Grove St.");

		assertThrows(NotPossibleException.class, () -> {
			student.setName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		});
	}

	@Test
	void testMutateStudentPhoneNumberSuccess() {
		Student student = new Student(727, "Rylie", "0123456727", "Grove St.");

		student.setPhoneNumber("012369420");
		assertEquals("012369420", student.getPhoneNumber());
	}

	@Test
	void testMutateStudentPhoneNumberFailure() {
		Student student = new Student(727, "Rylie", "0123456727", "Grove St.");

		assertThrows(NotPossibleException.class, () -> {
			student.setPhoneNumber("01234567270");
		});
	}

	@Test
	void testMutateStudentAddressSuccess() {
		Student student = new Student(727, "Rylie", "0123456727", "Grove St.");

		student.setAddress("Earth");
		assertEquals("Earth", student.getAddress());
	}

	@Test
	void testMutateStudentAddressFailure() {
		Student student = new Student(727, "Rylie", "0123456727", "Grove St.");
		assertThrows(NotPossibleException.class, () -> {
			student.setAddress(
					"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		});
	}
}
