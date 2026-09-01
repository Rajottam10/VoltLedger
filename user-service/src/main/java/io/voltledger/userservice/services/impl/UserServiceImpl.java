package io.voltledger.userservice.services.impl;

import io.voltledger.userservice.entities.Users;
import io.voltledger.userservice.repositories.UsersRepository;
import io.voltledger.userservice.services.UserService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UsersRepository usersRepository;

    public UserServiceImpl(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    @Override
    public Users findByEmail(String email) {
        return usersRepository.findByEmail(email).orElseThrow(()-> new NullPointerException("User with the email "+ email+" couldn't be found."));
    }
}
