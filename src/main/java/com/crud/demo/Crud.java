package com.crud.demo;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Crud {
	@Autowired
	private Repo repo;
	

	@PostMapping("/insert")
	@CrossOrigin(origins = "http://127.0.0.1:5500")
	public  Users add(@RequestBody Users users) {
		
		
		Timestamp ts = new Timestamp(new Date().getTime());
		
		users.setCreateDate(ts);
		users.setModifyDate(ts);
		System.out.println("successfully inserted");
		return repo.save(users);
	}
	@GetMapping("/viewusers")
	@CrossOrigin(origins = "http://127.0.0.1:5500")
	public List<Users> display(){
		System.out.println("successfully fetched");
		System.out.println(repo.findAllByOrderByModifyDateDesc());
		return repo.findAllByOrderByModifyDateDesc();
	}
	
	@DeleteMapping("/deleteuser/{email}")
	@CrossOrigin(origins = "http://127.0.0.1:5500")
	public String deleteuser(@PathVariable String email){
		Optional<Users> user=repo.findById(email);
		System.out.println("from delete api");
			repo.deleteById(email);
			return "found";
	}
	
	@GetMapping("/checkemail/{email}")
	@CrossOrigin(origins = "http://127.0.0.1:5500")
	public boolean emailExist(@PathVariable String email) {
		Optional<Users> user=repo.findById(email);
		if(user.isPresent()) {
			System.out.println("exist");
			return true;
		}
		return false;
	}
	@GetMapping("/editdata/{email}")
	@CrossOrigin(origins = "http://127.0.0.1:5500")
	public Optional<Users> editData(@PathVariable String email) {
		Optional<Users> user=repo.findById(email);
		System.out.println(user);
		return user;
	}
	
	@PutMapping("/update/{email}")
	@CrossOrigin()
	public void updateData(@PathVariable String email, @RequestBody Users updatedUser) {
	    Optional<Users> existingUser = repo.findById(email);

	        Users userToUpdate = existingUser.get();
	        userToUpdate.setFname(updatedUser.getFname());
	        userToUpdate.setLname(updatedUser.getLname());
	        userToUpdate.setDob(updatedUser.getDob());
	        userToUpdate.setAddress(updatedUser.getAddress());
	        userToUpdate.setmobNo(updatedUser.getmobNo());

	        Timestamp ts = new Timestamp(new Date().getTime());
	        userToUpdate.setModifyDate(ts);
	        System.out.println("edited");
	        repo.save(userToUpdate);

	}
	
}
