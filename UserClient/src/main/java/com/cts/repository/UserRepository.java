package com.cts.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cts.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

	@Query("select user_id from User u where u.email=:username")
	public Long getIdByUsername(@Param(value = "username")String username);

}
