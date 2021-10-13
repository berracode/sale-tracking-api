package com.inerxia.saletrackingapi.mapper;

import com.inerxia.saletrackingapi.dto.UserDto;
import com.inerxia.saletrackingapi.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {RoleMapper.class})
public interface UserMapper extends EntityMapper<UserDto, User>{
}
