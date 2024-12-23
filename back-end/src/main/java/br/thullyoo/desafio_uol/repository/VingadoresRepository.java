package br.thullyoo.desafio_uol.repository;

import br.thullyoo.desafio_uol.DTO.VingadoresDTO;
import br.thullyoo.desafio_uol.model.GrupoCodinome;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClient;

import java.util.List;

@Repository
public class VingadoresRepository implements CodinomeRepository {


    @Override
    public List<String> resgatarCodinomes() throws JsonProcessingException {

        String uri = GrupoCodinome.VINGADORES.getUri();

        var codinomes = RestClient
                .builder()
                .baseUrl(uri)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN_VALUE)
                .build()
                .get()
                .retrieve()
                .body(String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        var vingadores = objectMapper.readValue(codinomes, VingadoresDTO.class);
        System.out.println(vingadores.getCodinomes());
        return vingadores.getCodinomes();
    }
}
