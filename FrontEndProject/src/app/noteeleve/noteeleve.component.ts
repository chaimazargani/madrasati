import { Component, OnInit } from '@angular/core';
import { HttpParams, HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-noteeleve',
  templateUrl: './noteeleve.component.html',
  styleUrls: ['./noteeleve.component.css']
})
export class NoteeleveComponent implements OnInit {
public columnDefs  : any ;
public niveauList : any ;
public listresult : any ;
  constructor(private httpClient : HttpClient) {

   
    this.columnDefs = [
      {  headerName:"list des Matiére " ,
      children: [ 
        {headerName:"Matiére ", field:"nomMatier", minWidth:300,maxWidth:null,columnGroupShow:null , sortable: false , filter: true},
        {headerName: 'Note Controle 1', field: 'controle1' , sortable: true , filter: true , editable : false  },
        {headerName: 'Note Controle 2', field: 'controle2' , sortable: true , filter: true , editable : false },
        {headerName: 'Note Orale', field: 'orale' , sortable: true , filter: true , editable : false },
        {headerName: 'Note Synthése', field: 'synthése' , sortable: true , filter: true , editable : false } ,
        {headerName: 'Moyenne', field: 'moyenne' , sortable: true , filter: true , editable : false},
    
        ]
      }];
    
    
    


   }

  ngOnInit() {
    this. getNote() ; 
  }
  getNoteelve(): Observable<any> {
    let httpHeader:HttpHeaders = new HttpHeaders();
    httpHeader = httpHeader.set('Content-Type', 'application/json; charset=utf-8');
    let params: HttpParams = new HttpParams();
    return this.httpClient.get<any> ('http://localhost:8080/madrasati/getNoteBYEleve?idEleve=1', {headers:httpHeader ,  params:params });
  }

  getNote() : void {
    let nomExamen : any = []; 
  let valeurNote : any = [];
this.getNoteelve().subscribe(result => {

  // subsribe ili bch t7el l karthouna observable
  this.niveauList = result ;
  console.log( this.niveauList);

  let list : any[]=[] ;
    let map = Object.keys(result);  
    map.forEach (nom => {
      let rd = { nomMatier: nom }
      for ( let object of result[nom] ) {
        nomExamen = object.nomExamen ;
          valeurNote = object.valeurNote ;
         rd[nomExamen] =valeurNote;
      }
  list.push(rd);
})
this.listresult = list;
});
  }

}
