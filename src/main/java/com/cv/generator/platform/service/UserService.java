package com.cv.generator.platform.service;

import com.cv.generator.platform.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> getAll();

    UserDTO getById(Long id);

    UserDTO add(UserDTO userDTO);

    void deleteById(Long id);
}
