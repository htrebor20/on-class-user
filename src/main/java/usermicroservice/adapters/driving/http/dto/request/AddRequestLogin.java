package usermicroservice.adapters.driving.http.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AddRequestLogin {
    @NotBlank(message = "This field is required")
    @Email(message = "Invalid email address")
    private final String email;
    @NotEmpty(message = "This field is required")
    private final String password;

}
