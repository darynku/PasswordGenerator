package PasswordProject.PasswordProject.controller.contracts;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public record PasswordRequest(int length) {

    @JsonCreator
    public PasswordRequest(@JsonProperty("length") int length) {
        this.length = length;
    }
}
