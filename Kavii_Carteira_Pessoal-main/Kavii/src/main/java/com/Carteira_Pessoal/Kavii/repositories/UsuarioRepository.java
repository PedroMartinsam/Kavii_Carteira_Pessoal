package com.Carteira_Pessoal.Kavii.repositories;

import com.Carteira_Pessoal.Kavii.domains.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


    Optional<Usuario> findByEmailUsuario(String emailUsuario);



}
