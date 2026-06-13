-- liquibase formatted sql

-- changeset rajottam.pradhan:VL-001
CREATE TABLE roles (
                       id          BIGINT          NOT NULL AUTO_INCREMENT,
                       name        VARCHAR(50)     NOT NULL UNIQUE,
                       description VARCHAR(255),
                       created_at  TIMESTAMP       NOT NULL DEFAULT CURRENT_TIMESTAMP,
                       CONSTRAINT pk_roles PRIMARY KEY (id)
);
