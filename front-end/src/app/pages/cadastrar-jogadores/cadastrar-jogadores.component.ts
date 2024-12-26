import { Component, inject } from '@angular/core';
import { FormBuilder, FormControl, ReactiveFormsModule } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';
import { JogadorService } from '../../services/jogador.service';

@Component({
  selector: 'app-cadastrar-jogadores',
  standalone: true,
  imports: [ReactiveFormsModule, RouterModule],
  templateUrl: './cadastrar-jogadores.component.html',
  styleUrl: './cadastrar-jogadores.component.scss'
})
export class CadastrarJogadoresComponent {
  formBuilder = inject(FormBuilder);

  jogadorService = inject(JogadorService);

  router = inject(Router);

  form = this.formBuilder.group({
    nome: new FormControl('', {}),
    email: new FormControl('', {}),
    telefone: new FormControl('', {}),
    grupoCodinome: new FormControl('', {})
  });

  onSubmit(event: Event) {
    event.preventDefault();
    if (this.form.valid) {
      this.jogadorService.cadastrarJogador({
        email: this.form.value.email!,
        nome: this.form.value.nome!,
        telefone: this.form.value.telefone!,
        grupoCodinome: this.form.value.grupoCodinome!
      }).subscribe({
        next(value) {
          console.log(value);
        },
        error(err) {
          console.error(err);
        },
      })
    } else {
      console.log('Formulário inválido');
    }
  }
}
