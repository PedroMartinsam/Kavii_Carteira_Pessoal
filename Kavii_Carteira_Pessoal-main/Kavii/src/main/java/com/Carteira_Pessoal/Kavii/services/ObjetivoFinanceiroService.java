package com.Carteira_Pessoal.Kavii.services;

import com.Carteira_Pessoal.Kavii.domains.ObjetivoFinanceiro;
import com.Carteira_Pessoal.Kavii.repositories.ObjetivoFinanceiroRepository;
import com.Carteira_Pessoal.Kavii.services.exceptions.DataIntegrityViolationException;
import com.Carteira_Pessoal.Kavii.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Objetivo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ObjetivoFinanceiroService {

    @Autowired
    private ObjetivoFinanceiroRepository ObjetivoRepo;

    public List<ObjetivoFinanceiroDTO> findAll(){
        return ObjetivoRepo.findAll().stream().map(obj -> new ObjetivoFinanceiroDTO(obj)).collect(Collectors.toUnmodifiableList());
    }

    public ObjetivoFinanceiro findbyId(Long id){
        Optional<ObjetivoFinanceiro> obj = ObjetivoRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objetivo Financeiro  não encontrado! Id: " + id));
    }

    public ObjetivoFinanceiro findByDescricaoObjetivo (String descricaoObjetivo){
        Optional<ObjetivoFinanceiro> obj = ObjetivoRepo.findByDescricaoObjetivo (descricaoObjetivo);
        return obj.orElseThrow(() -> new ObjectNotFoundException(" Deescriçao da Objetivo Financeiro não encontrado! ObjetivoFinanceiro: " + descricaoObjetivo));
    }


    public ObjetivoFinanceiro create(ObjetivoFinanceiroDTO dto){
        dto.setIdObjetivo(null);
        ObjetivoFinanceiro obj = new ObjetivoFinanceiro(dto);
        return ObjetivoRepo.save(obj);
    }

    public ObjetivoFinanceiro update(Long id, ObjetivoFinanceiroDTO objDto){
        objDto.setIdObjetivo(id);
        ObjetivoFinanceiro oldObj = findbyId(id);
        oldObj = new ObjetivoFinanceiro(objDto);
        return objetivoRepo.save(oldObj);
    }

    public void delete(Long id){
        ObjetivoFinanceiro obj = findbyId(id);
        if(obj.getContas().size()>0){
            throw new DataIntegrityViolationException("Objetivo Financeiro não pode ser excluido pois tem uma conta vinculado com ele");
        }
        ObjetivoRepo.deleteById(id);
    }

}
