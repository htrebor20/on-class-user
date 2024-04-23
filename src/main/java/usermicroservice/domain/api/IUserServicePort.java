package usermicroservice.domain.api;

import usermicroservice.domain.model.User;

public interface IUserServicePort {
    void saveAdmin(User user);
    void saveTutor(User user);
    void saveStudent(User user);
}
