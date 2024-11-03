package com.example.demo.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.Login;
import com.example.demo.Repo.LoginRepo;

@RestController
public class LoginControllers {
	
	private final LoginRepo loginRepo;
	
	public LoginControllers(LoginRepo loginRepo) {
		this.loginRepo = loginRepo;
	}
	
	@GetMapping("/login")
	List<Login> all() {
		return loginRepo.findAll();
	}
	
	@GetMapping("/login/{id}")
	Optional<Login> one(@PathVariable Long id) {
	    return loginRepo.findById(id);
	}
	
	@PostMapping("/login")
	Login newLogin(@RequestBody Login newLogin) {
	    return loginRepo.save(newLogin);
	}
	
	@PutMapping("/login/{id}")
	Login replaceLogin(@RequestBody Login newLogin, @PathVariable Long id) {
	    
	    return loginRepo.findById(id)
	      .map(login -> {
	    	  login.setEmail(newLogin.getEmail());
	    	  login.setSenha(newLogin.getSenha());
	        return loginRepo.save(login);
	      })
	      .orElseGet(() -> {
	        return loginRepo.save(newLogin);
	      });
	  }
	
	@DeleteMapping("/login/{id}")
	void deleteLogin(@PathVariable Long id) {
		loginRepo.deleteById(id);
	}
	
}
