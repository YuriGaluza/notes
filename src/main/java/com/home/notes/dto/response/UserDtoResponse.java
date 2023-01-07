package com.home.notes.dto.response;

public class UserDtoResponse {
    private String firstName;
    private String lastName;

    public UserDtoResponse() {}

    public UserDtoResponse(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
