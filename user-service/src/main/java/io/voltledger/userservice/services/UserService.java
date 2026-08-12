package io.voltledger.userservice.services;

import io.voltledger.userservice.entities.Users;

public interface UserService {
    Users findByEmail(String email);
}
