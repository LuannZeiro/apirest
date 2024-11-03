package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_login")
public class Login {
	
	private @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id_login;
	
	private String email;
	private String senha;
	
	public Login(){
		   super();
	}
	
	  public Long getIdLogin() {
	       return  id_login;
	    }
	
    public Login(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }
	
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
	
}
