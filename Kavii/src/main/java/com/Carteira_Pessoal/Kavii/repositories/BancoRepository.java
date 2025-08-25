package com.Carteira_Pessoal.Kavii.repositories;



import com.Carteira_Pessoal.Kavii.domains.Banco;
import com.Carteira_Pessoal.Kavii.domains.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BancoRepository extends JpaRepository <Banco, Long> {


    Optional<Banco> findByRazaoSocial(String razaoSocial);


}
