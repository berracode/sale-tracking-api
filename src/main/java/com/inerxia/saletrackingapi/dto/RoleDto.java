package com.inerxia.saletrackingapi.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RoleDto {

    private Integer id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

}
