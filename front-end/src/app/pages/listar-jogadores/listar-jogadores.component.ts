import { Component, inject, input, type OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import type { JogadorGet } from '../../interfaces/JogadorGet';
import { JogadorService } from '../../services/jogador.service';

@Component({
  selector: 'app-listar-jogadores',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './listar-jogadores.component.html',
  styleUrl: './listar-jogadores.component.scss'
})
export class ListarJogadoresComponent{
  

  public jogadores: JogadorGet[] = []

  jogadorService = inject(JogadorService);

  ngOnInit(): void {
    this.jogadorService.resgatarJogadores().subscribe({
      next: value => {
        this.jogadores = value;
      },
      error(err) {
        console.error(err);
      },
    })
  }

}
