package com.alura.forumHub.security;

import com.alura.forumHub.model.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class tokenService {

    public String gerarToken(Usuario usuario){
        try{
            var algoritimo = Algorithm.HMAC256("12345678");
            return JWT.create().withIssuer("API aluraHUb")
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(dataExpiracao())
                    .sign(algoritimo);

        }catch (JWTCreationException exception){
            throw new RuntimeException("erro ao gerar token jwt", exception);
        }
    }

    public String getSubject(String tokenJWT){
        try{
            var algoritimo = Algorithm.HMAC256("12345678");
            return JWT.require(algoritimo)
                    .withIssuer("API aluraHUb")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();

        }catch (JWTCreationException exception){
            throw new RuntimeException("Token invalido ou expirado", exception);
        }
    }
    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
