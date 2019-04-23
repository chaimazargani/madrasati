import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
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

@NgModule({
  declarations: [
    AppComponent,
    CreerenseignatComponent,
    LoginComponent,
    CreerclasseComponent,
    AppWebComponent,
    EnseignantComponent
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
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
