import { Component, OnInit, ViewChild } from '@angular/core';
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
import { ExamenEnum } from './examensEnum';
import { MessageService } from 'primeng/api';
import { Examen } from '../../../model/examen';
import { EleveMatiereMoyenne } from '../../../model/EleveMatiereMoyenne';
import { ProgressSpinner } from 'primeng/progressspinner';

export interface Food {
  value: string;
  viewValue: string;
}



@Component({
  selector: 'app-note',
  templateUrl: './note.component.html',
  styleUrls: ['./note.component.css'],
  providers: [MessageService]
})
export class NoteComponent implements OnInit {
  private matiere1: Matier;
  private mecClasses: MatierEnseignantClasse[] = [];
  private matierEnseignantClasse: MatierEnseignantClasse[] = [];
  public classeSelectione: number;
  public matiereSelectionee: number;
  public Classe: number;

  public listDesNote: any[] = [];
  private title: any;
  private columnDefs: any;
  private rowData: any;
  private afficherClasses: MatierEnseignantClasse[] = [];
  private mecMatier: MatierEnseignantClasse[] = [];
  private matierNonDouble: MatierEnseignantClasse[] = [];
  private eleveNoteDTOList: EleveNoteDTO[] = [];
  public listresult2 = [];
  public listresult: any = [];
  public listExamen: Examen[] = [];
  public note: Note;
  public noteSauvegarder = [];
  public houObjct: any;


  ngOnInit() {
    this.getclasse();
    // this.getListMatiere();
    this.ngGridTableau();
    //this.NoteEleve()
    this.getListExamen();
  }
  public selectedScreen = "Registre des notes";

  constructor(private noteService: NoteService, private httpClient: HttpClient, private noteHttpService: NoteHttpService, private messageService: MessageService) {

  }
  showSuccess() {
    this.messageService.add({ severity: 'success', summary: 'Sauvegarde avec succé', detail: 'Note Sauvegarder' });
  }

  showError() {
    this.messageService.add({ severity: 'error', summary: 'Error ', detail: 'failed' });
  }
  ngGridTableau() {
    //creation des colonnes pour l'ag grid
    this.title = 'app';
    this.columnDefs = [

      { headerName: 'nom et prénom', field: 'nomEleve', sortable: true, filter: true, },
      { headerName: 'Note Controle 1', field: 'controle1', sortable: true, filter: true, editable: true },
      { headerName: 'Note Controle 2', field: 'controle2', sortable: true, filter: true, editable: true },
      { headerName: 'Note Orale', field: 'orale', sortable: true, filter: true, editable: true },
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
      this.classeSelectione = this.Classe[0].idClasse;
      this.creerAgGridNoteEleve();
    });
  }
  getListExamen() {
    let listnomExamen: String[] = [];
    this.noteService.getListExamen().subscribe(listExamen => {
      this.listExamen = listExamen;

    })
  }
  selectionnermatier() {
    this.mecClasses = this.matierEnseignantClasse.filter(obj => obj.matier.idMatier == this.matiereSelectionee);
  }


  // bch tjiblik tfiltri les classe ili l ma
  getNoteEleve(): Observable<EleveNoteDTO[]> {
    let params: HttpParams = new HttpParams();
    params = params.append('idClasse', this.classeSelectione.toString());
    let httpHeader: HttpHeaders = new HttpHeaders();
    httpHeader = httpHeader.set('Content-Type', 'application/json; charset=utf-8');
    return this.httpClient.get<EleveNoteDTO[]>('/getNoteEleve', { params: params, headers: httpHeader });

  }

  @ViewChild('spinner', { static: true }) public spinner: ProgressSpinner;
  creerAgGridNoteEleve(): void {

    this.getNoteEleve().subscribe(resultat => {
      let eleveNoteDTOList = resultat;
      console.log(eleveNoteDTOList);
      let list: RowDataNote[] = [];

      let map = Object.keys(resultat);
      map.forEach(nom => {
        let rd = { nomEleve: nom }
        for (let object of resultat[nom]) {
          let examen = { "idExamen": object.idExamen, "valeurNote": object.valeurNote }
          rd[object.nomExamen] = object.valeurNote;
          rd["idMatier"] = object.idMatier;
          rd["idEleve"] = object.idEleve;
        }
        list.push(rd);
      });
      this.listresult = list;

    });
  }

  onCellValueChanged(item){
    item.data.newOrModified="Modified";
  }
  sauvegarderNote(listresult) {
    // let listDesNote: any[] = [];
    const modifieditems = this.listresult.filter(item=> item.newOrModified === "Modified" );

    for (let agGridRow of modifieditems) {
      let newList: any[] = [];
      let columnsKeys: any[] = Object.keys(agGridRow);
      //calculer la moyenne
      for (let columnNameAgGrid of columnsKeys) {

        if ((columnNameAgGrid != "nomEleve") && (columnNameAgGrid != "idMatier") && (columnNameAgGrid != "idEleve" && (columnNameAgGrid != "nomEleve") && (columnNameAgGrid != "newOrModified"))) {
          //  newList = newList.concat(newObj)
          let newObj = this.transformGridToNoteDTO(agGridRow, columnNameAgGrid);
          newList.push(newObj);
          // newList.push(newObj);
        }
      }
     this.listDesNote = this.listDesNote.concat(newList);
    }
      //ajouter la moyenne 
      let listEleveMatiereMoyenne = this.creerListEleveMoyenne(this.listresult, this.listExamen);
      // const matiereMoyenne = listEleveMatiereMoyenne.filter((matiere) => matiere.idEleve === agGridRow.idEleve)[0];
      listEleveMatiereMoyenne.forEach((matiereMoyenne) => {
        this.listresult.forEach(element => {
        if(element.idEleve === matiereMoyenne.idEleve){
        let newObj : EleveNoteDTO = new EleveNoteDTO();
      newObj.idMatier = element.idMatier;
      newObj.idEleve = element.idEleve;
      newObj.idExamen = +ExamenEnum["moyenne"];
      newObj.valeurNote = matiereMoyenne.valeurMoyenne;  
      this.listDesNote.push(newObj);
        }
      });
    });
    this.httpClient.post<EleveNoteDTO[]>('/SauvegarderNote', this.listDesNote)
      .subscribe(d => {
        this.listresult = [];
        this.showSuccess();
        this.creerAgGridNoteEleve();
      });
    err => {
      this.showError();
    };

  }

  creerListEleveMoyenne(listNotes, listExamens) {
    let listEleveMatiereMoyenne: EleveMatiereMoyenne[] = [];
    for (let objNote of listNotes) {
      let newEleveMatiereMoyenne = new EleveMatiereMoyenne();
      newEleveMatiereMoyenne.idEleve = objNote.idEleve;
      newEleveMatiereMoyenne.idMatier = objNote.idMatier;
      let sommeCoefficeint = 0 ;
      for (let examen of listExamens) {
        let listnomExamen = Object.keys(objNote);
        for (let nomExamen of listnomExamen) {
          if ((nomExamen != "nomEleve") && (nomExamen != "idMatier") && (nomExamen != "idEleve") && (nomExamen == examen.nomExamen)) {
            let noteExamenAvecCoefficient = objNote[nomExamen] * examen.coefficeint
            newEleveMatiereMoyenne.valeurMoyenne = newEleveMatiereMoyenne.valeurMoyenne && noteExamenAvecCoefficient ?
              newEleveMatiereMoyenne.valeurMoyenne + noteExamenAvecCoefficient : noteExamenAvecCoefficient ? noteExamenAvecCoefficient : 0;
              sommeCoefficeint = sommeCoefficeint + examen.coefficeint;
            }
        }
      }
      // let sommeCoefficient = listExamens.reduce((a, b) => a + b.coefficeint, 0);
      newEleveMatiereMoyenne.valeurMoyenne = newEleveMatiereMoyenne.valeurMoyenne / sommeCoefficeint;
      listEleveMatiereMoyenne.push(newEleveMatiereMoyenne);
    }
    return listEleveMatiereMoyenne;
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
    });
  }




  getListNomEleve(): Observable<EleveNoteDTO[]> {
    let httpHeader: HttpHeaders = new HttpHeaders();
    httpHeader = httpHeader.set('Content-Type', 'application/json; charset=utf-8');
    return this.httpClient.get<EleveNoteDTO[]>('/getListEleveByIdClasse?idClasse=1', { headers: httpHeader });

  }
}

