package PasswordProject.PasswordProject.controller.contracts;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public record PasswordRequest(
        int length,
        boolean useUpperCase,
        boolean useLowerCase,
        boolean useNumbers,
        boolean useSymbols
) {

    @JsonCreator
    public PasswordRequest(
            @JsonProperty("length") int length,
            @JsonProperty("useUpperCase") boolean useUpperCase,
            @JsonProperty("useLowerCase") boolean useLowerCase,
            @JsonProperty("useNumbers") boolean useNumbers,
            @JsonProperty("useSymbols") boolean useSymbols
    ) {
        this.length = length;
        this.useUpperCase = useUpperCase;
        this.useLowerCase = useLowerCase;
        this.useNumbers = useNumbers;
        this.useSymbols = useSymbols;
    }
}
