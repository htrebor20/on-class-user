package usermicroservice.adapters.driven.jpa.mysql.mapper;

import org.mapstruct.Mapper;
import usermicroservice.adapters.driven.jpa.mysql.entity.RoleEntity;
import usermicroservice.domain.model.Role;

@Mapper(componentModel = "spring")
public interface IRoleEntityMapper {

    Role toModel(RoleEntity roleEntity);
    RoleEntity toEntity(Role role);
}
