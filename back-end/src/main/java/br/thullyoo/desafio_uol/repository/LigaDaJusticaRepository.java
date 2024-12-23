package br.thullyoo.desafio_uol.repository;

import br.thullyoo.desafio_uol.DTO.LigaDaJusticaDTO;
import br.thullyoo.desafio_uol.model.GrupoCodinome;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClient;

import java.util.List;

@Repository
public class LigaDaJusticaRepository implements CodinomeRepository {


    @Override
    public List<String> resgatarCodinomes() throws JsonProcessingException {

        String uri =  GrupoCodinome.LIGA_DA_JUSTICA.getUri();

        var codinomes = RestClient.builder()
                .baseUrl(uri)
                .build()
                .get()
                .retrieve()
                .body(String.class);

        var xmlMapper = new XmlMapper();
        var ligaDaJustica = xmlMapper.readValue(codinomes, LigaDaJusticaDTO.class);
        System.out.println(ligaDaJustica.getCodinomes());
        return ligaDaJustica.getCodinomes();
    }
}
