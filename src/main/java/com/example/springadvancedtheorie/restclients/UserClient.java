package com.example.springadvancedtheorie.restclients;

import com.example.springadvancedtheorie.records.User;

import java.util.Optional;

public interface UserClient {
    Optional<User> findById(long id);
}
