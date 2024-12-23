package br.thullyoo.desafio_uol.model;

import lombok.Getter;
import lombok.Setter;

public enum GrupoCodinome {
    LIGA_DA_JUSTICA("Liga Da Justiça", "https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/liga_da_justica.xml"),
    VINGADORES("Vingadores", "https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/vingadores.json");

    private String nome;

    private String uri;

    GrupoCodinome(String nome, String uri){
        this.nome = nome;
        this.uri = uri;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
