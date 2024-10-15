package PasswordProject.PasswordProject.services;

import java.security.SecureRandom;

public class PasswordGenerator {

    // Множество символов, которые могут использоваться для генерации пароля
    private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{}|;:,.<>?";

    // Все возможные символы для пароля
    private static final String ALL_CHARACTERS = UPPER_CASE + LOWER_CASE + DIGITS + SPECIAL_CHARACTERS;

    // Объект для генерации безопасных случайных чисел
    private static final SecureRandom random = new SecureRandom();

    public static String generate(int length) {
        if (length < 4) {
            throw new IllegalArgumentException("Длина пароля должна быть не менее 4 символов.");
        }

        StringBuilder password = new StringBuilder(length);

        // Гарантируем наличие хотя бы одного символа каждого типа
        password.append(UPPER_CASE.charAt(random.nextInt(UPPER_CASE.length())));
        password.append(LOWER_CASE.charAt(random.nextInt(LOWER_CASE.length())));
        password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        password.append(SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length())));

        // Заполняем оставшуюся длину пароля случайными символами
        for (int i = 4; i < length; i++) {
            password.append(ALL_CHARACTERS.charAt(random.nextInt(ALL_CHARACTERS.length())));
        }

        // Перемешиваем символы в пароле для случайного порядка
        return shuffleString(password.toString());
    }

    private static String shuffleString(String input) {
        char[] characters = input.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            int randomIndex = random.nextInt(characters.length);
            // Обмен значениями
            char temp = characters[i];
            characters[i] = characters[randomIndex];
            characters[randomIndex] = temp;
        }
        return new String(characters);
    }
}
