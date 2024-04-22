package usermicroservice.domain.api.usecase;

import usermicroservice.domain.api.IAuthenticationServicePort;
import usermicroservice.domain.model.JwtModel;
import usermicroservice.domain.model.Login;
import usermicroservice.domain.spi.IAuthenticationPort;

import javax.security.sasl.AuthenticationException;

public class AuthenticationUseCase implements IAuthenticationServicePort {
    private final IAuthenticationPort authenticationPort;

    public AuthenticationUseCase(IAuthenticationPort authenticationPort) {
        this.authenticationPort = authenticationPort;
    }

    @Override
    public JwtModel login(Login userData) throws AuthenticationException {
        return authenticationPort.login(userData.getEmail(), userData.getPassword());
    }
}
