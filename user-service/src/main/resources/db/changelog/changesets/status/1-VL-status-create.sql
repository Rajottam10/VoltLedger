-- liquibase formatted sql

-- changeset rajottam.pradhan:VL-roles-001
-- rollback DROP TABLE status;

CREATE TABLE IF NOT EXISTS status
(
    `id`             BIGINT       NOT NULL AUTO_INCREMENT,
    `name`          VARCHAR(255)          NOT NULL,
    `description` VARCHAR(255)          NOT NULL,
    CONSTRAINT pk_status PRIMARY KEY (id)
    );