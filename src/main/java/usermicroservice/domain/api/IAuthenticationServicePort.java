package usermicroservice.domain.api;

import usermicroservice.domain.model.JwtModel;
import usermicroservice.domain.model.Login;

import javax.security.sasl.AuthenticationException;

public interface IAuthenticationServicePort {
    JwtModel login(Login userData) throws AuthenticationException;
}
