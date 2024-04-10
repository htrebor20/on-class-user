package usermicroservice.domain.api.usecase;

import usermicroservice.domain.api.IRoleServicePort;
import usermicroservice.domain.model.Role;
import usermicroservice.domain.spi.IRolePersistencePort;

public class RoleUseCase implements IRoleServicePort {
    private final IRolePersistencePort rolePersistencePort;

    public RoleUseCase(IRolePersistencePort rolePersistencePort) {
        this.rolePersistencePort = rolePersistencePort;
    }

    @Override
    public Role findById(Long id) {
        return rolePersistencePort.findById(id);
    }
}
