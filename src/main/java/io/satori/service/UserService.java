package io.satori.service;

import io.satori.dto.UserDto;
import io.satori.model.ApplicationUser;

public interface UserService {
    ApplicationUser createUser(UserDto userDto);
    ApplicationUser save(ApplicationUser applicationUser);
    ApplicationUser findByUsername(String username);
}
