import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { MatInputModule} from '@angular/material';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { CreerenseignatComponent } from './creerenseignat/creerenseignat.component';
import { RoutingModule } from '../modules/routing/routing.module';
import { LoginComponent } from './login/login.component';
import { HttpClientModule } from '@angular/common/http';
import { CreerclasseComponent } from './creerclasse/creerclasse.component';
import { EnseignantComponent } from './app-new/enseignant/enseignant.component';
import { AppWebComponent } from './app-web/app-web.component';

@NgModule({
  declarations: [
    AppComponent,
    CreerenseignatComponent,
    LoginComponent,
    CreerclasseComponent,
    EnseignantComponent,
    AppWebComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    MatInputModule,
    FormsModule,
    BrowserAnimationsModule,
    RoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
