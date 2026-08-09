-- liquibase formatted sql

-- changeset rajottam.pradhan:VL-users-002
-- preconditions onFail:CONTINUE onError:HALT
-- precondition-sql-check expectedResult:1 SELECT COUNT(*) FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA = DATABASE() AND TABLE_NAME = 'users' AND COLUMN_NAME = 'user_type'
ALTER TABLE `users`
DROP COLUMN `user_type`;