import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { CreerenseignatComponent } from '../../app/creerenseignat/creerenseignat.component';
import { LoginComponent } from '../../app/login/login.component';
import { CreerclasseComponent } from '../../app/creerclasse/creerclasse.component';
import { EnseignantComponent } from '../../app/app-web/enseignant/enseignant.component';
import { NoteComponent } from '../../app/app-web/enseignant/note/note.component';
import { CoursComponent } from '../../app/app-web/enseignant/cours/cours.component';

const appRoutes: Routes = [
  { path: 'creerEnseignant', component: CreerenseignatComponent },
  { path: 'login', component: LoginComponent },
  { path: 'creerclasse', component: CreerclasseComponent },
  { path: 'enseignant', component: EnseignantComponent },
  { path: 'note', component: NoteComponent},
  { path:'cours', component: CoursComponent},
  { path: '' , redirectTo: '/login', pathMatch: 'full'}
  
];
@NgModule({
  imports: [
    RouterModule.forRoot(
      appRoutes,
      // { enableTracing: true } // <-- debugging purposes only
    ),
    CommonModule
  ],
  exports: [RouterModule],
  declarations: []
})
export class RoutingModule {  }
