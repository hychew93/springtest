package com.springtest.search2.repo;
import org.springframework.data.repository.CrudRepository;

import com.springtest.search2.model.User;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {

}
