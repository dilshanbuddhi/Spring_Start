package org.example.bean_validation.Dro;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class CustomerDto {
    @NotBlank(message = "Name is required")
    private String name ;
    @Email(message = "Email is not valid")
    private String email;
    @Pattern(regexp = "^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$", message = "Address is not valid")
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerDto(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }
}
