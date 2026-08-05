-- liquibase formatted sql

-- changeset rajottam.pradhan:VL-users-001
-- rollback DROP TABLE users;
CREATE TABLE IF NOT EXISTS `users` (
                                       `id`             BIGINT       NOT NULL AUTO_INCREMENT,
                                       `first_name`     VARCHAR(255) NOT NULL,
                                       `last_name`      VARCHAR(255) NOT NULL,
                                       `email`          VARCHAR(255) NOT NULL,
                                       `password`       VARCHAR(255) NOT NULL,
                                       `mobile_number`  VARCHAR(255) DEFAULT NULL,
                                       `address`        VARCHAR(255) NOT NULL,
                                       `role_id`        BIGINT       NOT NULL,
                                       `user_type`      VARCHAR(20)  NOT NULL,
                                       `status`         VARCHAR(20)  NOT NULL DEFAULT 'ACTIVE',
                                       `created_by`     BIGINT       DEFAULT NULL,
                                       `created_at`     TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                       `updated_at`     TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                       CONSTRAINT pk_users PRIMARY KEY (`id`),
                                       CONSTRAINT uc_users_email UNIQUE (`email`),
                                       CONSTRAINT fk_users_role FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
);