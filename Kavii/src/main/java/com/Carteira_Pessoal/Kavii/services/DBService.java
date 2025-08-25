package com.Carteira_Pessoal.Kavii.services;

import com.Carteira_Pessoal.Kavii.domains.*;
import com.Carteira_Pessoal.Kavii.domains.enums.StatusMeta;
import com.Carteira_Pessoal.Kavii.domains.enums.TipoConta;
import com.Carteira_Pessoal.Kavii.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DBService {

    @Autowired
    private UsuarioRepository usRepo;

    @Autowired
    private BancoRepository bancoRepo;

    @Autowired
    private PessoaRepository pessoaRepo;

    @Autowired
    private MetaFinanceiraRepository metaRepo;

    @Autowired
    private CentroCustoRepository centroRepo;

    @Autowired
    private ContaRepository contaRepo;

    @Autowired
    private PasswordEncoder encoder;

    public void initDB(){
        Usuario usuario1 = new Usuario(null, "Pedro", "pedro@gmail.com", encoder.encode("123"), LocalDate.now() );
        Usuario usuario2 = new Usuario(null, "Igor", "igor@gmail.com", encoder.encode("123"), LocalDate.now() );

        usRepo.save(usuario1);
        usRepo.save(usuario2);

        Banco banco01 = new Banco(null, "Nu Pagamentos S.A");
        Banco banco02 = new Banco(null, "Banco Santander (Brasil) S.A");

        bancoRepo.save(banco01);
        bancoRepo.save(banco02);


        MetaFinanceira metaFinanceira01 = new MetaFinanceira(null, "Casa",  "13/09/2027", 60000.0, StatusMeta.EMANDAMENTO);
        MetaFinanceira metaFinanceira02 = new MetaFinanceira(null, "Apartamento",  "17/08/2026", 20000.0, StatusMeta.CONQUISTADA);

        metaRepo.save(metaFinanceira01);
        metaRepo.save(metaFinanceira02);


        CentroCusto centroCusto01 = new CentroCusto(null, "Centro01");
        CentroCusto centroCusto02 = new CentroCusto(null, "Centro02");

        centroRepo.save(centroCusto01);
        centroRepo.save(centroCusto02);


        Pessoa pessoa01 = new Pessoa(null, "Razao01");
        Pessoa pessoa02 = new Pessoa(null, "Razao02");

        pessoaRepo.save(pessoa01);
        pessoaRepo.save(pessoa02);


        Conta conta01 = new Conta(null, "Conta01", TipoConta.CONTACORRENTE, "Agencia01", "Numero : 1", 1000.0, 10000.0, usuario1, banco01, metaFinanceira01 );
        Conta conta02 = new Conta(null, "Conta02", TipoConta.CONTACORRENTE, "Agencia02", "Numero : 2", 5000.0, 50000.0, usuario2, banco02, metaFinanceira02 );

        contaRepo.save(conta01);
        contaRepo.save(conta02);

    }







}