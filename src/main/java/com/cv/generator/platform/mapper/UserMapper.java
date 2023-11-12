package com.cv.generator.platform.mapper;

import com.cv.generator.platform.domain.User;
import com.cv.generator.platform.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends GeneralMapper<UserDTO, User> {
}
