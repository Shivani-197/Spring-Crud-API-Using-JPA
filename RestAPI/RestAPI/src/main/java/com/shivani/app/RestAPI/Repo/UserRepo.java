package com.shivani.app.RestAPI.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivani.app.RestAPI.Models.Users;

public interface UserRepo extends JpaRepository<Users, Long> {

	

	

	

}
