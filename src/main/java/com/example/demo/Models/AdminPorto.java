package com.example.demo.Models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_admin_porto")
public class AdminPorto {

	private @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_admin;
    
    private String nome_admin;
    
    private Integer cpf_admin;
    
    @ManyToOne
    @JoinColumn(name = "id_login", nullable = false)
    private Login login;

    public AdminPorto() {
        super();
    }

    public AdminPorto(String nome_admin, Integer cpf_admin, Login login) {
        this.nome_admin = nome_admin;
        this.cpf_admin = cpf_admin;
        this.login = login;
    }

    public Long getIdAdmin() {
        return id_admin;
    }

    public void setIdAdmin(Long id_admin) {
        this.id_admin = id_admin;
    }

    public String getNomeAdmin() {
        return nome_admin;
    }

    public void setNomeAdmin(String nome_admin) {
        this.nome_admin = nome_admin;
    }

    public Integer getCpfAdmin() {
        return cpf_admin;
    }

    public void setCpfAdmin(Integer cpf_admin) {
        this.cpf_admin = cpf_admin;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}
