import { Component, OnInit } from '@angular/core';
import {FormControl} from '@angular/forms';
import { Classe } from '../../../model/classe';
import { Matier } from '../../../model/matier';
import { NoteService } from './note.service';
import { MatierEnseignantClasse } from '../../../model/MatierEnseignantClasse';
import { EleveNoteDTO } from '../../../model/EleveNoteDTO';
import { PARAMETERS } from '@angular/core/src/util/decorators';
import { RowDataNote } from '../../../model/RowDataNote';
import { Note } from '../../../model/note';
import { Observable } from 'rxjs';
import { HttpHeaders, HttpParams, HttpClient } from '@angular/common/http';
import { NoteHttpService } from './note-http.service';

export interface Food {
  value: string;
  viewValue: string;
}



@Component({
  selector: 'app-note',
  templateUrl: './note.component.html',
  styleUrls: ['./note.component.css']
})
export class NoteComponent implements OnInit {
  private matiere1: Matier;
  private mecClasses: MatierEnseignantClasse[] = [];
  private matierEnseignantClasse: MatierEnseignantClasse[] = []; 
  public  classeSelectione: number; 
  public matiereSelectionee: number;
  public Classe : number ;


  private title: any;
  private columnDefs: any;
  private  rowData: any;
  private afficherClasses: MatierEnseignantClasse[]= [];
  private mecMatier: MatierEnseignantClasse[] = [];
  private  matierNonDouble : MatierEnseignantClasse[]= [];
  private eleveNoteDTOList: EleveNoteDTO[] = [];
  public    listresult = []; 
  public note : Note ;



  onClick(): void {
    console.log(this.classeSelectione);
  }

  onClasseSelection1() {
    console.log(this.classeSelectione);
  }


  constructor(private noteService: NoteService , private httpClient: HttpClient ,  private noteHttpService: NoteHttpService) {
    
  }


  getListMatiere() {
    this.noteService.getMatierservice(8).subscribe( result=> { 
      this.matierEnseignantClasse = result ;
   console.log(this.matierEnseignantClasse)

      //tableau matierNonDouble vide alors on fait l'initialization
    //   this.matierNonDouble.push(this.matierEnseignantClasse[0]);
    //   //taille de tableau sans duplication
    //   let m :number = 1;

    //   //bdit b'1 parsque j'ai déjà remplit le premier valeur
    // for (let _i = 1; _i < this.matierEnseignantClasse.length ; _i++) {
    //   let j=0;
    //   let trouverDupliquer=false;
    // while ((j < m) &&  ( trouverDupliquer == false )) {
    //     if (this.matierEnseignantClasse[_i].matier.idMatier  !=  this.matierNonDouble[j].matier.idMatier) {
    //       j++ ;
    //     }
    //       else {
    //          trouverDupliquer = true;
    //         }


    //     }
    //     if (j >= m ) {
    //       this.matierNonDouble.push(this.matierEnseignantClasse[_i]) ;
    //          m++ ;
    //          console.log( this.matierNonDouble)

    //         }
    //       }
    }) ;

  }
 
getclasse() {
  this.noteService. getClasseservice(8).subscribe( result=> { 
    this.Classe = result ;
    console.log(this.Classe);
  }) ;
}

 selectionnermatier() {
  this.mecClasses = this.matierEnseignantClasse.filter( obj => obj.matier.idMatier == this.matiereSelectionee);
  }

  
// bch tjiblik tfiltri les classe ili l ma


NoteEleve() : void {
  let list : any =[] ;
  let nomExamen : any = []; 
  let valeurNote : any = [];
  this.noteHttpService.getNoteEleve(this.classeSelectione).subscribe( resultat => {
   
    let eleveNoteDTOList =  resultat ;
    console.log(eleveNoteDTOList) ;
    let list : RowDataNote[]=[] ;

     let map = Object.keys(resultat );  
    map.forEach (nom => {
   let rd = { nomPrenom : nom }
   for ( let object of resultat[nom] ) {
    nomExamen = object.nomExamen ;
       valeurNote = object.valeurNote ;
       rd[nomExamen] =valeurNote;
  }
  list.push(rd);

    //  const distinctThings = this.eleveNoteDTOList.filter((eleveNote, i, arr) => {
    //   return arr.indexOf( 
    //     arr.find(t => {
    //       debugger;
    //       return t[2] === eleveNote[2] 
    //     })) ===i;
    // });
    // distinctThings.forEach(obj=> {
    //   debugger;
    //   this.columnDefs.push({
    //     headerName:obj[2],
    //     field:obj[2],
    //     filter:true,
    //     sortable:true 
        
    //   })
    
    });
    this.listresult = list;
    console.log(this.listresult);

    }) ;
  
 
   }
  
  


  ngOnInit() {
    this.getclasse() ;
    // this.getListMatiere();
    this.ngGridTableau();
     //this.NoteEleve()
  }
  ngGridTableau () {
  this.title = 'app';
  this.columnDefs =[ 

    {headerName: 'nom et prénom', field: 'nomPrenom' , sortable: true , filter: true, },
    {headerName: 'Note Controle 1', field: 'controle1' , sortable: true , filter: true , editable : true },
    {headerName: 'Note Controle 2', field: 'controle2' , sortable: true , filter: true , editable : true },
    {headerName: 'Note Orale', field: 'orale' , sortable: true , filter: true , editable : true },
    {headerName: 'Note Synthése', field: 'synthese' , sortable: true , filter: true , editable : true},
    {headerName: 'Moyenne', field: 'moyenne' , sortable: true , filter: true , editable : true},
 
 
 ]; 

 console.log(this.columnDefs);


//  this.rowData = [
//      {nomPrenom: 'Ikram saadi', controle1: 15, orale: 18 , synthese: 14 , moyenne: 12 , controle2 : 15 },
//      {nomPrenom: 'Chaima zargani', controle1: 18, orale: 18 , synthese: 14 , moyenne: 12 , controle2 : 15  },
//      {nomPrenom: 'Mariem bouali', controle1: 19, orale: 18 , synthese: 14 , moyenne: 12 , controle2 : 15  },

//  ];
   }
  enregistrerNote() {
    this.noteService.postNote().subscribe(result => {
      console.log(result);
    });
   }
  

   

  //  getNoteEleveService() :  Observable<EleveNoteDTO[]> {
  //     return this.getNoteEleve();
 
  //    }
}

