package io.voltledger.userservice.services;

public interface AuthService {
    String login(String email, String password);
}
