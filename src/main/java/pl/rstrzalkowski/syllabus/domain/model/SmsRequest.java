// src/main/java/pl/rstrzalkowski/syllabus/domain/model/SmsRequest.java
package pl.rstrzalkowski.syllabus.domain.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class SmsRequest {

    @NotNull(message = "Phone number cannot be null")
    @Size(min = 10, max = 15, message = "Phone number must be between 10 and 15 characters")
    private String phoneNumber;

    @NotNull(message = "Message cannot be null")
    @Size(min = 1, max = 160, message = "Message must be between 1 and 160 characters")
    private String message;

    // Getters and Setters
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "SmsRequest [phoneNumber=" + phoneNumber + ", message=" + message + "]";
    }
}
