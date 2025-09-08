package com.Carteira_Pessoal.Kavii.services;

import com.Carteira_Pessoal.Kavii.domains.Lancamento;
import com.Carteira_Pessoal.Kavii.domains.dtos.LancamentoDTO;
import com.Carteira_Pessoal.Kavii.repositories.LancamentoRepository;
import com.Carteira_Pessoal.Kavii.services.exceptions.ObjectNotFoundException;
import com.Carteira_Pessoal.Kavii.domains.enums.TipoLancamento;
import com.Carteira_Pessoal.Kavii.domains.enums.Situacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository repo;

    public Lancamento find(Integer id) {
        Optional<Lancamento> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Lancamento.class.getName()));
    }

    public Lancamento insert(Lancamento obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Lancamento update(Lancamento obj) {
        find(obj.getId());
        return repo.save(obj);
    }

    public void delete(Integer id) {
        find(id);
        repo.deleteById(id);
    }

    public Lancamento fromDTO(LancamentoDTO objDto) {
        Lancamento lancamento = new Lancamento();
        lancamento.setId(objDto.getId());
        lancamento.setDescricao(objDto.getDescricao());
        lancamento.setParcela(objDto.getParcela());
        lancamento.setDataLancamento(objDto.getDataLancamento());
        lancamento.setDataVencimento(objDto.getDataVencimento());
        lancamento.setDataBaixa(objDto.getDataBaixa());
        lancamento.setValorDocumento(objDto.getValorDocumento());
        lancamento.setTipoLancamento(TipoLancamento.toEnum(objDto.getTipoLancamento()));
        lancamento.setSituacao(Situacao.toEnum(objDto.getSituacao()));
        return lancamento;
    }
}

