import { Component, OnInit, ViewChild } from '@angular/core';
import { RegistreDTO } from '../model/RegistreDTO';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { AgGridAngular } from 'ag-grid-angular';
import { RowData } from '../model/rowData';
import { ColomnDef } from '../model/ColomnDef';
import { Children } from '../model/Children';
import { Niveau } from '../model/niveau';
import { Classe } from '../model/classe';
import { DatePipe } from '@angular/common';
@Component({
  selector: 'app-registre',
  templateUrl: './registre.component.html',
  styleUrls: ['./registre.component.css']
})
export class RegistreComponent implements OnInit {
  registreDTO: RegistreDTO;
  listRegistredto: RegistreDTO[];
 public columnDefs:any ;
 public  columnDefs1 : ColomnDef ;
 public  rowData: any = [] ;

 public  children : Children ;
 public niveauSelectionner : number ;
  public columnDeflist  : ColomnDef[]= [] ;
  public classeSelectionner : number ;
  public dateSelectionner; 
  public datepipe: DatePipe
  public  listnomEleve : any[] = [];
  public    listresult = []; 
public placeholder = 'Please select Date'
  selected = 'option2';
  selected2 = 'option2';


  constructor(private httpClient: HttpClient) {

   
    //construction de objet children
    // let children1:Children;
    // children1 = {
    //   headerName:"Nom et Prénom",
    //   field:"nomEleve",
    //   minWidth:300,
    //   maxWidth:null,
    //   columnGroupShow:null,
      
    // } ;
    //construction et remplissage du list of children
   // let childrenList: Children[] = [] ; 
   // childrenList.push(children1);



   // this.listRegistredto = [];
  
    // this.columnDefs = {  
    //   headerName:"list des éleves",
    //   marryChildren:true,
    //   children : childrenList ,
  
    // }

    this.columnDefs = [
  {  headerName:"list des éleves" ,
  children: [ 
    {headerName:"Nom et Prénom", field:"nomEleve", minWidth:300,maxWidth:null,columnGroupShow:null , sortable: true , filter: true, checkboxSelection: true},
    { headerName: '8h', field: '8' ,  sortable: true, filter: true , editable: true},
    { headerName: '9h', field: '9' , editable: true },
    { headerName: '10h', field: '10' ,  editable: true },
    { headerName: '11h', field: '11' ,  editable: true },
    { headerName: '12h', field: '12' ,  editable: true },
    { headerName: '13h', field: '13' ,  editable: true  },
    { headerName: '14h', field: '14',  editable: true  },

    ]
  }];




// let children2 : Children ;
//   children2 = {
//     headerName:"8h-9h",
//     field:"date1heure1",
//     minWidth:300,
//     maxWidth: 550,
//     columnGroupShow: "open",
  
//   }
 
//   let children3 : Children ;
//   children3 = {
//     headerName:"9h-10h",
//     field:"date1heure3",
//     minWidth:300,
//     maxWidth: 550,
//     columnGroupShow: "open",
   
//   }
//   let children4 : Children ;
//   children4 = {
//     headerName:"10h-11h",
//     field:"date1heure4",
//     minWidth:300,
//     maxWidth: 550,
//     columnGroupShow: "open",
   
//   }
//  let children5 : Children ; 
//  children5 = {
//   headerName:"11h-12h",
//   field:"date1heure5",
//   minWidth:300,
//   maxWidth: 550,
//   columnGroupShow: "open",
 
// }

// let children6 : Children ; 
// children6 = {
//  headerName:"12h-13h",
//  field:"date1heure6",
//  minWidth:300,
//  maxWidth: 550,
//  columnGroupShow: "open",

// }

// let children7 : Children ; 
// children7 = {
//  headerName:"13h-14h",
//  field:"date1heure7",
//  minWidth:300,
//  maxWidth: 550,
//  columnGroupShow: "open",
 
// }

// let children8 : Children ; 
// children8 = {
//  headerName:"15h-16h",
//  field:"date1heure8",
//  minWidth:300,
//  maxWidth: 550,
//  columnGroupShow: "open",

// }
// let children9 : Children ; 
// children9 = {
//  headerName:"16h-17h",
//  field:"date1heure9",
//  minWidth:300,
//  maxWidth: 550,
//  columnGroupShow: "open",

// }

// let children10 : Children ; 
//  children10 = {
//  headerName:"17h-18h",
//  field:"date1heure10",
//  minWidth:300,
//  maxWidth: 550,
//  columnGroupShow: "open",
//  }
 
 //let childrenList2: Children[] = [] ;
 //childrenList2.push(children1);
  // children2 , children3 , children4 , children5 , children6 , children7 , children8 , children9, children10

//  this.columnDefs1 = {
//   headerName : "03-01-2020" ,
//   marryChildren: null ,
//   children : childrenList2 ,
 

// }
//this.columnDeflist.push(this.columnDefs )

 //this.rowData = [
   this.listnomEleve = [{ nomEleve: 'ahmed', date1heure1: 'present' , date1heure2: 'present' , date1heure3: 'absent', date1heure4: 'present' }]
//    { nomEleve: 'asma', date1heure1: 'absente' , date1heure2: 'absente' , date1heure3: 'presente', date1heure4: 'presente' },
//   { nomEleve: 'amal', date1heure1: 'present' , date1heure2: 'exclut' , date1heure3: 'absent', date1heure4: 'presente' },
//   { nomEleve: 'chaima', date1heure1: 'exclut' , date1heure2: 'present' , date1heure3: 'absent', date1heure4: 'present' },



 };

  ngOnInit(): void {
    this.getListNiveau();
    } 
  
 

  getRegistre(): Observable<Map<string,RegistreDTO[]>> {
    let httpHeader: HttpHeaders = new HttpHeaders();
  httpHeader = httpHeader.set('Content-Type', 'application/json; charset=utf-8');
  let params: HttpParams = new HttpParams();
  let params1: HttpParams = new HttpParams();

  let date: HttpParams = new HttpParams();
  //hédha mta3 datepiker format (string) 20/10/2020
  console.log('hédha mta3 datepiker format (string) ');
console.log(this.dateSelectionner);
  //datepicker badalnéh de type Date javascript Wednesday Oct 2020 8h00
  let dateDate = new Date(this.dateSelectionner);
  let datePlusHour = dateDate.setHours(1);
  let dataDatePlusHour = new Date(datePlusHour);
  console.log('datepicker badalnéh de type Date javascript Timestamp w zédnéh sé3a')
  console.log(datePlusHour);
    console.log('date piker Date transofrm iso Datefomat 20102020T');
  let dateIsoFormat = dataDatePlusHour.toISOString();
console.log(dateIsoFormat);
  params= params.append('idClasse', this.classeSelectionner.toString());
  params= params.append('datePresenceString', dateIsoFormat.toString());

  return this.httpClient.get<Map<string,RegistreDTO[]>>('http://localhost:8080/madrasati/getPresenceByIdEleve', { headers: httpHeader , params:params });

 }

 public rowDataList :  RegistreDTO [] = [] ;
 

  @ViewChild('agGridComponent') agGridComponent : AgGridAngular
 // datePresenceString : string = "2020-10-19T08:00Z"
 getListregistre(): void {

let list : any [];
let hour : any = []; 
let etat : any = [];
let nouveauObjet : any={} ;

  this.getRegistre ( ).subscribe(result => {
   
    let list : RowData[]=[] ;
    let map = Object.keys(result);  
    map.forEach (nom => {
      let rd = { nomEleve: nom }
     for ( let object of result[nom] ) {
      hour = object.datePresence.hour ;
         etat = object.nomEtat ;
         rd[hour] =etat;
    }
    list.push(rd);

    })
this.listresult = list;
console.log(result);


 //nouveauObjet[hour] =etat
 let abc =  nouveauObjet["8"]
console.log(hour)

  });
  
 }
 
  getObjetaggrid(result): any {
  }

  getColomnDef(result): any {

  }
  
getNiveau():  Observable<Niveau[]> {
  let httpHeader:HttpHeaders = new HttpHeaders();
  httpHeader = httpHeader.set('Content-Type', 'application/json; charset=utf-8');
  return this.httpClient.get<Niveau[]>('http://localhost:8080/madrasati/getListNiveau?idNiveau= 1,2,3,4,5,6',{headers:httpHeader});


}
public niveauList : Niveau[] ;

getListNiveau(): void {
  this.getNiveau().subscribe(result => {
    // subsribe ili bch t7el l karthouna observable
    this.niveauList = result ;
    console.log(result);
  });
}


public classeList : Classe[] ;

getClasseByNiveau( ): Observable <Classe[]> {
  let httpHeader : HttpHeaders = new HttpHeaders();
  httpHeader = httpHeader.set('Content-Type', 'application/json; charset=utf-8');
  let niveauParametre: HttpParams = new HttpParams();
  niveauParametre= niveauParametre.append('idNiveau', this.niveauSelectionner.toString());

   return this.httpClient.get<Classe[]>('http://localhost:8080/madrasati/getClassesByIdNiveau',{headers:httpHeader,params:niveauParametre})
}
  getListClasse(): void {
    this.getClasseByNiveau().subscribe(result => {
      this.classeList = result ;
      console.log(result);
    });

    
  }
}
