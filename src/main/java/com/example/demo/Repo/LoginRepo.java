package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Models.Login;

public interface LoginRepo extends JpaRepository<Login, Long>{

}
