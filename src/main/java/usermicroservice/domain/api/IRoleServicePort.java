package usermicroservice.domain.api;

import usermicroservice.domain.model.Role;

public interface IRoleServicePort {
    Role findById(Long id);
}
