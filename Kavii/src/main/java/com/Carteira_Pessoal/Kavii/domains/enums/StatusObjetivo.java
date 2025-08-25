package com.Carteira_Pessoal.Kavii.domains.enums;

public enum StatusObjetivo {

    EMANDAMENTO(1, "Objetivo em andamento"), CONQUISTADA(2, "Objetivo Conquistada");
    private Integer id;
    private String descricao;

    StatusObjetivo(Integer id,String descricao) {
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

    public static StatusObjetivo toEnum(Integer id){
        if (id==null) return null;
        for (StatusObjetivo c : StatusObjetivo.values()){
            if (id.equals(c.getId())){
                return c;
            }
        }

        throw new IllegalArgumentException("Status da Objetivo Inválido");
    }
}
