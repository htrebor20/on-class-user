package usermicroservice.adapters.driven.jpa.mysql.adapter;

import lombok.RequiredArgsConstructor;
import usermicroservice.adapters.driven.jpa.mysql.entity.RoleEntity;
import usermicroservice.adapters.driven.jpa.mysql.mapper.IRoleEntityMapper;
import usermicroservice.adapters.driven.jpa.mysql.repository.IRoleRepository;
import usermicroservice.domain.model.Role;
import usermicroservice.domain.spi.IRolePersistencePort;

import java.util.Optional;

@RequiredArgsConstructor
public class RoleAdapter implements IRolePersistencePort {
    private final IRoleRepository roleRepository;
    private final IRoleEntityMapper roleEntityMapper;

    @Override
    public Role findByName(String roleName) {
        Optional<RoleEntity> role = roleRepository.findByName(roleName);
        return role.map(roleEntityMapper::toModel).orElse(null);
    }

}
