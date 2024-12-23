package br.thullyoo.desafio_uol.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Jogador {

    private Long id;

    private String nome;

    private String email;

    private String telefone;

    private GrupoCodinome grupoCodinome;

    private String codinome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public GrupoCodinome getGrupoCodinome() {
        return grupoCodinome;
    }

    public void setGrupoCodinome(GrupoCodinome grupoCodinome) {
        this.grupoCodinome = grupoCodinome;
    }

    public String getCodinome() {
        return codinome;
    }

    public void setCodinome(String codinome) {
        this.codinome = codinome;
    }
}

