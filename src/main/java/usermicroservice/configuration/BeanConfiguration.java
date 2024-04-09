package usermicroservice.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import usermicroservice.adapters.driven.jpa.mysql.adapter.UserAdapter;
import usermicroservice.adapters.driven.jpa.mysql.mapper.IUserEntityMapper;
import usermicroservice.adapters.driven.jpa.mysql.repository.IUserRepository;
import usermicroservice.domain.api.IUserServicePort;
import usermicroservice.domain.api.usecase.UserUseCase;
import usermicroservice.domain.spi.IUserPersistencePort;

@Configuration
@RequiredArgsConstructor

public class BeanConfiguration {
    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;

    @Bean
    public IUserPersistencePort userPersistencePort() {
        return new UserAdapter(userRepository, userEntityMapper);
    }

    @Bean
    public IUserServicePort userServicePort() {
        return new UserUseCase(userPersistencePort());
    }

}
