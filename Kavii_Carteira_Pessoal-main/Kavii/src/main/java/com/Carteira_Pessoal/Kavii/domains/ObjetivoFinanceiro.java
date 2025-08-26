package com.Carteira_Pessoal.Kavii.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.Carteira_Pessoal.Kavii.domains.dtos.ObjetivoFinanceiroDTO;
import com.Carteira_Pessoal.Kavii.domains.enums.StatusObjetivo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "objetivofinanceiro")
public class ObjetivoFinanceiro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_objetivo")
    private Long idObjetivo;

    @NotNull@NotBlank
    private String descricaoObjetivo;

    @NotBlank @NotNull
    private String prazo;

    @NotNull
    private Double valor;

    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name = "objetivofinanceiro")
    private StatusObjetivo statusObjetivo;

    @JsonIgnore
    @OneToMany(mappedBy = "objetivoFinanceiro")
    private List<Conta> contas = new ArrayList<>();

    public ObjetivoFinanceiro() {
        this.statusObjetivo = StatusObjetivo.EMANDAMENTO;
    }

    public ObjetivoFinanceiro(Long idObjetivo, String descricaoObjetivo, String prazo, Double valor, StatusObjetivo statusObjetivo) {
        this.idObjetivo = idObjetivo;
        this.descricaoObjetivo = descricaoObjetivo;
        this.prazo = prazo;
        this.valor = valor;
        this.statusObjetivo = statusObjetivo;
    }

    public ObjetivoFinanceiro(ObjetivoFinanceiroDTO dto){
        this.idObjetivo = dto.getIdObjetivo();
        this.descricaoObjetivo = dto.getDescricaoObjetivo();
        this.prazo = dto.getPrazo();
        this.valor = dto.getValor();
        this.statusObjetivo = StatusObjetivo.toEnum(dto.getStatusObjetivo());
    }

    public Long getIdObjetivo() {
        return idObjetivo;
    }

    public void setIdObjetivo(Long idObjetivo) {
        this.idObjetivo = idObjetivo;
    }

    public @NotNull @NotBlank String getDescricaoObjetivo() {
        return descricaoObjetivo;
    }

    public void setDescricaoObjetivo(@NotNull @NotBlank String descricaoObjetivo) {
        this.descricaoObjetivo = descricaoObjetivo;
    }

    public @NotBlank @NotNull String getPrazo() {
        return prazo;
    }

    public void setPrazo(@NotBlank @NotNull String prazo) {
        this.prazo = prazo;
    }

    public @NotNull Double getValor() {
        return valor;
    }

    public void setValor(@NotNull Double valor) {
        this.valor = valor;
    }

    public StatusObjetivo getStatusObjetivo() {
        return statusObjetivo;
    }

    public void setStatusObjetivo(StatusObjetivo statusObjetivo) {
        this.statusObjetivo = statusObjetivo;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjetivoFinanceiro that = (ObjetivoFinanceiro) o;
        return Objects.equals(idObjetivo, that.idObjetivo) && Objects.equals(descricaoObjetivo, that.descricaoObjetivo) && Objects.equals(prazo, that.prazo) && Objects.equals(valor, that.valor) && statusObjetivo == that.statusObjetivo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idObjetivo, descricaoObjetivo, prazo, valor, statusObjetivo);
    }
}
