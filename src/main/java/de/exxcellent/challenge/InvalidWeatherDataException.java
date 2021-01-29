package de.exxcellent.challenge;

import java.io.IOException;

public class InvalidWeatherDataException extends IOException {
    public InvalidWeatherDataException(String errorMessage) {
        super(errorMessage);
    }
}
