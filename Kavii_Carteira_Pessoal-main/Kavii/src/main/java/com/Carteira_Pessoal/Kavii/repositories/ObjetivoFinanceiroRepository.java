package com.Carteira_Pessoal.Kavii.repositories;

import com.Carteira_Pessoal.Kavii.domains.ObjetivoFinanceiro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ObjetivoFinanceiroRepository  extends JpaRepository<ObjetivoFinanceiro, Long> {


    Optional<ObjetivoFinanceiro> findByDescricaoObjetivo(String descricaoObjetivo);


}




