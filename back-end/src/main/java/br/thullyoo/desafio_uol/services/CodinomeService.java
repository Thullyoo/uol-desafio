package br.thullyoo.desafio_uol.services;

import br.thullyoo.desafio_uol.model.GrupoCodinome;
import br.thullyoo.desafio_uol.repository.CodinomeRepository;
import br.thullyoo.desafio_uol.repository.LigaDaJusticaRepository;
import br.thullyoo.desafio_uol.repository.VingadoresRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class CodinomeService {

    public String gerarCodinome(GrupoCodinome grupoCodinome, List<String> listaDeCodinomesUtilizados) throws Exception {

        CodinomeRepository codinomeRepository =  resgatarRepository(grupoCodinome);

        List<String> codinomes = codinomeRepository.resgatarCodinomes();

        List<String> listaCodinomeLimpa = limparLista(codinomes, listaDeCodinomesUtilizados);

        String codinome = pegarRandomCodinome(listaCodinomeLimpa);

        return codinome;
    }

    private List<String> limparLista(List<String> codinomes, List<String> listaDeCodinomesUtilizados) throws Exception {
        codinomes = codinomes.stream()
                .filter(codinome -> !listaDeCodinomesUtilizados.contains(codinome))
                .toList();
        if (codinomes.isEmpty()){
            throw new Exception("Sem codinomes disponíveis");
        }
        return codinomes;
    }

    private CodinomeRepository resgatarRepository(GrupoCodinome grupoCodinome){
        if (grupoCodinome.equals(GrupoCodinome.VINGADORES)){
            return new VingadoresRepository();
        } else {
            return new LigaDaJusticaRepository();
        }
    }

    private String pegarRandomCodinome(List<String> codinomes){
        Random random = new Random();
        String codiome = codinomes.get(random.nextInt(codinomes.size()));
        return codiome;
    }


}
