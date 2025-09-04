package com.Carteira_Pessoal.Kavii.services;

import com.Carteira_Pessoal.Kavii.domains.Banco;
import com.Carteira_Pessoal.Kavii.domains.Conta;
import com.Carteira_Pessoal.Kavii.domains.ObjetivoFinanceiro;
import com.Carteira_Pessoal.Kavii.domains.Usuario;
import com.Carteira_Pessoal.Kavii.domains.dtos.ContaDTO;
import com.Carteira_Pessoal.Kavii.repositories.BancoRepository;
import com.Carteira_Pessoal.Kavii.repositories.ContaRepository;

import com.Carteira_Pessoal.Kavii.repositories.ObjetivoFinanceiroRepository;
import com.Carteira_Pessoal.Kavii.repositories.UsuarioRepository;
import com.Carteira_Pessoal.Kavii.services.exceptions.DataIntegrityViolationException;
import com.Carteira_Pessoal.Kavii.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContaService {

    @Autowired
    private UsuarioRepository usuRepo;

    @Autowired
    private BancoRepository bancoRepo;

    @Autowired
    private ObjetivoFinanceiroRepository ObjetivoRepo;

    @Autowired
    private ContaRepository contaRepo;


    public List<ContaDTO> findAll(){
        return contaRepo.findAll().stream().map(obj -> new ContaDTO(obj)).collect(Collectors.toList());
    }

    public Conta findbyId(Long id){
        Optional<Conta> obj = contaRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Conta não encontrado Id:" + id));
    }

    public Conta findbyDescricao(String descricao){
        Optional<Conta> obj = contaRepo.findByDescricao(descricao);
        return obj.orElseThrow(() -> new  ObjectNotFoundException("Conta não encontrado Descricao:" + descricao));
    }

    public Conta create(ContaDTO dto){
        dto.setIdConta(null);
        validaConta(dto);
        Conta obj = new Conta(dto);
        return contaRepo.save(obj);
    }

    private void validaConta(ContaDTO dto){
        Optional<Conta> obj = contaRepo.findByDescricao(dto.getDescricao());
        if(obj.isPresent() && obj.get().getIdConta() != dto.getIdConta()){
            throw new DataIntegrityViolationException("Descrição já cadastrada");
        }


        Optional<Usuario> usuario = usuRepo.findById(dto.getUsuario());
        if(!usuario.isPresent()){
            throw new DataIntegrityViolationException("Usuario - " + dto.getUsuario() + "não esta cadastrado");
        }

        Optional<Banco> banco = bancoRepo.findById(dto.getBanco());
        if(!banco.isPresent()){
            throw new DataIntegrityViolationException("Banco - " + dto.getBanco() + "não esta cadastrado");
        }

        Optional<ObjetivoFinanceiro> objetivoFinanceiro = ObjetivoRepo.findById(dto.getObjetivoFinanceiro());
        if(!objetivoFinanceiro.isPresent()){
            throw new DataIntegrityViolationException("Objetivo Financeiro- " + dto.getObjetivoFinanceiro() + "não esta cadastrado");
        }
    }

    public Conta update(Long id, ContaDTO objDto){
        objDto.setIdConta(id);
        Conta oldObj = findbyId(id);
        oldObj = new Conta(objDto);
        validaConta(objDto);
        return  contaRepo.save(oldObj);
    }

    public void delete(Long id){
        Conta obj = findbyId(id);
        contaRepo.deleteById(id);
    }




}
