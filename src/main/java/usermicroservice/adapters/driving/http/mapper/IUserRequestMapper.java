package usermicroservice.adapters.driving.http.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import usermicroservice.adapters.driving.http.dto.request.AddUserRequest;
import usermicroservice.domain.model.User;

@Mapper(componentModel = "spring")
public interface IUserRequestMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", ignore = true)
    User dtoRequestToUser(AddUserRequest addUserRequest);

}
