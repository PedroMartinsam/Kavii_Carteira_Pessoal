package com.Carteira_Pessoal.Kavii.services;

import com.Carteira_Pessoal.Kavii.domains.Usuario;
import com.Carteira_Pessoal.Kavii.repositories.UsuarioRepository;
import com.Carteira_Pessoal.Kavii.security.UserSS;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpI implements UserDetailsService {

    private final UsuarioRepository usuarioRepo;

    public UserDetailsServiceImpI(UsuarioRepository usuarioRepository){
        this.usuarioRepo = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Optional<Usuario> user = usuarioRepo.findByEmailUsuario(username);
        if(user.isEmpty()){
            throw  new UsernameNotFoundException("Usuario nao encontrado: " + username);
        }
        return  new UserSS(user.orElse(null));
    }

}