package br.thullyoo.desafio_uol.DTO;

import br.thullyoo.desafio_uol.model.GrupoCodinome;
import br.thullyoo.desafio_uol.model.Jogador;

public record JogadorDTO(String nome, String email, String telefone, GrupoCodinome grupoCodinome) {
    public Jogador toJogador(String codinome){
        Jogador jogador = new Jogador();
        jogador.setCodinome(codinome);
        jogador.setEmail(email);
        jogador.setNome(nome);
        jogador.setGrupoCodinome(grupoCodinome);
        jogador.setTelefone(telefone);
        return jogador;
    }
}
