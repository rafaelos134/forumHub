package com.alura.forumHub.dto;


import jakarta.validation.constraints.NotBlank;

public record DadosAutentificao(
        @NotBlank(message = "O nome de usuário é obrigatório.")
        String login,
        @NotBlank
        String senha
) {}

//import jakarta.validation.constraints.NotBlank;
//
//public record LoginRequest(
//        @NotBlank(message = "O nome de usuário é obrigatório.") String username,
//        @NotBlank(message = "A senha é obrigatória.") String password) {
//}
