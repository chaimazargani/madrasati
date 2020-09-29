import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { Directive ,Component } from '@angular/core';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CreerenseignatComponent } from './creerenseignat/creerenseignat.component';
import { RoutingModule } from '../modules/routing/routing.module';
// import { LoginComponent } from './login/login.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { CreerclasseComponent } from './creerclasse/creerclasse.component';
import { AppWebComponent } from './app-web/app-web.component';
import { EnseignantComponent } from './app-web/enseignant/enseignant.component';
import { AppWebModule } from './app-web/app-web.module';
import { MaterialModule } from '../modules/material/material.module';
import { EleveComponent } from'./app-web/enseignant/eleve/eleve.component';
import { AppareilComponent } from './appareil/appareil.component';
//import {enableProdMode} from '@angular/core';
import {AppareilService} from './service/appareil.service';
import {AuthService} from './service/auth.service';
import { CommonModule } from '@angular/common';
import { AuthComponent } from './auth/auth.component';
import { AppareilviewComponent } from './appareilview/appareilview.component';
import { RegistreComponent } from "./registre/RegistreComponent";
import { CreerexamenComponent } from './creerexamen/creerexamen.component';
import { MatSortModule } from '@angular/material/sort';
import {MatTableModule} from '@angular/material/table';
import { CreermatierComponent } from './creermatier/creermatier.component';
import { ListclasseComponent } from './listclasse/listclasse.component';
import { ListexamenComponent } from './listexamen/listexamen.component';
import { ListmatiereComponent } from './listmatiere/listmatiere.component';
import { ListenseignantComponent } from './listenseignant/listenseignant.component';
import { ExamenComponent } from './app-web/enseignant/examen/examen.component';
import { EmploiComponent } from './emploi/emploi.component';
import { EventService } from './emploi/eventservice';
import { CreereventemploiComponent } from './creereventemploi/creereventemploi.component';
import { NoteeleveComponent } from './noteeleve/noteeleve.component';
import { CheckboxRenderer } from './registre/checkbox-renderer.component';
import { AgGridModule } from 'ag-grid-angular';
import { CourseleveComponent } from './courseleve/courseleve.component';
import { AuthenticationComponent } from './login/authentication.component';
import { HeaderHttpInterceptor } from './app-web/header-http-interceptor';
import { MessageService } from 'primeng/api';

//import { CreerexamenComponent } from './creerexamen/creerexamen.component';
//import { CenderCellRendererComponent } from './cender-cell-renderer/cender-cell-renderer.component';



@NgModule({
  declarations: [
    AppComponent,
    CreerenseignatComponent,
    // LoginComponent,
    CreerclasseComponent,
    AppWebComponent,
    EnseignantComponent,
    EleveComponent,
    AppareilComponent,
    AuthComponent,
    AppareilviewComponent,
    RegistreComponent,
    RegistreComponent,
    CreerexamenComponent,
    CreermatierComponent,
    ListclasseComponent,
    ListexamenComponent,
    ListmatiereComponent,
    ListenseignantComponent,
    ExamenComponent,
    EmploiComponent,
    CreereventemploiComponent,
    NoteeleveComponent, 
    CheckboxRenderer, CourseleveComponent ,AuthenticationComponent ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    RoutingModule,
    AppWebModule,
    MaterialModule, 
    BrowserModule,
    BrowserAnimationsModule,
    AgGridModule.withComponents([CheckboxRenderer]),
    MatTableModule,
    MatSortModule,
  ],
  providers: [
    MessageService,
    AppareilService ,
    AuthService,
    EventService,
    {provide: HTTP_INTERCEPTORS, useClass: HeaderHttpInterceptor, multi: true }
  ],
  bootstrap: [AppComponent],
entryComponents : [CreerenseignatComponent]
})
export class AppModule { }
