import { Component, OnInit } from '@angular/core';
import {FormControl} from '@angular/forms';
import { Classe } from '../../../model/classe';
import { Matier } from '../../../model/matier';
import { NoteService } from './note.service';
import { MatierEnseignantClasse } from '../../../model/MatierEnseignantClasse';
import { EleveNoteDTO } from '../../../model/EleveNoteDTO';
import { PARAMETERS } from '@angular/core/src/util/decorators';

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
  private classeSelectione: number; 
  private matiereSelectionee: number;
  private title: any;
  private columnDefs: any;
  private  rowData: any;
  private afficherClasses: MatierEnseignantClasse[]= [];
  private mecMatier: MatierEnseignantClasse[] = [];
  private  matierNonDouble : MatierEnseignantClasse[]= [];
  private eleveNoteDTOList: EleveNoteDTO[] = [];



  onClick(): void {
    console.log(this.classeSelectione);
  }

  onClasseSelection1() {
    console.log(this.classeSelectione);
  }


  constructor(private noteService: NoteService) {
    
  }


  getListMatiere() {
    debugger ;
    this.noteService.getMatierservice(1).subscribe( result=> { 
      this.matierEnseignantClasse = result ;


      //tableau matierNonDouble vide alors on fait l'initialization
      this.matierNonDouble.push(this.matierEnseignantClasse[0]);
      //taille de tableau sans duplication
      let m :number = 1;

      //bdit b'1 parsque j'ai déjà remplit le premier valeur
    for (let _i = 1; _i < this.matierEnseignantClasse.length ; _i++) {
      let j=0;
      let trouverDupliquer=false;
    while ((j < m) &&  ( trouverDupliquer == false )) {
        if (this.matierEnseignantClasse[_i].matier.idMatier  !=  this.matierNonDouble[j].matier.idMatier) {
          j++ ;
        }
          else {
             trouverDupliquer = true;
            }


        }
        if (j >= m ) {
          this.matierNonDouble.push(this.matierEnseignantClasse[_i]) ;
             m++ ;
            }
          }
    }) ;

  }
 


 selectionnermatier() {
  this.mecClasses = this.matierEnseignantClasse.filter( obj => obj.matier.idMatier == this.matiereSelectionee);
    }
// bch tjiblik tfiltri les classe ili l ma


agGridNoteEleve() {

  this.noteService.getNoteEleveService(5,11).subscribe( resultat => {
     this.eleveNoteDTOList =  resultat ;
     const distinctThings = this.eleveNoteDTOList.filter((eleveNote, i, arr) => {
      return arr.indexOf( 
        arr.find(t => {
          debugger;
          return t[2] === eleveNote[2] 
        })) ===i;
    });
    distinctThings.forEach(obj=> {
      debugger;
      this.columnDefs.push({
        headerName:obj[2],
        field:obj[2],
        filter:true,
        sortable:true 
        
      })
    
    })
   
    }) ;
  
 
   }
  
  


  ngOnInit() {
    this.getListMatiere();
    this.agGridNoteEleve();
    this.ngGridTableau();
  }
  ngGridTableau () {
  this.title = 'app';
  this.columnDefs =[ 

   {headerName: 'nom', field: 'make' , sortable: true , filter: true, checkboxSelection: true },
     {headerName: 'prénom', field: 'model', sortable: true, filter: true },
 ]; 

 console.log(this.columnDefs);


 this.rowData = [
     { make: 'ahmed', model: 'saadi', price: 18 , price1: 14 , price2: 12 },
     { make: 'senda', model: 'zargani', price: 15 , price1: 18 , price2: 15 },
     { make: 'mariem', model: 'Bouali', price: 15 , price1: 17 , price2: 15 },

 ];
  }
}
 

