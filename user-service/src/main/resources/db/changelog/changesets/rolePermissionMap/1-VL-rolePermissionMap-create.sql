-- liquibase formatted sql

-- changeset rajottam.pradhan:VL-role-permissions-001
-- rollback DROP TABLE role_permissions;
CREATE TABLE IF NOT EXISTS `role_permissions` (
                                                  `id`            BIGINT NOT NULL AUTO_INCREMENT,
                                                  `role_id`       BIGINT NOT NULL,
                                                  `permission_id` BIGINT NOT NULL,
                                                  CONSTRAINT pk_role_permissions PRIMARY KEY (`id`),
    CONSTRAINT uc_role_permissions_role_permission UNIQUE (`role_id`, `permission_id`),
    CONSTRAINT fk_role_permissions_role FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
    CONSTRAINT fk_role_permissions_permission FOREIGN KEY (`permission_id`) REFERENCES `permissions` (`id`)
    );