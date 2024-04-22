package usermicroservice.domain.spi;

import usermicroservice.domain.model.User;

public interface IUserPersistencePort {
    void saveUser(User user);
    User findByEmail(String email);
}
