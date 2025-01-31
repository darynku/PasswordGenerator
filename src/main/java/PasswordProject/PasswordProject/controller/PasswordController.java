package PasswordProject.PasswordProject.controller;


import PasswordProject.PasswordProject.controller.contracts.PasswordRequest;
import PasswordProject.PasswordProject.controller.contracts.PasswordResponse;
import PasswordProject.PasswordProject.services.PasswordGenerator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PasswordController {

    @PostMapping("/generate-password")
    public ResponseEntity<PasswordResponse> generatePassword(@RequestBody PasswordRequest request) {
        // Генерация пароля с использованием PasswordGenerator
        String password = PasswordGenerator.generate(request.length());
        // Возвращаем сгенерированный пароль в ответе
        return ResponseEntity.ok(new PasswordResponse(password));
    }   
}

