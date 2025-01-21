package com.alura.forumHub.model;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotEmpty;



@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String nome;

    @NotEmpty
    private String email;

    @NotEmpty
    private String senha;

    @Column(unique = true)
    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Getters e setters
}
