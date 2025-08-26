package com.Carteira_Pessoal.Kavii.repositories;

import com.Carteira_Pessoal.Kavii.domains.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContaRepository extends JpaRepository<Conta, Long> {

    Optional<Conta> findByDescricao(String descricao);


}

