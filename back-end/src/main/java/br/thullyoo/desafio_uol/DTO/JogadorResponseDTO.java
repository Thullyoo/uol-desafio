package br.thullyoo.desafio_uol.DTO;

import br.thullyoo.desafio_uol.model.GrupoCodinome;

public record JogadorResponseDTO(String nome, String email, String telefone, String grupoCodinome, String codinome) {
}
