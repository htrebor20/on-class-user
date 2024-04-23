package usermicroservice.domain.api;

import usermicroservice.domain.model.Role;

public interface IRoleServicePort {
    Role findByName(String roleNane);
}
