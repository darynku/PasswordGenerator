package PasswordProject.PasswordProject;

import PasswordProject.PasswordProject.services.PasswordGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PasswordProjectApplicationTests {

	@Test
	void contextLoads() {
		// Проверка, что контекст приложения загружается без ошибок
	}

	@Test
	void testGeneratePasswordLength() {
		String password = PasswordGenerator.generate(12);
		assertEquals(12, password.length(), "Password should be 12 characters long");
	}

	@Test
	void testGeneratePasswordContainsUpperCase() {
		String password = PasswordGenerator.generate(12);
		assertTrue(password.chars().anyMatch(Character::isUpperCase), "Password should contain at least one uppercase letter");
	}

	@Test
	void testGeneratePasswordContainsLowerCase() {
		String password = PasswordGenerator.generate(12);
		assertTrue(password.chars().anyMatch(Character::isLowerCase), "Password should contain at least one lowercase letter");
	}

	@Test
	void testGeneratePasswordContainsDigit() {
		String password = PasswordGenerator.generate(12);
		assertTrue(password.chars().anyMatch(Character::isDigit), "Password should contain at least one digit");
	}

	@Test
	void testGeneratePasswordContainsSpecialCharacter() {
		String password = PasswordGenerator.generate(12);
		assertTrue(password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/].*"), "Password should contain at least one special character");
	}
}

