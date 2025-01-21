package com.alura.forumHub.controler;

import com.alura.forumHub.dto.DadosAutentificao;
import com.alura.forumHub.model.Usuario;
import com.alura.forumHub.security.tokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.token.TokenService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private tokenService tokenServices;

    @PostMapping
    public ResponseEntity efetualogin(@RequestBody @Valid DadosAutentificao dados){
        var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authetication = manager.authenticate(token);

        return ResponseEntity.ok(tokenServices.gerarToken((Usuario) authetication.getPrincipal()));
    }
//    private final AuthenticationManager authenticationManager;
//
//    public AuthController(AuthenticationManager authenticationManager) {
//        this.authenticationManager = authenticationManager;
//    }
//
//    @PostMapping("/login")
//    public String login(@RequestBody @Valid LoginRequest loginRequest) {
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password()));
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        return "Login bem-sucedido!";
//    }
}
