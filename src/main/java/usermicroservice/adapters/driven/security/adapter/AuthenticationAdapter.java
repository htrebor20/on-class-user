package usermicroservice.adapters.driven.security.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import usermicroservice.configuration.security.jwt.JwtTokenUtil;
import usermicroservice.domain.Constants;
import usermicroservice.domain.model.JwtModel;
import usermicroservice.domain.spi.IAuthenticationPort;

import javax.security.sasl.AuthenticationException;

@RequiredArgsConstructor
public class AuthenticationAdapter implements IAuthenticationPort {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtTokenUtil jwtTokenUtil;

    @Override
    public JwtModel login(String username, String password) throws AuthenticationException {
        authenticate(username,password);

        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        final String token = jwtTokenUtil.generateToken(userDetails);
        return new JwtModel(token);
    }

    private void authenticate(String username, String password) throws AuthenticationException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (BadCredentialsException e){
            throw new AuthenticationException(String.format(Constants.INVALID_CREDENTIALS, e.getMessage()));
        }
    }
}
