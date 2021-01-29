package de.exxcellent.challenge;

import java.io.IOException;

public class InvalidCSVFormatException extends IOException {
    public InvalidCSVFormatException(String errorMessage) {
        super(errorMessage);
    }
}
