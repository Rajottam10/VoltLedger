--liquibase formatted sql

--changeset rajottam.pradhan:VL-roles-002
--preconditions onFail:CONTINUE onError:HALT
--precondition-sql-check expectedResult:0 SELECT COUNT(*) FROM roles
INSERT INTO roles (name, description) VALUES
                                          ('SUPER_ADMIN', 'Full platform access'),
                                          ('LANDLORD',    'Manages properties and tenants'),
                                          ('TENANT',      'Read-only bill access');
