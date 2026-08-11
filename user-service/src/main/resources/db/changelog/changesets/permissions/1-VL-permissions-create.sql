-- liquibase formatted sql

-- changeset rajottam.pradhan:VL-permissions-001
-- rollback DROP TABLE permissions;
CREATE TABLE IF NOT EXISTS `permissions` (
                                             `id`          BIGINT       NOT NULL AUTO_INCREMENT,
                                             `name`        VARCHAR(100) NOT NULL,
    `description` VARCHAR(255) DEFAULT NULL,
    `created_at`  datetime(6)    DEFAULT NULL,
    CONSTRAINT pk_permissions PRIMARY KEY (`id`),
    CONSTRAINT uc_permissions_name UNIQUE (`name`)
    );