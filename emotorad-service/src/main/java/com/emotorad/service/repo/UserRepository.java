package com.emotorad.service.repo;

import com.emotorad.service.repo.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

    User findByEmail(String email);
}
