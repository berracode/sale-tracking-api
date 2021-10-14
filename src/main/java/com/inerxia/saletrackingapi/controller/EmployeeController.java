package com.inerxia.saletrackingapi.controller;

import com.inerxia.saletrackingapi.dto.UserDto;
import com.inerxia.saletrackingapi.dto.UserSingUpDto;
import com.inerxia.saletrackingapi.facade.EmployeeFacade;
import com.inerxia.saletrackingapi.util.StandardResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeFacade employeeFacade;

    public EmployeeController(EmployeeFacade employeeFacade) {
        this.employeeFacade = employeeFacade;
    }

    //@Secured({"ROLE_ADMIN"})
    @PostMapping("/singup")
    @ApiOperation(value = "Singup user employee", response = UserSingUpDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public  ResponseEntity<StandardResponse<UserSingUpDto>> createEmployee(@Valid @RequestBody UserSingUpDto userSingUpDto){


        UserSingUpDto userSingUpDto1 =  employeeFacade.createUser(userSingUpDto);

        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.StatusStandardResponse.OK,
                "employee.sing_up.create.ok",
                userSingUpDto1));
    }
}
