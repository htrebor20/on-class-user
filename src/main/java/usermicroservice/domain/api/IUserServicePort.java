package usermicroservice.domain.api;

import usermicroservice.domain.model.User;

public interface IUserServicePort {
    void saveUser(User user);
}
