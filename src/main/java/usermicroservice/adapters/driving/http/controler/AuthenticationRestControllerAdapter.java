package usermicroservice.adapters.driving.http.controler;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import usermicroservice.adapters.driving.http.dto.request.AddRequestLogin;
import usermicroservice.adapters.driving.http.dto.response.JwtResponse;
import usermicroservice.adapters.driving.http.mapper.ILoginRequestMapper;
import usermicroservice.domain.api.IAuthenticationServicePort;
import usermicroservice.domain.model.JwtModel;
import usermicroservice.domain.model.Login;

import javax.security.sasl.AuthenticationException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationRestControllerAdapter {
    private final ILoginRequestMapper loginRequestMapper;
    private final IAuthenticationServicePort authenticationServicePort;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody @Valid AddRequestLogin request) throws AuthenticationException {
        Login login = loginRequestMapper.dtoRequestToLogin(request);
        JwtModel jwtModel = authenticationServicePort.login(login);
        return ResponseEntity.ok(loginRequestMapper.toJwtResponse(jwtModel));
    }
}
