package com.inerxia.saletrackingapi.facade;

import com.inerxia.saletrackingapi.config.jwt2.JwtGenerarToken;
import com.inerxia.saletrackingapi.dto.UserDto;
import com.inerxia.saletrackingapi.mapper.UserMapper;
import com.inerxia.saletrackingapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class UserFacade {

    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;
    private JwtGenerarToken jwtGenerarToken;
    private UserMapper userMapper;
    private UserService userService;

    public UserFacade(AuthenticationManager authenticationManager, JwtGenerarToken jwtGenerarToken,
                      UserMapper userMapper, UserService userService) {

        this.authenticationManager = authenticationManager;
       this.jwtGenerarToken = jwtGenerarToken;
        this.userMapper = userMapper;
        this.userService = userService;
    }

    public UserDto createUser(UserDto userDto) {
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        UserDto  userDto1 = userMapper.toDto(userService.createUser(userMapper.toEntity(userDto)));

        return userDto1;

    }
}
