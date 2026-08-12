package io.voltledger.userservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
    @JoinColumn(name = "role_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Roles roles;

    @JoinColumn(name = "permission_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Permissions permissions;
}
