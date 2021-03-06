package com.inerxia.saletrackingapi.dto;


import javax.validation.constraints.NotBlank;

public class RoleDto {

    private Integer id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    public RoleDto() {
    }

    public RoleDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
