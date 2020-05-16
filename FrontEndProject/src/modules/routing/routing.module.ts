import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { CreerenseignatComponent } from '../../app/creerenseignat/creerenseignat.component';
import { LoginComponent } from '../../app/login/login.component';
import { CreerclasseComponent } from '../../app/creerclasse/creerclasse.component';
import { EnseignantComponent } from '../../app/app-web/enseignant/enseignant.component';
import { NoteComponent } from '../../app/app-web/enseignant/note/note.component';
import { CoursComponent } from '../../app/app-web/enseignant/cours/cours.component';
import { EleveComponent } from '../../app/app-web/enseignant/eleve/eleve.component';
//import { UtilisateurComponent } from '../../app/app-web/utilisateur/utilisateur.component';
import { AppareilComponent } from '../../app/appareil/appareil.component';
import { AppareilviewComponent } from '../../app/appareilview/appareilview.component';
import { AuthComponent } from '../../app/auth/auth.component';
import { RegistreComponent } from "../../app/registre/RegistreComponent";
//import { CenderCellRendererComponent } from '../../app/cender-cell-renderer/cender-cell-renderer.component';

const appRoutes: Routes = [
  { path: 'creerEnseignant', component: CreerenseignatComponent },
  { path: 'login', component: LoginComponent },
  { path: 'creerclasse', component: CreerclasseComponent },
  { path: 'enseignant', component: EnseignantComponent },
  { path: 'note', component: NoteComponent},
  { path:'cours', component: CoursComponent},
  { path:'eleve', component: EleveComponent},
 // { path:'utilisateur', component: UtilisateurComponent},
  { path: 'appareil', component:AppareilComponent},
  { path: 'appareilview', component:AppareilviewComponent},
  { path: 'auth', component: AuthComponent},
  { path: 'registre', component: RegistreComponent},
  //{ path : 'cenderCellRendererComponent' , component: CenderCellRendererComponent },

  






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
