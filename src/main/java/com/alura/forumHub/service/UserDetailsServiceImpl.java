//package com.alura.forumHub.service;
//
//import com.alura.forumHub.model.Usuario;
//import com.alura.forumHub.repository.UsuarioRepository;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    private final UsuarioRepository usuarioRepository;
//
//    public UserDetailsServiceImpl(UsuarioRepository usuarioRepository) {
//        this.usuarioRepository = usuarioRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Usuario usuario = usuarioRepository.findByUsername(username)
//                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username));
//        return User.builder()
//                .username(usuario.getUsername())
//                .password(usuario.getPassword())
//                .roles("USER") // Role padrão
//                .build();
//    }
//}
