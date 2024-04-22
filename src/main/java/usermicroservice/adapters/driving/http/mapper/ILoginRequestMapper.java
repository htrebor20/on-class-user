package usermicroservice.adapters.driving.http.mapper;

import org.mapstruct.Mapper;
import usermicroservice.adapters.driving.http.dto.request.AddRequestLogin;
import usermicroservice.adapters.driving.http.dto.response.JwtResponse;
import usermicroservice.domain.model.JwtModel;
import usermicroservice.domain.model.Login;

@Mapper(componentModel = "spring")
public interface ILoginRequestMapper {
    Login dtoRequestToLogin(AddRequestLogin addRequestLogin);
    JwtResponse toJwtResponse(JwtModel jwtModel);
}
