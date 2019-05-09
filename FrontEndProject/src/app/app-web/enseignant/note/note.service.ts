import { Injectable } from '@angular/core';
import { Classe } from '../../../model/classe';
import { CreerclasseComponent } from '../../../creerclasse/creerclasse.component';
import { NoteHttpService } from './note-http.service';
import { Matier } from '../../../model/matier';
import { MatierEnseignantClasse } from '../../../model/MatierEnseignantClasse';
import { Observable } from 'rxjs';
import { EleveNoteDTO } from '../../../model/EleveNoteDTO';

@Injectable()
export class NoteService {
 public matieres: MatierEnseignantClasse[];
  constructor(private noteHttpService: NoteHttpService) {
   }


   getClasseservice(idEnseignant: number, idMatier: number) {
    this.noteHttpService.getClasse(idEnseignant , idMatier);
   }

   getMatierservice(idEnseignant: number ) : Observable<MatierEnseignantClasse[]> {
    return  this.noteHttpService.getMatier(idEnseignant);
   }
 
   getNoteEleveService(idMatier: number, idClasse: number) :  Observable<EleveNoteDTO[]> {
      
   return this.noteHttpService.getNoteEleve(idMatier , idClasse);


   }
}
