package usermicroservice.adapters.driven.jpa.mysql.adapter;

import lombok.RequiredArgsConstructor;
import usermicroservice.adapters.driven.jpa.mysql.entity.UserEntity;
import usermicroservice.adapters.driven.jpa.mysql.mapper.IUserEntityMapper;
import usermicroservice.adapters.driven.jpa.mysql.repository.IUserRepository;
import usermicroservice.domain.model.User;

import usermicroservice.domain.spi.IUserPersistencePort;

@RequiredArgsConstructor
public class UserAdapter implements IUserPersistencePort {
    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;

    @Override
    public void saveUser(User user) {
        UserEntity entity = userEntityMapper.toEntity(user);
        userRepository.save(entity);
    }

    @Override
    public User findByEmail(String email) {
        UserEntity entity = userRepository.findByEmail(email);
        return userEntityMapper.toModel(entity);
    }
}
