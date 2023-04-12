package a1_bi12_009;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import utils.NotPossibleException;

class TestUndergradStudent {
	@Test
	void TestCreateUndergradStudentSuccess() {
		UndergradStudent student = new UndergradStudent(100727, "Rylie", "0123456727", "Grove St.");

		assertEquals(100727, student.getId());
		assertEquals("Rylie", student.getName());
		assertEquals("0123456727", student.getPhoneNumber());
		assertEquals("Grove St.", student.getAddress());
	}

	@Test
	void TestCreateUndergradStudentFailure() {
		assertThrows(NotPossibleException.class, () -> {
			new UndergradStudent(727, "Rylie", "0123456727", "Grove St.");
		});
	}
}
