package com.cv.generator.platform.service.impl;

import com.cv.generator.platform.dto.UserDTO;
import com.cv.generator.platform.exception.EntityNotFoundException;
import com.cv.generator.platform.mapper.UserMapper;
import com.cv.generator.platform.repository.UserRepository;
import com.cv.generator.platform.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private UserMapper userMapper;

    @Override
    public List<UserDTO> getAll() {
        return userMapper.toDTOs(userRepository.findAll());
    }

    @Override
    public UserDTO getById(Long id) {
        return userMapper.toDTO(userRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("user")));
    }

    @Override
    public UserDTO add(UserDTO userDTO) {
        userRepository.save(userMapper.toEntity(userDTO));
        return userDTO;
    }

    @Override
    public void deleteById(Long id) {
    userRepository.deleteById(id);
    }
}
