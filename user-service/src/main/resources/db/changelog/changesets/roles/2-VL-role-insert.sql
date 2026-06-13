--liquibase formatted sql

--changeset rajottam.pradhan: VL-002
INSERT INTO roles (name, description) VALUES
                                          ('SUPER_ADMIN', 'Full platform access'),
                                          ('LANDLORD',    'Manages properties and tenants'),
                                          ('TENANT',      'Read-only bill access');
