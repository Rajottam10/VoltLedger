package io.voltledger.userservice.security;

public record CallerPrincipal(Long userId, String email, String userType) {
}