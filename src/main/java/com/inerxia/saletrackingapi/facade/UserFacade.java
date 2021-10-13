package com.inerxia.saletrackingapi.facade;

import com.inerxia.saletrackingapi.config.jwt2.JwtGenerarToken;
import com.inerxia.saletrackingapi.dto.UserDto;
import com.inerxia.saletrackingapi.dto.UserSingIn;
import com.inerxia.saletrackingapi.mapper.UserMapper;
import com.inerxia.saletrackingapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Locale;

import static com.inerxia.saletrackingapi.util.Constants.TOKEN_TYPE;

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

    public UserSingIn singIn(UserDto userDto) {

        System.out.println(userDto.toString());

        Authentication authentication = this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userDto.getEmail(), userDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtGenerarToken.generarToken(authentication);
        UserSingIn userSingIn = new UserSingIn();
        userSingIn.setTokenType(TOKEN_TYPE);
        userSingIn.setToken(jwt);

        return userSingIn;
    }

    public UserDto createUser(UserDto userDto) {
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userDto.setFirstName(userDto.getFirstName().toUpperCase());
        userDto.setLastName(userDto.getLastName().toUpperCase());

        UserDto  userDto1 = userMapper.toDto(userService.createUser(userMapper.toEntity(userDto)));

        return userDto1;

    }
}
