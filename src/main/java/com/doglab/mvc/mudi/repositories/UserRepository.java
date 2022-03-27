package com.doglab.mvc.mudi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doglab.mvc.mudi.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	User findByUsername(String username);

}
