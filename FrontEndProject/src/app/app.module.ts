import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule, Pipe } from '@angular/core';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CreerenseignatComponent } from './creerenseignat/creerenseignat.component';
import { RoutingModule } from '../modules/routing/routing.module';
import { LoginComponent } from './login/login.component';
import { HttpClientModule } from '@angular/common/http';
import { CreerclasseComponent } from './creerclasse/creerclasse.component';
import { AppWebComponent } from './app-web/app-web.component';
import { EnseignantComponent } from './app-web/enseignant/enseignant.component';
import { AppWebModule } from './app-web/app-web.module';
import { MaterialModule } from '../modules/material/material.module';
import { EleveComponent } from'./app-web/enseignant/eleve/eleve.component';
import { AppareilComponent } from './appareil/appareil.component';
import {enableProdMode} from '@angular/core';
import {AppareilService} from './service/appareil.service';
import {AuthService} from './service/auth.service';

import { AuthComponent } from './auth/auth.component';
import { AppareilviewComponent } from './appareilview/appareilview.component';
import { RegistreComponent } from "./registre/RegistreComponent";
import { CenderCellRendererComponent } from './cender-cell-renderer/cender-cell-renderer.component';


//import { UtilisateurComponent } from './app-web/utilisateur/utilisateur.component';


@NgModule({
  declarations: [
    AppComponent,
    CreerenseignatComponent,
    LoginComponent,
    CreerclasseComponent,
    AppWebComponent,
    EnseignantComponent,
    EleveComponent,
    AppareilComponent,
    AuthComponent,
    AppareilviewComponent,
    RegistreComponent,
    RegistreComponent,
    CenderCellRendererComponent,
  
       

     // UtilisateurComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    RoutingModule,
    AppWebModule,
    MaterialModule,
  ],
  providers: [
    AppareilService ,
    AuthService,
  ],
  bootstrap: [AppComponent]

})
export class AppModule { }
