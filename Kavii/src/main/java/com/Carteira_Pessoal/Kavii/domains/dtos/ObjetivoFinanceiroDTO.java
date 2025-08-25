package com.Carteira_Pessoal.Kavii.domains.dtos;

import com.Carteira_Pessoal.Kavii.domains.ObjetivoFinanceiro;
import com.Carteira_Pessoal.Kavii.domains.enums.StatusObjetivo;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

public class ObjetivoFinanceiroDTO {

    private Long idObjetivo;

    @NotBlank(message = "O campo Descrição Objetivo não pode ser vazio")
    @NotNull(message = "O campo Descrição Objetivo não pode ser nulo")
    private String descricaoObjetivo;

    @NotBlank(message = "O campo prazo não pode ser vazio")
    @NotNull(message = "O campo prazo não pode ser nulo")
    private String prazo;

    @NotNull(message = "O valor não pode ser nulo")
    private Double valor;

    private int statusObjetivo;

    public ObjetivoFinanceiroDTO() {
    }

    public ObjetivoFinanceiroDTO(ObjetivoFinanceiro objetivoFinanceiro) {
        this.idObjetivo = objetivoFinanceiro.getIdObjetivo();
        this.descricaoObjetivo = objetivoFinanceiro.getDescricaoObjetivo();
        this.prazo = objetivoFinanceiro.getPrazo();
        this.valor = objetivoFinanceiro.getValor();
        this.statusObjetivo = objetivoFinanceiro.getStatusObjetivo().getId();
    }

    public Long getIdObjetivo() {
        return idObjetivo;
    }

    public void setIdObjetivo(Long idObjetivo) {
        this.idObjetivo = idObjetivo;
    }

    public @NotBlank @NotNull String getDescricaoObjetivo() {
        return descricaoObjetivo;
    }

    public void setDescricaoObjetivo(@NotBlank @NotNull String descricaoObjetivo) {
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

    public int getStatusObjetivo() {
        return statusObjetivo;
    }

    public void setStatusObjetivo(int statusObjetivo) {
        this.statusObjetivo = statusObjetivo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjetivoFinanceiroDTO that = (ObjetivoFinanceiroDTO) o;
        return statusObjetivo == that.statusObjetivo && Objects.equals(idObjetivo, that.idObjetivo) && Objects.equals(descricaoObjetivo, that.descricaoObjetivo) && Objects.equals(prazo, that.prazo) && Objects.equals(valor, that.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idObjetivo, descricaoObjetivo, prazo, valor, statusObjetivo);
    }
}