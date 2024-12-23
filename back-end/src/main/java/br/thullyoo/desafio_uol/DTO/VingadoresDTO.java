package br.thullyoo.desafio_uol.DTO;

import java.util.List;

public record VingadoresDTO(List<Codinome> vingadores) {

    public List<String> getCodinomes(){
        return
                vingadores.stream()
                .map(Codinome::codinome)
                .toList();
    }
}

record Codinome(String codinome){}