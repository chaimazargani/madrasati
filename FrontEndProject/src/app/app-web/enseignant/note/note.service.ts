import { Injectable } from '@angular/core';
import { NoteHttpService } from './note-http.service';
import { MatierEnseignantClasse } from '../../../model/MatierEnseignantClasse';
import { Observable } from 'rxjs';
import { Examen } from '../../../model/examen';

@Injectable()
export class NoteService {
 public matieres: MatierEnseignantClasse[];
  constructor(private noteHttpService: NoteHttpService) {
   }


   getClasseservice(idEnseignant: number ) :Observable<any> {
    return this.noteHttpService.getClasse(idEnseignant );
   }

   getMatierservice(idEnseignant: number ) : Observable<any> {
    return  this.noteHttpService.getMatier(idEnseignant);
   }
 
   //getNoteEleveService(idMatier: number, idClasse: number) :  Observable<EleveNoteDTO[]> {
      //return this.noteHttpService.getNoteEleve(idMatier , idClasse);
   //}
     postNote(){
        return this.noteHttpService.ajouterNote()
     }

     getListExamen() :Observable<Examen[]>{
        return this.noteHttpService.getExamen()
     } 
}