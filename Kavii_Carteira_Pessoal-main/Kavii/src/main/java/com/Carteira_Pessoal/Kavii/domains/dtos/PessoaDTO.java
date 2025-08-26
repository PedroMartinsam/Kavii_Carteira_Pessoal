package com.Carteira_Pessoal.Kavii.domains.dtos;

import com.Carteira_Pessoal.Kavii.domains.Pessoa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

public class PessoaDTO {

    private Long idPessoa;

    @NotNull(message = "O campo razaoSocial não pode ser nulo")
    @NotBlank(message = "O campo razaoSocial não pode estar vazio")
    private String razaoSocial;

    public PessoaDTO() {
    }

    public PessoaDTO(Pessoa pessoa) {
        this.idPessoa = pessoa.getIdPessoa();
        this.razaoSocial = pessoa.getRazaoSocial();
    }


    public Long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public @NotNull(message = "O campo razao Social não pode ser nulo") @NotBlank(message = "O campo razao Social não pode estar vazio") String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(@NotNull(message = "O campo razao Social não pode ser nulo") @NotBlank(message = "O campo razao Social não pode estar vazio") String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PessoaDTO pessoaDTO = (PessoaDTO) o;
        return Objects.equals(idPessoa, pessoaDTO.idPessoa) && Objects.equals(razaoSocial, pessoaDTO.razaoSocial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPessoa, razaoSocial);
    }
}
