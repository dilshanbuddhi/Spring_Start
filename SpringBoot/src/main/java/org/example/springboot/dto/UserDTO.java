package org.example.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private String email;
    private String password;
    private String name;
    private String role;

    public UserDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
