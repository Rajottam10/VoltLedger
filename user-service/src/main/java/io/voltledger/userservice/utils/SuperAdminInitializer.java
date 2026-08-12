package io.voltledger.userservice.utils;

import io.voltledger.userservice.entities.Permissions;
import io.voltledger.userservice.entities.RolePermissionMap;
import io.voltledger.userservice.entities.Roles;
import io.voltledger.userservice.entities.Status;
import io.voltledger.userservice.entities.Users;
import io.voltledger.userservice.repositories.PermissionRepository;
import io.voltledger.userservice.repositories.RolePermissionMapRepository;
import io.voltledger.userservice.repositories.RoleRepository;
import io.voltledger.userservice.repositories.StatusRepository;
import io.voltledger.userservice.repositories.UsersRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SuperAdminInitializer {

    private static final Logger logger = LoggerFactory.getLogger(SuperAdminInitializer.class);

    private final RoleRepository roleRepository;
    private final StatusRepository statusRepository;
    private final UsersRepository usersRepository;
    private final PermissionRepository permissionRepository;
    private final RolePermissionMapRepository rolePermissionMapRepository;
    private final PasswordEncoder passwordEncoder;

    public SuperAdminInitializer(RoleRepository roleRepository, StatusRepository statusRepository, UsersRepository usersRepository, PermissionRepository permissionRepository, RolePermissionMapRepository rolePermissionMapRepository, PasswordEncoder passwordEncoder){
        this.roleRepository = roleRepository;
        this.statusRepository = statusRepository;
        this.usersRepository = usersRepository;
        this.permissionRepository = permissionRepository;
        this.rolePermissionMapRepository = rolePermissionMapRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void initializeSuperAdmin(){
        try {
            Roles superRole = createOrGetRole("SUPER_ADMIN");
            Status activeStatus = createOrGetStatus("ACTIVE");
            Permissions superPermission = createOrGetPermission("ALL");
            createRolePermissionMap(superRole, superPermission);
            createOrGetUser(superRole, activeStatus);
            logger.info("Super Admin initialization completed successfully.");
        }catch (Exception e){
            logger.info("Error during Super Admin initialization: {}", e.getMessage(), e);
        }
    }

    private Roles createOrGetRole(String roleName){
        return roleRepository.getRolesByName(roleName)
                .orElseGet(()-> {
                    Roles roles = new Roles();
                    roles.setId(1L);
                    roles.setName("SUPER_ADMIN");
                    roles.setDescription("Full platform access");
                    return roleRepository.save(roles);
                });
    }

    private Status createOrGetStatus(String status){
        return statusRepository.getStatusByName(status)
                .orElseGet(()-> {
                    Status statusObject = new Status();
                    statusObject.setId(1L);
                    statusObject.setName("ACTIVE");
                    statusObject.setDescription("Active");
                    return statusRepository.save(statusObject);
                });
    }

    private Permissions createOrGetPermission(String permission){
        return permissionRepository.getPermissionsByName(permission).
                orElseGet(()->{
                    Permissions permissionObject = new Permissions();
                    permissionObject.setId(1L);
                    permissionObject.setName("ALL");
                    permissionObject.setDescription("Super admin access");
                    return permissionRepository.save(permissionObject);
                });
    }

    private void createRolePermissionMap(Roles role, Permissions permission){
        if(!rolePermissionMapRepository.existsRolePermissionMapByRolesAndPermissions(role, permission)){
            RolePermissionMap rolePermissionMap = new RolePermissionMap();
            rolePermissionMap.setRoles(role);
            rolePermissionMap.setPermissions(permission);
            rolePermissionMapRepository.save(rolePermissionMap);
        }
    }

    private void createOrGetUser(Roles role, Status status){
        if(usersRepository.findByEmail("superadmin@system.com").isEmpty()){
            Users user = new Users();
            user.setFirstName("Super");
            user.setLastName("Admin");
            user.setEmail("superadmin@system.com");
            user.setMobileNumber("1111111111");
            user.setAddress("Bafal Chowk");
            user.setPassword(passwordEncoder.encode("superadmin"));
            user.setRole(role);
            user.setStatus(status);
            usersRepository.save(user);
            logger.info("Super Admin created successfully.");
        }else {
            logger.info("Super Admin already exists.");
        }
    }
}
