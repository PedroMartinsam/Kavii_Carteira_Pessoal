package com.Carteira_Pessoal.Kavii.domains.dtos;

import com.Carteira_Pessoal.Kavii.domains.Lancamento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Objects;

public class LancamentoDTO {

    private int id;

    @NotNull(message = "O campo descricao não pode ser nulo")
    @NotBlank(message = "O campo descricao não pode ser vazio")
    private String descricao;

    @NotNull(message = "O campo parcela não pode ser nulo")
    private Integer parcela;

    @NotNull(message = "O campo dataLancamento não pode ser nulo")
    private LocalDate dataLancamento;

    @NotNull(message = "O campo dataVencimento não pode ser nulo")
    private LocalDate dataVencimento;

    private LocalDate dataBaixa;

    @NotNull(message = "O campo valorDocumento não pode ser nulo")
    private double valorDocumento;

    private int tipoLancamento;

    private int situacao;

    public LancamentoDTO() {
    }

    public LancamentoDTO(Lancamento Lancamento) {
        this.id = Lancamento.getId();
        this.descricao = Lancamento.getDescricao();
        this.parcela = Lancamento.getParcela();
        this.dataLancamento = Lancamento.getDataLancamento();
        this.dataVencimento = Lancamento.getDataVencimento();
        this.dataBaixa = Lancamento.getDataBaixa();
        this.valorDocumento = Lancamento.getValorDocumento();
        this.tipoLancamento = Lancamento.getTipoLancamento().getId();
        this.situacao = Lancamento.getSituacao().getId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotNull(message = "O campo descricao não pode ser nulo")
    @NotBlank(message = "O campo descricao não pode ser vazio")
    String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotNull(message = "O campo descricao não pode ser nulo")
                             @NotBlank(message = "O campo descricao não pode ser vazio")
                             String descricao) {
        this.descricao = descricao;
    }

    public @NotNull(message = "O campo parcela não pode ser nulo")
    Integer getParcela() {
        return parcela;
    }

    public void setParcela(@NotNull(message = "O campo parcela não pode ser nulo")
                           Integer parcela) {
        this.parcela = parcela;
    }

    public @NotNull(message = "O campo dataLancamento não pode ser nulo")
    LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(@NotNull(message = "O campo dataLancamento não pode ser nulo")
                                  LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public @NotNull(message = "O campo dataVencimento não pode ser nulo")
    LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(@NotNull(message = "O campo dataVencimento não pode ser nulo")
                                  LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public LocalDate getDataBaixa() {
        return dataBaixa;
    }

    public void setDataBaixa(LocalDate dataBaixa) {
        this.dataBaixa = dataBaixa;
    }

    public @NotNull(message = "O campo valorDocumento não pode ser nulo")
    Double getValorDocumento() {
        return valorDocumento;
    }

    public void setValorDocumento(@NotNull(message = "O campo valorDocumento não pode ser nulo")
                                  Double valorDocumento) {
        this.valorDocumento = valorDocumento;
    }


    public int getTipoLancamento() {
        return tipoLancamento;
    }

    public void setTipoLancamento(int tipoLancamento) {
        this.tipoLancamento = tipoLancamento;
    }

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LancamentoDTO that = (LancamentoDTO) o;
        return id == that.id && parcela == that.parcela && Double.compare(valorDocumento, that.valorDocumento) == 0 && tipoLancamento == that.tipoLancamento && situacao == that.situacao && Objects.equals(descricao, that.descricao) && Objects.equals(dataLancamento, that.dataLancamento) && Objects.equals(dataVencimento, that.dataVencimento) && Objects.equals(dataBaixa, that.dataBaixa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, parcela, dataLancamento, dataVencimento, dataBaixa, valorDocumento, tipoLancamento, situacao);
    }
}
