-- liquibase formatted sql

-- changeset rajottam.pradhan:VL-roles-001
-- rollback DROP TABLE roles;
CREATE TABLE IF NOT EXISTS `roles` (
                       `id`          BIGINT          NOT NULL AUTO_INCREMENT,
                       `name`        VARCHAR(50)     NOT NULL UNIQUE,
                       `description` VARCHAR(255),
                       `created_at`  TIMESTAMP       NOT NULL DEFAULT CURRENT_TIMESTAMP,
                       CONSTRAINT pk_roles PRIMARY KEY (`id`)
);
