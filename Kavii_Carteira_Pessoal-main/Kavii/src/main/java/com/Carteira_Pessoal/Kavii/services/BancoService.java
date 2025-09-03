package com.Carteira_Pessoal.Kavii.services;

import com.Carteira_Pessoal.Kavii.domains.Banco;
import com.Carteira_Pessoal.Kavii.domains.Usuario;
import com.Carteira_Pessoal.Kavii.domains.dtos.BancoDTO;
import com.Carteira_Pessoal.Kavii.domains.dtos.UsuarioDTO;
import com.Carteira_Pessoal.Kavii.repositories.BancoRepository;
import com.Carteira_Pessoal.Kavii.resources.BancoResource;
import com.Carteira_Pessoal.Kavii.services.exceptions.DataIntegrityViolationException;
import com.Carteira_Pessoal.Kavii.services.exceptions.ObjectNotFoundException;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BancoService {

    @Autowired
    private BancoRepository bancoRepo;

    public List<BancoDTO> findAll(){
        return bancoRepo.findAll().stream().map(obj -> new BancoDTO(obj)).collect(Collectors.toUnmodifiableList());
    }

    public Banco findbyId(Long id){
        Optional<Banco> obj = bancoRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Banco não encontrado! Id: " + id));
    }


    public Banco findByRazaoSocial (String razaoSocial){
        Optional<Banco> obj = bancoRepo.findByRazaoSocial (razaoSocial);
        return obj.orElseThrow(() -> new ObjectNotFoundException(" Razão Social não encontrado! Razão Social: " + razaoSocial));
    }

    public Banco create(BancoDTO dto){
        dto.setIdBanco(null);
        validaBanco(dto);
        Banco obj = new Banco(dto);
        return bancoRepo.save(obj);
    }




    private void validaBanco(BancoDTO dto){
        Optional<Banco> obj = bancoRepo.findByRazaoSocial(dto.getRazaoSocial());
        if(obj.isPresent() && obj.get().getIdBanco() != dto.getIdBanco()){
            throw new DataIntegrityViolationException("Razão Social já cadastrado");
        }
    }


    public Banco update(Long id, BancoDTO objDto){
        objDto.setIdBanco(id);
        Banco oldObj = findbyId(id);
        oldObj = new Banco(objDto);
        return bancoRepo.save(oldObj);
    }

    public void delete(Long id){
        Banco obj = findbyId(id);
        if(obj.getContas().size()>0){
            throw new DataIntegrityViolationException("Banco não pode ser excluido pois tem uma conta vinculado com ele");
        }
        bancoRepo.deleteById(id);
    }

}

