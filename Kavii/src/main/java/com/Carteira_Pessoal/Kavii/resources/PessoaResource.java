package com.Carteira_Pessoal.Kavii.resources;

import com.Carteira_Pessoal.Kavii.domains.Banco;
import com.Carteira_Pessoal.Kavii.domains.Pessoa;
import com.Carteira_Pessoal.Kavii.domains.dtos.BancoDTO;
import com.Carteira_Pessoal.Kavii.domains.dtos.PessoaDTO;
import com.Carteira_Pessoal.Kavii.services.BancoService;
import com.Carteira_Pessoal.Kavii.services.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaResource {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<List<PessoaDTO>> findAll(){
        return ResponseEntity.ok().body(pessoaService.findAll());
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<PessoaDTO> findById(@PathVariable Long id){
        Pessoa obj = this.pessoaService.findbyId(id);
        return ResponseEntity.ok().body(new PessoaDTO(obj));
    }


    @GetMapping(value = "/razaoSocial/{razaoSocial}")
    public ResponseEntity<PessoaDTO> findByRazaoSocial(@PathVariable String razaoSocial){
        Pessoa obj = this.pessoaService.findByRazaoSocial(razaoSocial);
        return ResponseEntity.ok().body(new PessoaDTO(obj));
    }

    @PostMapping
    public ResponseEntity<PessoaDTO> create(@Valid @RequestBody PessoaDTO dto){
        Pessoa pessoa = pessoaService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pessoa.getIdPessoa()).toUri();
        return  ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PessoaDTO> update(@PathVariable Long id, @Valid @RequestBody PessoaDTO objDTO){
        Pessoa Obj = pessoaService.update(id, objDTO);
        return ResponseEntity.ok().body(new PessoaDTO(Obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<PessoaDTO> delete(@PathVariable Long id){
        pessoaService.delete(id);
        return ResponseEntity.noContent().build();
    }





}