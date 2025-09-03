package com.Carteira_Pessoal.Kavii.services;

import com.Carteira_Pessoal.Kavii.domains.Banco;
import com.Carteira_Pessoal.Kavii.domains.Pessoa;
import com.Carteira_Pessoal.Kavii.domains.dtos.BancoDTO;
import com.Carteira_Pessoal.Kavii.domains.dtos.PessoaDTO;
import com.Carteira_Pessoal.Kavii.repositories.BancoRepository;
import com.Carteira_Pessoal.Kavii.repositories.PessoaRepository;
import com.Carteira_Pessoal.Kavii.services.exceptions.DataIntegrityViolationException;
import com.Carteira_Pessoal.Kavii.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepo;

    public List<PessoaDTO> findAll(){
        return pessoaRepo.findAll().stream().map(obj -> new PessoaDTO(obj)).collect(Collectors.toUnmodifiableList());
    }

    public Pessoa findbyId(Long id){
        Optional<Pessoa> obj = pessoaRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Pessoa não encontrado! Id: " + id));
    }


    public Pessoa findByRazaoSocial (String razaoSocial){
        Optional<Pessoa> obj = pessoaRepo.findByRazaoSocial (razaoSocial);
        return obj.orElseThrow(() -> new ObjectNotFoundException(" Razão Social não encontrado! Razão Social: " + razaoSocial));
    }

    public Pessoa create(PessoaDTO dto){
        dto.setIdPessoa(null);
        validaPessoa(dto);
        Pessoa obj = new Pessoa(dto);
        return pessoaRepo.save(obj);
    }




    private void validaPessoa(PessoaDTO dto){
        Optional<Pessoa> obj = pessoaRepo.findByRazaoSocial(dto.getRazaoSocial());
        if(obj.isPresent() && obj.get().getIdPessoa() != dto.getIdPessoa()){
            throw new DataIntegrityViolationException("Razão Social já cadastrado");
        }
    }


    public Pessoa update(Long id, PessoaDTO objDto){
        objDto.setIdPessoa(id);
        Pessoa oldObj = findbyId(id);
        oldObj = new Pessoa(objDto);
        return pessoaRepo.save(oldObj);
    }

    public void delete(Long id){
        Pessoa obj = findbyId(id);
        pessoaRepo.deleteById(id);
    }





}
