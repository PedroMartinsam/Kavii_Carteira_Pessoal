package com.Carteira_Pessoal.Kavii.services;

import com.Carteira_Pessoal.Kavii.domains.MetaFinanceira;
import com.Carteira_Pessoal.Kavii.repositories.MetaFinanceiraRepository;
import com.Carteira_Pessoal.Kavii.services.exceptions.DataIntegrityViolationException;
import com.Carteira_Pessoal.Kavii.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Meta;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ObjetivoFinanceiraService {

    @Autowired
    private ObjetivoFinanceiraRepository metaRepo;

    public List<ObjetivoFinanceiraDTO> findAll(){
        return ObjetivoRepo.findAll().stream().map(obj -> new ObjetivoFinanceiraDTO(obj)).collect(Collectors.toUnmodifiableList());
    }

    public ObjetivoFinanceira findbyId(Long id){
        Optional<MetaFinanceira> obj = metaRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Meta financeira  não encontrado! Id: " + id));
    }

    public MetaFinanceira findByDescricaoMeta (String descricaoMeta){
        Optional<MetaFinanceira> obj = metaRepo.findByDescricaoMeta (descricaoMeta);
        return obj.orElseThrow(() -> new ObjectNotFoundException(" Deescriçao da meta financeira não encontrado! Meta Fianceira: " + descricaoMeta));
    }


    public MetaFinanceira create(MetaFinanceiraDTO dto){
        dto.setIdMeta(null);
        MetaFinanceira obj = new MetaFinanceira(dto);
        return metaRepo.save(obj);
    }

    public MetaFinanceira update(Long id, MetaFinanceiraDTO objDto){
        objDto.setIdMeta(id);
        MetaFinanceira oldObj = findbyId(id);
        oldObj = new MetaFinanceira(objDto);
        return metaRepo.save(oldObj);
    }

    public void delete(Long id){
        MetaFinanceira obj = findbyId(id);
        if(obj.getContas().size()>0){
            throw new DataIntegrityViolationException("Meta financeira não pode ser excluido pois tem uma conta vinculado com ele");
        }
        metaRepo.deleteById(id);
    }

}
