package com.Carteira_Pessoal.Kavii.domains.enums;

public enum TipoLancamento {

    CREDITO(1, "CREDITO"), DEBITO(2, "DEBITO");
    private Integer id;
    private String descricao;

    TipoLancamento(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
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
    public static TipoLancamento toEnum(Integer id){
        if(id == null) return null;
        for (TipoLancamento c : TipoLancamento.values()){
            if(id.equals(c.getId())){
                return c;
            }
        }

        throw new IllegalArgumentException("Tipo de lançamento inválido");}
}
