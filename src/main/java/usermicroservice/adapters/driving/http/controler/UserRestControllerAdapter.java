package usermicroservice.adapters.driving.http.controler;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import usermicroservice.adapters.driving.http.dto.request.AddUserRequest;
import usermicroservice.adapters.driving.http.mapper.IUserRequestMapper;
import usermicroservice.domain.api.IUserServicePort;
import usermicroservice.domain.model.User;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserRestControllerAdapter {
    private final IUserRequestMapper userRequestMapper;
    private final IUserServicePort userServicePort;

    @PostMapping("/register/admin")
    public ResponseEntity<Void> addUserAdmin(@RequestBody  @Valid AddUserRequest request) {
        User user = userRequestMapper.dtoRequestToUser(request);
        userServicePort.saveUser(user, 1L);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/register/tutor")
    public ResponseEntity<Void> addUserTutor(@RequestBody  @Valid AddUserRequest request) {
        User user = userRequestMapper.dtoRequestToUser(request);
        userServicePort.saveUser(user, 2L);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/register/student")
    public ResponseEntity<Void> addUserStudent(@RequestBody  @Valid AddUserRequest request) {
        User user = userRequestMapper.dtoRequestToUser(request);
        userServicePort.saveUser(user, 3L);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
