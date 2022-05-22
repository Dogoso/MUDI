package com.doglab.mvc.mudi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.doglab.mvc.mudi.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

	User findByUsername(String username);

}
