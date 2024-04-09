package usermicroservice.domain.api.usecase;

import usermicroservice.domain.api.IUserServicePort;
import usermicroservice.domain.model.User;
import usermicroservice.domain.spi.IUserPersistencePort;

public class UserUseCase implements IUserServicePort {
    private final IUserPersistencePort userPersistencePort;

    public UserUseCase(IUserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;

    }

    @Override
    public void saveUser(User user) {
        userPersistencePort.saveUser(user);
    }
}
