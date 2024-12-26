package br.thullyoo.desafio_uol.repository;

import br.thullyoo.desafio_uol.DTO.JogadorResponseDTO;
import br.thullyoo.desafio_uol.model.GrupoCodinome;
import br.thullyoo.desafio_uol.model.Jogador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

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
                .param("grupo_codinome", jogador.getGrupoCodinome().getNome())
                .param("codinome", jogador.getCodinome())
                .update();
        return  jogador;
    }

    public List<String> resgatarCodinomesUtilizados(GrupoCodinome grupoCodinome){

        List<String> codinomes = new ArrayList<>();

        codinomes = jdbcClient.sql("SELECT distinct(codinome) FROM JOGADOR WHERE grupo_codinome = :grupoCodinome")
                .param("grupoCodinome", grupoCodinome.getNome())
                .query(String.class)
                .list();


        return codinomes;
    }

    public List<JogadorResponseDTO> resgatarJogadores(){
        List<JogadorResponseDTO> jogadores = jdbcClient.sql("""
                SELECT * FROM JOGADOR
                """)
                .query(JogadorResponseDTO.class)
                .list();
        return jogadores;
    }
}
