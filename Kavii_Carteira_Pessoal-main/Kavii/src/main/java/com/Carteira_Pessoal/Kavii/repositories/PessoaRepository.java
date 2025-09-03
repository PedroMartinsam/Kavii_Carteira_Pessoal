package com.Carteira_Pessoal.Kavii.repositories;

import com.Carteira_Pessoal.Kavii.domains.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PessoaRepository extends JpaRepository <Pessoa, Long>{


    Optional<Pessoa> findByRazaoSocial(String razaoSocial);

}