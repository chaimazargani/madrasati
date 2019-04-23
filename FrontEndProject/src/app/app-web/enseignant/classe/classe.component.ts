import { Component, OnInit } from '@angular/core';
import {FormControl} from '@angular/forms';
import { Classe } from '../../../model/classe';
import { Matiere } from '../../../model/matiere';

export interface Food {
  value: string;
  viewValue: string;
}



@Component({
  selector: 'app-classe',
  templateUrl: './classe.component.html',
  styleUrls: ['./classe.component.css']
})
export class ClasseComponent implements OnInit {
  private classe1: Classe;
  private matiere1: Matiere;
  private classes: Classe[] = [];
  private matieres: Matiere[] = [];
  private classeSelectione: number; 
  private matiereSelectionee: number;

  onClick(): void {
    console.log(this.classeSelectione);
  }

  onClasseSelection1() {
    console.log(this.classeSelectione);
  }

 
  constructor() {
    this.classe1 = new Classe() ;
 this.classe1.idClasse = 1 ;
 this.classe1.nomClasse = 'classeb1';
 this.classe1.nombreEleve = 25 ;
 this.classes.push(this.classe1);
    this.matiere1 = new Matiere ;
    this.matiere1.idMatiere = 2 ;
    this.matiere1.nbrHeur = 4 ;
    this.matiere1.nomMatiere = 'algébre' ;
    this.matiere1.section = 'math';
    this.matieres.push(this.matiere1);
  }

  title = 'app';
    columnDefs = [
      {headerName: 'nom', field: 'make' , sortable: true , filter: true, checkboxSelection: true },
        {headerName: 'prénom', field: 'model', sortable: true, filter: true },
        {headerName: 'Synthése', field: 'price', sortable: true , filter: true},
        {headerName: 'Controle', field: 'price1', sortable: true , filter: true},
        {headerName: 'Orale', field: 'price2', sortable: true , filter: true},

  ];

  rowData = [
      { make: 'ahmed', model: 'saadi', price: 18 , price1: 14 , price2: 12 },
      { make: 'senda', model: 'zargani', price: 15 , price1: 18 , price2: 15 },
      { make: 'mariem', model: 'Bouali', price: 15 , price1: 17 , price2: 15 },
  ];
  


  ngOnInit() {

  }
}
 

