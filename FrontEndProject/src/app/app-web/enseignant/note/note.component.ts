import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Classe } from '../../../model/classe';
import { Matier } from '../../../model/matier';
import { NoteService } from './note.service';
import { MatierEnseignantClasse } from '../../../model/MatierEnseignantClasse';
import { EleveNoteDTO } from '../../../model/EleveNoteDTO';
import { RowDataNote } from '../../../model/RowDataNote';
import { Note } from '../../../model/note';
import { Observable } from 'rxjs';
import { HttpHeaders, HttpParams, HttpClient } from '@angular/common/http';
import { NoteHttpService } from './note-http.service';
import { RegistreDTO } from 'src/app/model/RegistreDTO';
import { ExamenEnum } from './examensEnum';
import { MessageService } from 'primeng/api';

export interface Food {
  value: string;
  viewValue: string;
}



@Component({
  selector: 'app-note',
  templateUrl: './note.component.html',
  styleUrls: ['./note.component.css'],
  styles: [`
  :host ::ng-deep button {
      margin-right: .25em;
  }

  :host ::ng-deep .custom-toast .ui-toast-message {
      background: #FC466B;
      background: -webkit-linear-gradient(to right, #3F5EFB, #FC466B);
      background: linear-gradient(to right, #3F5EFB, #FC466B);
  }

  :host ::ng-deep .custom-toast .ui-toast-message div {
      color: #ffffff;
  }

  :host ::ng-deep .custom-toast .ui-toast-message.ui-toast-message-info .ui-toast-close-icon {
      color: #ffffff;
  }
`],
  providers: [MessageService]
})
export class NoteComponent implements OnInit {
  private matiere1: Matier;
  private mecClasses: MatierEnseignantClasse[] = [];
  private matierEnseignantClasse: MatierEnseignantClasse[] = [];
  public classeSelectione: number;
  public matiereSelectionee: number;
  public Classe: number;


  private title: any;
  private columnDefs: any;
  private rowData: any;
  private afficherClasses: MatierEnseignantClasse[] = [];
  private mecMatier: MatierEnseignantClasse[] = [];
  private matierNonDouble: MatierEnseignantClasse[] = [];
  private eleveNoteDTOList: EleveNoteDTO[] = [];
  public listresult2 = [];
  public listresult :any = [];

  public note: Note;
  public noteSauvegarder = [];
  public houObjct: any;


  ngOnInit() {
    this.getclasse();
    // this.getListMatiere();
    this.ngGridTableau();
    //this.NoteEleve()
  }
 
  constructor(private noteService: NoteService, private httpClient: HttpClient, private noteHttpService: NoteHttpService, private messageService : MessageService ) {

  }
  showSuccess() {
    this.messageService.add({severity:'success', summary: 'Sauvegarde avec succé', detail:'Note Sauvegarder'});
  }

showError() {
  this.messageService.add({severity:'error', summary: 'Error ', detail:'failed'});
}
 ngGridTableau() {
   //creation des colonnes pour l'ag grid
    this.title = 'app';
    this.columnDefs = [

      { headerName: 'nom et prénom', field: 'nomEleve', sortable: true, filter: true, },
      { headerName: 'Note Controle 1', field: 'controle1', sortable: true, filter: true, editable: true },
      { headerName: 'Note Controle 2', field: 'controle2', sortable: true, filter: true, editable: true },
      { headerName: 'Note Orale', field: 'orale',sortable: true, filter: true, editable: true },
      { headerName: 'Note Synthése', field: 'synthese', sortable: true, filter: true, editable: true },
      { headerName: 'Moyenne', field: 'moyenne', sortable: true, filter: true, editable: true },


    ];



  
  }


  onClick(): void {
    console.log(this.classeSelectione);
  }

  onClasseSelection1() {
    console.log(this.classeSelectione);
  }



  getListMatiere() {
    this.noteService.getMatierservice(8).subscribe(result => {
      this.matierEnseignantClasse = result;
      console.log(this.matierEnseignantClasse)
    });

  }

  getclasse() {
    this.noteService.getClasseservice(8).subscribe(result => {
      this.Classe = result;
      console.log(this.Classe);
    });
  }

  selectionnermatier() {
    this.mecClasses = this.matierEnseignantClasse.filter(obj => obj.matier.idMatier == this.matiereSelectionee);
  }


  // bch tjiblik tfiltri les classe ili l ma
  getNoteEleve(): Observable<EleveNoteDTO[]> {
    let params: HttpParams = new HttpParams();
    params= params.append('idClasse', this.classeSelectione.toString());
    let httpHeader: HttpHeaders = new HttpHeaders();
    httpHeader = httpHeader.set('Content-Type', 'application/json; charset=utf-8');
    return this.httpClient.get<EleveNoteDTO[]>('http://localhost:8080/madrasati/getNoteEleve', {params: params, headers: httpHeader });

  }

  creerAgGridNoteEleve():void{
    this.getNoteEleve().subscribe(resultat => {
      let eleveNoteDTOList = resultat;
      console.log(eleveNoteDTOList);
      let list: RowDataNote[] = [];

      let map = Object.keys(resultat);
      map.forEach(nom => {
        let rd = { nomEleve: nom }
        for (let object of resultat[nom]) {
          let examen = { "idExamen": object.idExamen, "valeurNote" : object.valeurNote}
          rd[object.nomExamen] = object.valeurNote;
          rd["idMatier"] = object.idMatier;
          rd["idEleve"] = object.idEleve;
        }
        list.push(rd);
      });
      this.listresult = list;

    });
  }


  sauvegarderNote(listresult) {
    let listDesNote: any[] = [];

    for (let agGridRow of this.listresult) {
      let newList: any[] = [];
      let columnsKeys: any[] = Object.keys(agGridRow);

      for (let columnNameAgGrid of columnsKeys) {

        if ((columnNameAgGrid != "nomEleve") && (columnNameAgGrid != "idMatier") && (columnNameAgGrid != "idEleve" && (columnNameAgGrid != "nomEleve"))) {
          //  newList = newList.concat(newObj)
          let newObj = this.transformGridToNoteDTO(agGridRow, columnNameAgGrid);
          newList.push(newObj);
          // newList.push(newObj);
        }
      }
      listDesNote = listDesNote.concat(newList);
    }
    this.httpClient.post<EleveNoteDTO[]>('http://localhost:8080/madrasati/SauvegarderNote', listDesNote)
      .subscribe(d => {
       this.showSuccess();
      });
      err => {
        this.showError();
    };

  }

  transformGridToNoteDTO(object, keyColumnName) {
    let newObj: EleveNoteDTO = new EleveNoteDTO();
    newObj.idMatier = object.idMatier;
    newObj.idEleve = object.idEleve;
    newObj.idExamen = +ExamenEnum[keyColumnName];
    newObj.valeurNote = +object[keyColumnName];
    return newObj;
  }


  enregistrerNote() {
    this.noteService.postNote().subscribe(result => {
      console.log(result);
    });
  }




   getListNomEleve() :  Observable<EleveNoteDTO[]> {
    let httpHeader: HttpHeaders = new HttpHeaders();
    httpHeader = httpHeader.set('Content-Type', 'application/json; charset=utf-8');
    return this.httpClient.get<EleveNoteDTO[]>('http://localhost:8080/madrasati/getListEleveByIdClasse?idClasse=1', { headers: httpHeader });

   }
}

