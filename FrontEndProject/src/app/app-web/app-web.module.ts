import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AgGridModule } from 'ag-grid-angular';
import { NoteComponent } from './enseignant/note/note.component';
import { BrowserModule } from '@angular/platform-browser';
import { MaterialModule } from '../../modules/material/material.module';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NoteHttpService } from './enseignant/note/note-http.service';
import { NoteService } from './enseignant/note/note.service';
import { CoursComponent } from './enseignant/cours/cours.component';
import { CoursService } from './enseignant/cours/cours.service';
import { ToastUtils } from './utils/toast-util';
import { MessageService } from 'primeng/api';
import { RegistreService } from '../registre/RegistreService';
//import { UtilisateurComponent } from './utilisateur/utilisateur.component';

@NgModule({
  imports: [
    CommonModule,
  [BrowserModule, AgGridModule.withComponents([])],
  MaterialModule,
  BrowserModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
  ],
  providers: [NoteHttpService, NoteService  , CoursService,ToastUtils,MessageService,RegistreService

  ],
  bootstrap: [NoteComponent],
  declarations: [
  NoteComponent,
  CoursComponent,
 // UtilisateurComponent,
  ]
})
export class AppWebModule { }
