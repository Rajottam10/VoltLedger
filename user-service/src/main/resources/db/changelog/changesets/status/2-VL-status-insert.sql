-- liquibase formatted sql

-- changeset rajottam.pradhan:VL-status-002
-- preconditions onFail:CONTINUE onError:HALT
-- precondition-sql-check expectedResult:0 SELECT COUNT(*) FROM status
INSERT INTO permissions (name, description) VALUES
                                                ('ACTIVE', 'Active'),
                                                ('DELETE', 'Delete');