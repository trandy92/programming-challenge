package de.exxcellent.challenge;

import java.io.IOException;

public class InvalidFootballDataException extends IOException {
    public InvalidFootballDataException(String errorMessage) {
        super(errorMessage);
    }
}