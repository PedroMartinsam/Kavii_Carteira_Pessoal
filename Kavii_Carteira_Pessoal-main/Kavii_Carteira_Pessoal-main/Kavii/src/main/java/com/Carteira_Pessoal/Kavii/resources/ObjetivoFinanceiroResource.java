package com.Carteira_Pessoal.Kavii.resources;

import com.Carteira_Pessoal.Kavii.domains.ObjetivoFinanceiro;
import com.Carteira_Pessoal.Kavii.domains.dtos.ObjetivoFinanceiroDTO;
import com.Carteira_Pessoal.Kavii.services.ObjetivoFinanceiroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/objetivofinanceiro")
public class ObjetivoFinanceiroResource {

    @Autowired
    private ObjetivoFinanceiroService ObjetivoFinanceiroService;

    @GetMapping
    public ResponseEntity<List<ObjetivoFinanceiroDTO>> findAll(){
        return ResponseEntity.ok().body(ObjetivoFinanceiroService.findAll());
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<ObjetivoFinanceiroDTO> findById(@PathVariable Long id){
        ObjetivoFinanceiro obj = this.ObjetivoFinanceiroService.findbyId(id);
        return ResponseEntity.ok().body(new ObjetivoFinanceiroDTO(obj));
    }

    @GetMapping(value = "/descricaoObjetivo/{descricaoObjetivo}")
    public ResponseEntity<ObjetivoFinanceiroDTO> findByDescricaoObjetivo(@PathVariable String descricaoObjetivo){
        ObjetivoFinanceiro obj = this.ObjetivoFinanceiroService.findByDescricaoObjetivo(descricaoObjetivo);
        return ResponseEntity.ok().body(new ObjetivoFinanceiroDTO(obj));
    }

    @PostMapping
    public ResponseEntity<ObjetivoFinanceiroDTO> create(@Valid @RequestBody ObjetivoFinanceiroDTO dto){
        ObjetivoFinanceiro objetivoFinanceiro = ObjetivoFinanceiroService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objetivoFinanceiro.getIdObjetivo()).toUri();
        return ResponseEntity.created(uri).build();
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<ObjetivoFinanceiroDTO> update(@PathVariable Long id, @Valid @RequestBody ObjetivoFinanceiroDTO objDto){
        ObjetivoFinanceiro Obj = ObjetivoFinanceiroService.update(id, objDto);
        return  ResponseEntity.ok().body(new ObjetivoFinanceiroDTO(Obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ObjetivoFinanceiroDTO> delete(@PathVariable Long id){
        ObjetivoFinanceiroService.delete(id);
        return  ResponseEntity.noContent().build();
    }

}