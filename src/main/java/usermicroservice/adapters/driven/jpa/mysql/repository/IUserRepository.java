package usermicroservice.adapters.driven.jpa.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import usermicroservice.adapters.driven.jpa.mysql.entity.UserEntity;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {
}
