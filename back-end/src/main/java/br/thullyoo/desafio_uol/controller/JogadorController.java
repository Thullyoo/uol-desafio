package br.thullyoo.desafio_uol.controller;

import br.thullyoo.desafio_uol.DTO.JogadorDTO;
import br.thullyoo.desafio_uol.model.Jogador;
import br.thullyoo.desafio_uol.services.JogadorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jogador")
public class JogadorController {

    @Autowired
    private JogadorService jogadorService;

    @PostMapping
    public ResponseEntity<Jogador> salvarJogador(@RequestBody JogadorDTO jogadorDTO) throws JsonProcessingException {
        return ResponseEntity.status(HttpStatus.CREATED).body(jogadorService.salvar(jogadorDTO));
    }
}
