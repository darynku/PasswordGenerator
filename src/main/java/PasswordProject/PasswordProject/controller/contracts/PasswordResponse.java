package PasswordProject.PasswordProject.controller.contracts;

public class PasswordResponse {
    private String password;

    // Конструктор
    public PasswordResponse(String password) {
        this.password = password;
    }

    // Геттер и сеттер
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
