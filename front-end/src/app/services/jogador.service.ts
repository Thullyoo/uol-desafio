import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import {Jogador} from "../interfaces/Jogador";
import type { JogadorGet } from '../interfaces/JogadorGet';

@Injectable({
  providedIn: 'root'
})
export class JogadorService {

  httpClient = inject(HttpClient);

  private uri = "http://localhost:8080/jogador";

  cadastrarJogador(jogador: Jogador){
    return this.httpClient.post(this.uri, jogador);
  }

  resgatarJogadores(){
    return this.httpClient.get<JogadorGet[]>(this.uri);
  }
}
  