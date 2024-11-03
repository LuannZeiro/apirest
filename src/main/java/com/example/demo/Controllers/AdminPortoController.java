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

import com.example.demo.Models.AdminPorto;
import com.example.demo.Repo.AdminPortoRepo;

@RestController
public class AdminPortoController {
	private final AdminPortoRepo adminPortoRepo;

    public AdminPortoController(AdminPortoRepo adminPortoRepo) {
        this.adminPortoRepo = adminPortoRepo;
    }

    @GetMapping("/adminPorto")
    List<AdminPorto> all() {
        return adminPortoRepo.findAll();
    }

    @GetMapping("/adminPorto/{id}")
    Optional<AdminPorto> one(@PathVariable Long id) {
        return adminPortoRepo.findById(id);
    }

    @PostMapping("/adminPorto")
    AdminPorto newAdminPorto(@RequestBody AdminPorto newAdminPorto) {
        return adminPortoRepo.save(newAdminPorto);
    }

    @PutMapping("/adminPorto/{id}")
    AdminPorto replaceAdminPorto(@RequestBody AdminPorto newAdminPorto, @PathVariable Long id) {

        return adminPortoRepo.findById(id)
            .map(adminPorto -> {
                adminPorto.setNomeAdmin(newAdminPorto.getNomeAdmin());
                adminPorto.setCpfAdmin(newAdminPorto.getCpfAdmin());
                adminPorto.setLogin(newAdminPorto.getLogin());
                return adminPortoRepo.save(adminPorto);
            })
            .orElseGet(() -> adminPortoRepo.save(newAdminPorto));
    }

    @DeleteMapping("/adminPorto/{id}")
    void deleteAdminPorto(@PathVariable Long id) {
        adminPortoRepo.deleteById(id);
    }
}
