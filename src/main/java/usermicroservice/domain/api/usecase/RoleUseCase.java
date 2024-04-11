package usermicroservice.domain.api.usecase;

import usermicroservice.domain.Constants;
import usermicroservice.domain.api.IRoleServicePort;
import usermicroservice.domain.exception.BadRequestValidationException;
import usermicroservice.domain.model.Role;
import usermicroservice.domain.spi.IRolePersistencePort;

import java.util.Optional;

public class RoleUseCase implements IRoleServicePort {
    private final IRolePersistencePort rolePersistencePort;

    public RoleUseCase(IRolePersistencePort rolePersistencePort) {
        this.rolePersistencePort = rolePersistencePort;
    }

    @Override
    public Role findById(Long id) {
        Optional<Role> role = Optional.ofNullable(rolePersistencePort.findById(id));
        if(role.isEmpty()) {
            throw new BadRequestValidationException(String.format(Constants.ID_ROL_VALIDATIONS_EXCEPTION_MESSAGE, id));
        }
        return role.get();
    }
}
