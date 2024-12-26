package br.thullyoo.desafio_uol.controller;

import br.thullyoo.desafio_uol.DTO.JogadorDTO;
import br.thullyoo.desafio_uol.DTO.JogadorResponseDTO;
import br.thullyoo.desafio_uol.model.Jogador;
import br.thullyoo.desafio_uol.services.JogadorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogador")
@CrossOrigin("http://localhost:4200")
public class JogadorController {

    @Autowired
    private JogadorService jogadorService;

    @PostMapping
    public ResponseEntity<Jogador> salvarJogador(@RequestBody JogadorDTO jogadorDTO) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(jogadorService.salvar(jogadorDTO));
    }

    @GetMapping
    public ResponseEntity<List<JogadorResponseDTO>> resgatarJogadores() throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(jogadorService.resgatar());
    }
}
