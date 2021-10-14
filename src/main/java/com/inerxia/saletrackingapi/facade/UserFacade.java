package com.inerxia.saletrackingapi.facade;

import com.inerxia.saletrackingapi.config.jwt2.GenerateJWT;
import com.inerxia.saletrackingapi.dto.*;
import com.inerxia.saletrackingapi.mapper.RoleMapper;
import com.inerxia.saletrackingapi.mapper.UserMapper;
import com.inerxia.saletrackingapi.model.User;
import com.inerxia.saletrackingapi.service.RoleService;
import com.inerxia.saletrackingapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static com.inerxia.saletrackingapi.util.Constants.TOKEN_TYPE;

@Transactional
@Service
public class UserFacade {

    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;
    private GenerateJWT generateJWT;
    private UserMapper userMapper;
    private UserService userService;

    private RoleService roleService;
    private RoleMapper roleMapper;

    public UserFacade(AuthenticationManager authenticationManager, GenerateJWT generateJWT,
                      UserMapper userMapper, UserService userService,
                      RoleService roleService, RoleMapper roleMapper) {

        this.authenticationManager = authenticationManager;
       this.generateJWT = generateJWT;
        this.userMapper = userMapper;
        this.userService = userService;
        this.roleService = roleService;
        this.roleMapper = roleMapper;
    }

    public UserSingIn singIn(UserDto userDto) {

        System.out.println(userDto.toString());

        Authentication authentication = this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userDto.getEmail(), userDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = generateJWT.generateToken(authentication);
        UserSingIn userSingIn = new UserSingIn();
        List<UserRolePermissionsDto> userRolePermissionsDtoList = userService.findUserRoleWithPermission(userDto.getEmail());

        userSingIn.setUserWrapperDto(new UserWrapperDto(
                userRolePermissionsDtoList.get(0).getEmail(),
                userRolePermissionsDtoList.get(0).getFirstName(),
                userRolePermissionsDtoList.get(0).getLastName(),
                new RoleDto(userRolePermissionsDtoList.get(0).getRoleId(),
                        userRolePermissionsDtoList.get(0).getRoleName())
                )
        );
        userSingIn.setUserRolePermissionsDtoList(userRolePermissionsDtoList);
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
