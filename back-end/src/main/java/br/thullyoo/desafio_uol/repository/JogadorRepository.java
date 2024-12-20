package br.thullyoo.desafio_uol.repository;

import br.thullyoo.desafio_uol.model.Jogador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class JogadorRepository {

    @Autowired
    private JdbcClient jdbcClient;

    public Jogador salvar(Jogador jogador){
        jdbcClient.sql("""
                INSERT INTO JOGADOR (nome, email, telefone, grupo_codinome, codinome)
                VALUES (:nome, :email, :telefone, :grupo_codinome, :codinome)
                """)
                .param("nome", jogador.getNome())
                .param("email", jogador.getEmail())
                .param("telefone", jogador.getTelefone())
                .param("grupo_codinome", jogador.getGrupoCodinome())
                .param("codinome", jogador.getCodinome())
                .update();
        return  jogador;
    }

}
