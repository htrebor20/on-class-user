package usermicroservice.adapters.driven.jpa.mysql.mapper;

import org.mapstruct.Mapper;
import usermicroservice.adapters.driven.jpa.mysql.entity.UserEntity;
import usermicroservice.domain.model.User;
@Mapper(componentModel = "spring")
public interface IUserEntityMapper {
    User toModel(UserEntity userEntity);
    UserEntity toEntity (User user);
}
