package usermicroservice.adapters.driving.http.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class JwtResponse {
    private final String token;
}
