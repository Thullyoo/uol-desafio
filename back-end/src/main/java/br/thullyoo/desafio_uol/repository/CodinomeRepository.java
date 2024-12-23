package br.thullyoo.desafio_uol.repository;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface CodinomeRepository {

     public List<String> resgatarCodinomes() throws JsonProcessingException;

}
