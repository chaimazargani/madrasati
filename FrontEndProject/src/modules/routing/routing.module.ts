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
import { CreerexamenComponent } from '../../app/creerexamen/creerexamen.component';
import { ListclasseComponent } from '../../app/listclasse/listclasse.component';
import { ListexamenComponent } from '../../app/listexamen/listexamen.component';
import { ListmatiereComponent } from '../../app/listmatiere/listmatiere.component';
import { CreermatierComponent } from '../../app/creermatier/creermatier.component';
import { ListenseignantComponent } from '../../app/listenseignant/listenseignant.component';
import { EmploiComponent } from '../../app/emploi/emploi.component';
import { CreereventemploiComponent } from '../../app/creereventemploi/creereventemploi.component';
import { NoteeleveComponent } from '../../app/noteeleve/noteeleve.component';


const appRoutes: Routes = [
  { path: 'creerEnseignant', component: CreerenseignatComponent },
  { path: 'creerexamen', component: CreerexamenComponent },

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
  { path: 'creerexeerexaamen', component: CreerexamenComponent },
  { path: 'listclasse', component: ListclasseComponent },
  { path: 'listexamen', component: ListexamenComponent },
  { path: 'listmatiere', component: ListmatiereComponent },
  { path: 'creermatier', component: CreermatierComponent },
  { path: 'listenseignant', component: ListenseignantComponent },
  { path: 'emploi', component: EmploiComponent },
  { path: 'creereventemploiComponent', component: CreereventemploiComponent },
  { path: 'noteeleve', component: NoteeleveComponent },


  
  
  









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
