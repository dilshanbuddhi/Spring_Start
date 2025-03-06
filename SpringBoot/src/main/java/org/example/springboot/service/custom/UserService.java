package org.example.springboot.service.custom;


import org.example.springboot.dto.UserDTO;

public interface UserService {
    int saveUser(UserDTO userDTO);
    UserDTO searchUser(String username);
}