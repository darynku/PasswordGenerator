package PasswordProject.PasswordProject.services;

import java.security.SecureRandom;

public class PasswordGenerator {

    private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{}|;:,.<>?";

    private static final SecureRandom random = new SecureRandom();

    public static String generate(int length, boolean useUpperCase, boolean useLowerCase, boolean useNumbers, boolean useSymbols) {
        if (length < 1) {
            throw new IllegalArgumentException("Длина пароля должна быть не менее 1 символа.");
        }

        StringBuilder characterPool = new StringBuilder();
        if (useUpperCase) {
            characterPool.append(UPPER_CASE);
        }
        if (useLowerCase) {
            characterPool.append(LOWER_CASE);
        }
        if (useNumbers) {
            characterPool.append(DIGITS);
        }
        if (useSymbols) {
            characterPool.append(SPECIAL_CHARACTERS);
        }

        if (characterPool.length() == 0) {
            throw new IllegalArgumentException("Необходимо выбрать хотя бы один тип символов.");
        }

        StringBuilder password = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            password.append(characterPool.charAt(random.nextInt(characterPool.length())));
        }

        return shuffleString(password.toString());
    }

    private static String shuffleString(String input) {
        char[] characters = input.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            int randomIndex = random.nextInt(characters.length);
            char temp = characters[i];
            characters[i] = characters[randomIndex];
            characters[randomIndex] = temp;
        }
        return new String(characters);
    }
}
