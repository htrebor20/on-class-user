package usermicroservice.domain.api.usecase;

import usermicroservice.domain.api.IRoleServicePort;
import usermicroservice.domain.api.IUserServicePort;
import usermicroservice.domain.model.Role;
import usermicroservice.domain.model.User;
import usermicroservice.domain.spi.IUserPersistencePort;

public class UserUseCase implements IUserServicePort {
    private final IUserPersistencePort userPersistencePort;
    private final IRoleServicePort roleServicePort;
    public UserUseCase(IUserPersistencePort userPersistencePort, IRoleServicePort roleServicePort) {
        this.userPersistencePort = userPersistencePort;
        this.roleServicePort = roleServicePort;
    }

    @Override
    public void saveUser(User user) {
        Role role = roleServicePort.findById(user.getRole().getId());
        user.setRole(role);
        userPersistencePort.saveUser(user);
    }
}
