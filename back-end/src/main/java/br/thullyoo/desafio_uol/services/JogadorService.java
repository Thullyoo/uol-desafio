package br.thullyoo.desafio_uol.services;

import br.thullyoo.desafio_uol.DTO.JogadorDTO;
import br.thullyoo.desafio_uol.model.Jogador;
import br.thullyoo.desafio_uol.repository.CodinomeRepository;
import br.thullyoo.desafio_uol.repository.JogadorRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogadorService {

    @Autowired
    private JogadorRepository jogadorRepository;

    @Autowired
    private CodinomeService codinomeService;

    public Jogador salvar(JogadorDTO jogadorDTO) throws JsonProcessingException {
        List <String> codinomesJaUtilizados = jogadorRepository.resgatarCodinomesUtilizados(jogadorDTO.grupoCodinome());
        String codinome = codinomeService.gerarCodinome(jogadorDTO.grupoCodinome(), codinomesJaUtilizados);
        Jogador jogador = jogadorDTO.toJogador(codinome);
        return jogadorRepository.salvar(jogador);
    }

}
