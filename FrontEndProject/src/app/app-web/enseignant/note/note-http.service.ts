import { Injectable } from '@angular/core';
import { Note } from '../../../model/note';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Classe } from '../../../model/classe';
import { Matier } from '../../../model/matier';
import { Eleve } from '../../../model/eleve';
import { MatierEnseignantClasse } from '../../../model/MatierEnseignantClasse';
import { EleveNoteDTO } from '../../../model/EleveNoteDTO';
import {  NoteDt } from '../../../model/NoteDt';
import { NoteComponent } from './note.component';

@Injectable()
export class NoteHttpService{
private noteList: Note[];
private classe: Classe ;
private matier: Matier;
private eleveNote : EleveNoteDTO ;

  constructor(private httpClient: HttpClient) {
    this.noteList = [] ;
    this.classe = new Classe ();
    this.matier = new Matier();

  }

  getNote(idEleveList: Array<Number>): Observable<Note[]> {
    const params: HttpParams = new HttpParams ();
    params.set('idEleveList',  idEleveList.toString());
 return this.httpClient.get<Note[]> ('http://localhost:8080/madrasati/getNoteByIdenseignant', {params: params});
  }

  getEleve(idClasse: Number) {
    const params: HttpParams = new HttpParams();
    params.set('idClasse', idClasse.toString());
    return this.httpClient.get<Eleve> ('http://localhost:8080/madrasati/getEleveByIdClasse' , {params: params});
  }

getClasse(idEnseignant: Number ): Observable<Classe> {
  let params: HttpParams = new HttpParams();

  //const params: HttpParams = new HttpParams();
 // params.set('idEnseignant', idEnseignant.toString());
  //params.set( 'idMatier', idMatier.toString() );
  params = params.append('idEnseignant', idEnseignant.toString());

  return this.httpClient.get<Classe> ('http://localhost:8080/madrasati/getClassesByIdEnseignant', { params: params} );
}

getMatier(idEnseignant: Number): Observable<any> {
let params: HttpParams = new HttpParams();
params = params.append('idEnseignant', idEnseignant.toString());
 return this.httpClient.get<any> ('http://localhost:8080/madrasati/getMatiereByIdEnseignant', {params: params} );
}

//getNoteEleve(idMatier: number, idClasse: number): Observable<EleveNoteDTO[]> {
  //let params: HttpParams = new HttpParams();
 //params= params.append('idMatier', idMatier.toString());
 //params= params.append('idClasse', idClasse.toString());
  //return this.httpClient.get<EleveNoteDTO[]>('http://localhost:8080/madrasati/getNoteEleve', {params: params});

//}
ajouterNote(): Observable<EleveNoteDTO[]> {
  // tslint:disable-next-line:no-debugger
  return this.httpClient.post<EleveNoteDTO[]>('http://localhost:8080/madrasati/ajouterNote', this.eleveNote);
}

getNoteEleve(classeSelectione): Observable<EleveNoteDTO[]> {
  let httpHeader: HttpHeaders = new HttpHeaders();
  httpHeader = httpHeader.set('Content-Type', 'application/json; charset=utf-8');
  let params: HttpParams = new HttpParams();
  let params1: HttpParams = new HttpParams();
  params= params.append('idClasse', classeSelectione.toString());
  return this.httpClient.get<EleveNoteDTO[]>('http://localhost:8080/madrasati/getNoteEleve', { headers: httpHeader , params:params });

}
}



