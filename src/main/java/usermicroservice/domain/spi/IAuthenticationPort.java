package usermicroservice.domain.spi;

import usermicroservice.domain.model.JwtModel;

import javax.security.sasl.AuthenticationException;

public interface IAuthenticationPort {
    JwtModel login(String username, String password) throws AuthenticationException;
}
