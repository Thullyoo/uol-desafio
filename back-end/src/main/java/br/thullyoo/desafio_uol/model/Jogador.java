package br.thullyoo.desafio_uol.model;


import lombok.Getter;
import lombok.Setter;

public class Jogador {

    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String nome;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String telefone;

    private GrupoCodinome grupoCodinome;

    private String codinome;

}

