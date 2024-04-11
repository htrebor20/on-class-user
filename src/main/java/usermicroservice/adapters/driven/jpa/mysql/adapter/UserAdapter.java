package usermicroservice.adapters.driven.jpa.mysql.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import usermicroservice.adapters.driven.jpa.mysql.entity.UserEntity;
import usermicroservice.adapters.driven.jpa.mysql.mapper.IUserEntityMapper;
import usermicroservice.adapters.driven.jpa.mysql.repository.IUserRepository;
import usermicroservice.domain.model.User;

import usermicroservice.domain.spi.IUserPersistencePort;
@RequiredArgsConstructor
public class UserAdapter implements IUserPersistencePort {
    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void saveUser(User user) {
        UserEntity entity = userEntityMapper.toEntity(user);
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        userRepository.save(entity);
    }
}
