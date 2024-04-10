package usermicroservice.adapters.driving.http.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import usermicroservice.adapters.driving.http.dto.request.AddUserRequest;
import usermicroservice.domain.model.Role;
import usermicroservice.domain.model.User;

@Mapper(componentModel = "spring")
public interface IUserRequestMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", source = "roleId")
    User dtoRequestToUser(AddUserRequest addUserRequest);

    default Role mapRole(Long roleId){return new Role(roleId,null,null);}
}
