package a1_bi12_009;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import utils.NotPossibleException;

class TestPostgradStudent {
	@Test
	void testCreatePostgradStudentSuccess() {
		PostgradStudent student = new PostgradStudent(100000727, "Rylie", "0123456727", "Grove St.", 4.0f);

		assertEquals(100000727, student.getId());
		assertEquals("Rylie", student.getName());
		assertEquals("0123456727", student.getPhoneNumber());
		assertEquals("Grove St.", student.getAddress());
		assertEquals(4.0f, student.getGpa());
	}

	@Test
	void testCreatePostgradStudentFailureId() {
		assertThrows(NotPossibleException.class, () -> {
			new PostgradStudent(727, "Rylie", "0123456727", "Grove St.", 4.0f);
		});
	}

	@Test
	void testCreatePostgradStudentFailureGpa() {
		assertThrows(NotPossibleException.class, () -> {
			new PostgradStudent(100000727, "Rylie", "0123456727", "Grove St.", 5.0f);
		});
	}

	@Test
	void testMutatePostgradStudentGpaSuccess() {
		PostgradStudent student = new PostgradStudent(100000727, "Rylie", "0123456727", "Grove St.", 4.0f);

		student.setGpa(2.5f);
		assertEquals(2.5f, student.getGpa());
	}

	@Test
	void testMutatePostgradStudentGpaFailure() {
		PostgradStudent student = new PostgradStudent(100000727, "Rylie", "0123456727", "Grove St.", 4.0f);

		assertFalse(
				student.setGpa(-1.0f));
		assertFalse(
				student.setGpa(5.0f));
	}
}
