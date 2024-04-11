package usermicroservice.domain.spi;

import usermicroservice.domain.model.Role;

public interface IRolePersistencePort {
    Role findById(Long id);
}
