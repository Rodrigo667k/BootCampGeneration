import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastrarComponent } from './cadastrar/cadastrar.component';
import { PostagemDeleteComponent } from './delete/postagem-delete/postagem-delete.component';
import { TemaDeleteComponent } from './delete/tema-delete/tema-delete.component';
import { PostagenEditComponent } from './edit/postagen-edit/postagen-edit.component';
import { TemaEditComponent } from './edit/tema-edit/tema-edit.component';
import { EntrarComponent } from './entrar/entrar.component';
import { InicioComponent } from './inicio/inicio.component';
import { Postagem } from './model/Postagem';
import { TemaComponent } from './tema/tema.component';

const routes: Routes = [
  {path:"", redirectTo: "entrar", pathMatch: "full" },

  {path:"entrar", component: EntrarComponent},
  {path:"cadastrar", component: CadastrarComponent},
  {path:"inicio",component: InicioComponent},
  {path:"tema",component: TemaComponent},
  {path:"tema-edit/:id",component: TemaEditComponent},
  {path:"tema-delete/:id",component: TemaDeleteComponent},
  {path:"postagem-edit/:id", component: PostagenEditComponent},
  {path:"postagem-delete/:id", component: PostagemDeleteComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
