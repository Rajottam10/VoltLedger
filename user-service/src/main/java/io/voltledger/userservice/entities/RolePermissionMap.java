package io.voltledger.userservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "role_permissions")
public class RolePermissionMap extends BaseEntity{
    @JoinColumn(name = "roles", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Roles roles;

    @JoinColumn(name = "permission", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Permissions permissions;
}
