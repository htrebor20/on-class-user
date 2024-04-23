package usermicroservice.domain.spi;

import usermicroservice.domain.model.Role;

public interface IRolePersistencePort {
    Role findByName(String roleNane);
}
