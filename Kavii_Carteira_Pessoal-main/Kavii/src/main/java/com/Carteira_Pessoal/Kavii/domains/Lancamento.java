package com.Carteira_Pessoal.Kavii.domains;

import com.Carteira_Pessoal.Kavii.domains.dtos.LancamentoDTO;
import com.Carteira_Pessoal.Kavii.domains.enums.Situacao;
import com.Carteira_Pessoal.Kavii.domains.enums.TipoLancamento;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "lancamento")
public class Lancamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @NotBlank
    private String descricao;

    @NotNull
    private Integer parcela;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataLancamento;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataVencimento;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataBaixa;

    @NotNull
    private Double valorDocumento;

    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name = "tipo_lancamento_id")
    private TipoLancamento tipoLancamento;

    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name = "situacao_id")
    private Situacao situacao;

    public Lancamento() {
    }

    public Lancamento(Integer id, String descricao, Integer parcela, LocalDate dataLancamento, LocalDate dataVencimento, LocalDate dataBaixa, TipoLancamento tipoLancamento, Double valorDocumento, Situacao situacao) {
        this.id = id;
        this.descricao = descricao;
        this.parcela = parcela;
        this.dataLancamento = dataLancamento;
        this.dataVencimento = dataVencimento;
        this.dataBaixa = dataBaixa;
        this.tipoLancamento = tipoLancamento;
        this.valorDocumento = valorDocumento;
        this.situacao = situacao;
    }

    public Lancamento(LancamentoDTO dto) {
        this.id = dto.getId();
        this.descricao = dto.getDescricao();
        this.dataLancamento = dto.getDataLancamento();
        this.parcela = dto.getParcela();
        this.dataVencimento = dto.getDataVencimento();
        this.tipoLancamento = TipoLancamento.toEnum(dto.getTipoLancamento());
        this.situacao = Situacao.toEnum(dto.getSituacao());
        this.valorDocumento = dto.getValorDocumento();
        this.dataBaixa = dto.getDataBaixa();
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

    public TipoLancamento getTipoLancamento() {
        return tipoLancamento;
    }

    public void setTipoLancamento(TipoLancamento tipoLancamento) {
        this.tipoLancamento = tipoLancamento;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lancamento that = (Lancamento) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
