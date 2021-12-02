package com.shivani.app.RestAPI.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shivani.app.RestAPI.Models.Users;
import com.shivani.app.RestAPI.Repo.UserRepo;

@RestController
public class ApiControllers {
	
	@Autowired
	private UserRepo userRepo;
	
	@GetMapping(value="/")
	public String getPage() {
		return "Welcome";
	}
	
	@GetMapping(value="/users")
	public List<Users> getUsers() {
		return  userRepo.findAll();
	}
	
	@PostMapping(value="/save")
	public String saveUser(@RequestBody Users user) {
		userRepo.save(user);
		return "Saved...";		
		}
	@PutMapping(value="update/{id}")
	public String updateUser(@PathVariable long id, @RequestBody Users user) {
		Users updatedUser=userRepo.findById(id).get();
		updatedUser.setFirstName(user.getFirstName());
		updatedUser.setLastName(user.getLastName());
		updatedUser.setOccupation(user.getOccupation());
		updatedUser.setAge(user.getAge());
		userRepo.save(updatedUser);
		return "Updated successully!";
		
	}
	
	@DeleteMapping(value="/delete/{id}")
	public String deleteUser(@PathVariable long id ) {
		Users deleteUser= userRepo.findById(id).get();
		userRepo.delete(deleteUser);
		return "Delete user with the id:" +id;
	}

}
