package io.voltledger.userservice.repositories;

import io.voltledger.userservice.entities.Permissions;
import io.voltledger.userservice.entities.RolePermissionMap;
import io.voltledger.userservice.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolePermissionMapRepository extends JpaRepository<RolePermissionMap, Long> {
    boolean existsRolePermissionMapByRolesAndPermissions(Roles roles, Permissions permissions);
}
