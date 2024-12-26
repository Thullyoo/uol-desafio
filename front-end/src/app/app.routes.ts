import { Routes } from '@angular/router';
import { ListarJogadoresComponent } from './pages/listar-jogadores/listar-jogadores.component';
import { CadastrarJogadoresComponent } from './pages/cadastrar-jogadores/cadastrar-jogadores.component';

export const routes: Routes = [
  {
    path: "jogadores",
    component: ListarJogadoresComponent
  },
  {
    path: "**",
    component: CadastrarJogadoresComponent
  }
];
