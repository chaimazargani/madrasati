import { Component, OnInit } from '@angular/core';
import {FormControl} from '@angular/forms';

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
  foods = [
    {value: 'steak-0', viewValue: 'Steak'},
    {value: 'pizza-1', viewValue: 'Pizza'},
    {value: 'tacos-2', viewValue: 'Tacos'}
  ];
  constructor() {

   }

  ngOnInit() {

  }

 

}
