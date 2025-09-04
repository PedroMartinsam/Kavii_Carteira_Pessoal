package com.Carteira_Pessoal.Kavii.domains.enums;

public enum Situacao {

    ABERTA(1, "ABERTA"), BAIXADA(2, "BAIXADA");
    private Integer id;
    private String descricao;

    Situacao(Integer id, String descricao) {
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
    public static Situacao toEnum(Integer id){
        if (id==null) return null;
        for (Situacao c : Situacao.values()){
            if (id.equals(c.getId())){
                return c;
            }
        }

        throw new IllegalArgumentException("Situação Inválida");
    }
}
