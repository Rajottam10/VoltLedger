-- liquibase formatted sql

-- changeset rajottam.pradhan:VL-permissions-002
-- preconditions onFail:CONTINUE onError:HALT
-- precondition-sql-check expectedResult:0 SELECT COUNT(*) FROM permissions
INSERT INTO permissions (name, description) VALUES
                                                ('ALL', 'Super admin access'),
                                                ('VIEW', 'Access to view'),
                                                ('CREATE', 'Access to create'),
                                                ('UPDATE', 'Access to update'),
                                                ('DELETE', 'Access to delete');