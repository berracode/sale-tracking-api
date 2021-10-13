package com.inerxia.saletrackingapi.controller;


import com.inerxia.saletrackingapi.dto.UserDto;
import com.inerxia.saletrackingapi.facade.UserFacade;
import com.inerxia.saletrackingapi.util.StandardResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserFacade userFacade;

    public UserController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @PostMapping("/customer/singup")
    public ResponseEntity<StandardResponse<UserDto>> createCustomer(@Valid @RequestBody UserDto userDto){

        UserDto userDto1 =  userFacade.createUser(userDto);

        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.EstadoStandardResponse.OK,
                "sing_up.create.ok",
                userDto1));
    }


    @Secured({"ROLE_ADMIN"})
    @PostMapping("/employee/singup")
    public  String createEmployee(@Valid @RequestBody UserDto userDto){

       return "Creating employee ResponseEntity<StandardResponse<UserDto>>";
    }


}
