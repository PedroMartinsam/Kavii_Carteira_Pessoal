package com.Carteira_Pessoal.Kavii.domains.dtos;

import com.Carteira_Pessoal.Kavii.domains.Lancamento;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;

public class LancamentoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotNull(message = "Preenchimento obrigatório")
    @NotBlank(message = "Preenchimento obrigatório")
    private String descricao;

    @NotNull(message = "Preenchimento obrigatório")
    private Integer parcela;

    @NotNull(message = "Preenchimento obrigatório")
    private LocalDate dataLancamento;

    @NotNull(message = "Preenchimento obrigatório")
    private LocalDate dataVencimento;

    private LocalDate dataBaixa;

    @NotNull(message = "Preenchimento obrigatório")
    private Double valorDocumento;

    @NotNull(message = "Preenchimento obrigatório")
    private Integer tipoLancamento;

    @NotNull(message = "Preenchimento obrigatório")
    private Integer situacao;

    public LancamentoDTO() {
    }

    public LancamentoDTO(Lancamento obj) {
        this.id = obj.getId();
        this.descricao = obj.getDescricao();
        this.parcela = obj.getParcela();
        this.dataLancamento = obj.getDataLancamento();
        this.dataVencimento = obj.getDataVencimento();
        this.dataBaixa = obj.getDataBaixa();
        this.valorDocumento = obj.getValorDocumento();
        this.tipoLancamento = obj.getTipoLancamento().getId();
        this.situacao = obj.getSituacao().getId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getParcela() {
        return parcela;
    }

    public void setParcela(Integer parcela) {
        this.parcela = parcela;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public LocalDate getDataBaixa() {
        return dataBaixa;
    }

    public void setDataBaixa(LocalDate dataBaixa) {
        this.dataBaixa = dataBaixa;
    }

    public Double getValorDocumento() {
        return valorDocumento;
    }

    public void setValorDocumento(Double valorDocumento) {
        this.valorDocumento = valorDocumento;
    }

    public Integer getTipoLancamento() {
        return tipoLancamento;
    }

    public void setTipoLancamento(Integer tipoLancamento) {
        this.tipoLancamento = tipoLancamento;
    }

    public Integer getSituacao() {
        return situacao;
    }

    public void setSituacao(Integer situacao) {
        this.situacao = situacao;
    }
}

