import { Component, OnInit } from '@angular/core';
import { ExamenService } from './creerexamen.service';
import { Observable } from 'rxjs';
import { Examen } from '../model/examen';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-creerexamen',
  templateUrl: './creerexamen.component.html',
  styleUrls: ['./creerexamen.component.css']
})
export class CreerexamenComponent implements OnInit {
public examen : Examen ;
public cars : any ;
public columnDefs : any ; 
public rowData : Examen ; 
public    listresult = []; 
//cols: any[];
//dataSource :  any[];
//displayedColumns: string[] = ['position', 'name', 'weight', 'symbol'];

  constructor(private httpClient : HttpClient) {
  this.examen = new Examen();
  this.columnDefs = [
    {  headerName:"Examen" ,
    children: [ 
      {headerName:"Examen", field:"nomExamen", minWidth:300,maxWidth:null,columnGroupShow:null , sortable: true , filter: true, checkboxSelection: true},
      { headerName: 'coefficeint', field: 'coefficeint' ,  sortable: true, filter: true , editable: true},
      
      ]
    }];
    // this.rowData = [
    //   { nomExamen: 'DS', cofficient: '2'  }
    //   { nomExamen: 'CONTROLE', cofficient: '2'  }

       
       
    //  ];
  
   }

  ngOnInit() {
  
  }
  ajouterExamen(): Observable<Examen[]> {
    // tslint:disable-next-line:no-debugger
    return this.httpClient.post<Examen[]>('http://localhost:8080/madrasati/ajouterExamen', this.examen);
  }
  sauvegarder() {
    this. ajouterExamen().subscribe(result => {
      console.log(result);
    });
}
getListExamen(): Observable<Examen[]> {
  
let httpHeader:HttpHeaders = new HttpHeaders();
httpHeader = httpHeader.set('Content-Type', 'application/json; charset=utf-8');
  return this.httpClient.get<Examen[]>('http://localhost:8080/madrasati/getExamen',{headers:httpHeader});
}
afficherListDesExamen() : void {
  let list : any[] = [];
  let coef : any = []; 
  this.getListExamen().subscribe(result=> {
     
    let map = Object.keys(result);  
    map.forEach (nom => {
      let rd = { nomExamen: nom }
      for ( let object of result[nom] ) {
        coef = object.coefficeint ;
       rd[nom] 

    }
      list.push(rd);

    })
   this.listresult = list;
    console.log(this.listresult);
   })
}
supprimerExamen(): Observable<Examen> {
 return this.httpClient.post<Examen>('http://localhost:8080/madrasati/supprimerExamen', this.examen );
}
supprimerUnExamen() : void {
this.supprimerExamen().subscribe(result=>{
  console.log(result);
})

}
modifierExamen(): Observable<Examen> {
  return this.httpClient.post<Examen>('http://localhost:8080/madrasati/modifierExamen', this.examen );
 }
 modifierUnExamen() : void {
  this.modifierExamen().subscribe(result=>{
    console.log(result);
  })
  
  }
}
