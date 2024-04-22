package usermicroservice.domain.api.usecase;

import usermicroservice.domain.Constants;
import usermicroservice.domain.api.IRoleServicePort;
import usermicroservice.domain.api.IUserServicePort;
import usermicroservice.domain.exception.BadRequestValidationException;
import usermicroservice.domain.model.Role;
import usermicroservice.domain.model.User;
import usermicroservice.domain.spi.IUserPersistencePort;
import usermicroservice.utilities.EncoderHelper;

import java.util.Optional;

public class UserUseCase implements IUserServicePort {
    private final IUserPersistencePort userPersistencePort;
    private final IRoleServicePort roleServicePort;

    public UserUseCase(IUserPersistencePort userPersistencePort, IRoleServicePort roleServicePort) {
        this.userPersistencePort = userPersistencePort;
        this.roleServicePort = roleServicePort;
    }

    @Override
    public void saveUser(User user, Long id) {
       Optional<User> response = Optional.ofNullable(userPersistencePort.findByEmail(user.getEmail()));
        if(response.isPresent()) {
            throw new BadRequestValidationException(Constants.EMAIL_EXCEPTION_MESSAGE);
        }

        Role role = roleServicePort.findById(id);
        user.setRole(role);
        String encoded = EncoderHelper.encodePassword(user.getPassword());
        user.setPassword(encoded);
        userPersistencePort.saveUser(user);
    }
}
