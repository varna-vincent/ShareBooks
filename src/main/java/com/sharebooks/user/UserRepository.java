package com.sharebooks.user;

import com.sharebooks.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.Nullable;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Long> {

    @Nullable
    User findByEmail(String email);
}