package com.Carteira_Pessoal.Kavii.repositories;

import com.Carteira_Pessoal.Kavii.domains.CentroCusto;
import com.Carteira_Pessoal.Kavii.domains.ObjetivoFinanceiro;
import com.Carteira_Pessoal.Kavii.domains.dtos.CentroCustoDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CentroCustoRepository extends JpaRepository<CentroCusto, Long> {

    Optional<CentroCusto> findByDescricaoCentro(String descricaoCentro);

}
