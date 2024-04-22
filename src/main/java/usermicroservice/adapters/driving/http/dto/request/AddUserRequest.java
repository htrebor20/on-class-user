package usermicroservice.adapters.driving.http.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AddUserRequest {
    private final Long id;
    @NotBlank(message = "This field is required")
    private final String name;
    @NotBlank(message = "This field is required")
    private final String lastName;
    @NotNull(message = "This field is required")
    private final Long document;
    @NotBlank(message = "This field is required")
    private final String cellphone;
    @NotBlank(message = "This field is required")
    private final String email;
    @NotBlank(message = "This field is required")
    private final String password;
    private final String country;
    private final String city;
    private final String academicLevel;
    private final String gitUrl;
    private final String linkedinUrl;
    private final String instagramUrl;
}
