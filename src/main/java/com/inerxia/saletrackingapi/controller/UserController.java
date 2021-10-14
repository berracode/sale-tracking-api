package com.inerxia.saletrackingapi.controller;


import com.inerxia.saletrackingapi.dto.UserDto;
import com.inerxia.saletrackingapi.dto.UserSingIn;
import com.inerxia.saletrackingapi.facade.UserFacade;
import com.inerxia.saletrackingapi.util.StandardResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    private UserFacade userFacade;

    public UserController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @Secured({"ROLE_ADMIN"})
    @GetMapping("/test-security")
    @ApiOperation(value = "Test user", response = UserDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public String test(){


        return "Test";
    }

    @PostMapping("/singin")
    @ApiOperation(value = "singin user", response = UserDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<UserSingIn>> singIn(@Valid @RequestBody UserDto userDto){

        UserSingIn userSingIn =  userFacade.singIn(userDto);

        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.StatusStandardResponse.OK,
                "sing_up.create.ok",
                userSingIn));
    }

    @PostMapping("/customer/singup")
    @ApiOperation(value = "Singup user", response = UserDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<UserDto>> createCustomer(@Valid @RequestBody UserDto userDto){

        UserDto userDto1 =  userFacade.createUser(userDto);

        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.StatusStandardResponse.OK,
                "sing_up.create.ok",
                userDto1));
    }


    @Secured({"ROLE_ADMIN"})
    @PostMapping("/employee/singup")
    @ApiOperation(value = "Singup user", response = UserDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public  String createEmployee(@Valid @RequestBody UserDto userDto){

       return "Creating employee ResponseEntity<StandardResponse<UserDto>>";
    }


}
