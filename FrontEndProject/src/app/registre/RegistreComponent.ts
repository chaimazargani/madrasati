import { Component, OnInit, ViewChild, ViewEncapsulation } from '@angular/core';
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
import { CheckboxRenderer } from './checkbox-renderer.component';
import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
import {MenubarModule} from 'primeng/menubar';
import {MenuItem, MessageService} from 'primeng/api';
@Component({
  selector: 'app-registre',
  templateUrl: './registre.component.html',
  styleUrls: ['./registre.component.css'],
  encapsulation: ViewEncapsulation.None,
  providers: [MessageService]
})
export class RegistreComponent implements OnInit {
  registreDTO: RegistreDTO;
  listRegistredto: RegistreDTO[];
 public columnDefs:any ;
 public  columnDefs1 : ColomnDef ;
 public  rowData: any = [] ;
 private gridApi;
public frameworkComponents;
 public  children : Children ;
 public niveauSelectionner : number ;
  public columnDeflist  : ColomnDef[]= [] ;
  public classeSelectionner : number ;
  public dateSelectionner; 
  public datepipe: DatePipe
  public  listnomEleve : any[] = [];
  public    listresult = []; 
  public datePresence : any = []; 
  public date : any ; 
  public list : any ; 
  public list2 : any ;

public placeholder = 'Please select Date'
  selected = 'option2';
  selected2 = 'option2';
  public rowHeight ;

  public selectedScreen = "Registre de Présence";

  constructor(private httpClient: HttpClient , public messageService : MessageService) {

   
    this.rowHeight = 30;


    this.columnDefs = [
    {headerName:"Nom et Prénom", field:"nomEleve", width: 190 ,resizable:true,columnGroupShow:null , sortable: true , filter: true},
    { headerName: '8h', field: '8' , width: 95,  resizable:true, sortable: false, editable: false ,filter: true , cellRenderer: 'checkboxRenderer'},
    { headerName: '9h', field: '9' , width: 95,  editable: false , filter: true , cellRenderer:'checkboxRenderer' },
    { headerName: '10h', field: '10', width: 95 ,resizable:true, /*  */  editable: false ,filter: true , cellRenderer: 'checkboxRenderer'} ,
    { headerName: '11h', field: '11', width: 95 ,resizable:true,  editable: false  , filter: true , cellRenderer: 'checkboxRenderer'},
    { headerName: '12h', field: '12', width: 95 ,resizable:true,  editable: false , filter: true , cellRenderer: 'checkboxRenderer'},
    { headerName: '13h', field: '13', width: 95 ,resizable:true,  editable: false ,filter: true , cellRenderer: 'checkboxRenderer'},
    { headerName: '14h', field: '14', width: 95,resizable:true,  editable: false   ,filter: true, cellRenderer: 'checkboxRenderer'},
    { headerName: '15h', field: '12', width: 95 ,resizable:true,  editable: false  , filter: true, cellRenderer:'checkboxRenderer'},
    { headerName: '16h', field: '16', width: 95 ,resizable:true,  editable: false ,filter: true , cellRenderer:'checkboxRenderer'},
    { headerName: '17h', field: '17', width: 95, resizable:true, editable: false ,filter: true, cellRenderer:'checkboxRenderer'},
    { headerName: '18h', field: '18', width: 95,resizable:true,  editable: false ,filter: true, cellRenderer:'checkboxRenderer'},
  ];
  this.frameworkComponents = {
    
    checkboxRenderer: CheckboxRenderer,
  };
};  

 onGridReady(params) {
  this.gridApi = params.api;
 }
  ngOnInit(): void {
   this.getListNiveau();
  } 
  showSuccess() {
    this.messageService.add({severity:'success', summary: 'Sauvegarde avec succé', detail:'Classe Sauvegarder'});
  }

showError() {
  this.messageService.add({severity:'error', summary: 'Error ', detail:'failed'});
}
    valider(listresult){
       let dataBaseObject =[];
       // this.ajouterPresence(this.listresult)
       for (let object of this.listresult ){
        let keys:any[] = Object.keys(object);  
        let hours:any[] = keys.filter(key => 
          { let keyN:any = +key;
           return keyN >0;});
        let newList:any[]=[];
        hours.forEach(hour => 
          {let newObj:RegistreDTO= new RegistreDTO();
           newObj.nomEtat = object[hour].etat;
           newObj.datePresenceTimeStamp = object[hour].datePresenceTimeStamp;
           newObj.nomEleve = object.nomEleve;
           newObj.idEleve = object[hour].idEleve;
           newList.push(newObj);
          //  dataBaseObject = dataBaseObject.concat(newObj)
          }

        )
      //   nomEl = object.nomEleve ;  
      // //  let rd =  this.listresult.keys(nomEl)
      //   nomEleve = object.nomEleve ; 
         dataBaseObject = dataBaseObject.concat(newList)
         console.log(dataBaseObject)
      //  dataBaseObject[nomEl]=newList;
       }
       this.httpClient.post<any>('http://localhost:8080/madrasati/sauvegarderPresence',dataBaseObject)
       .subscribe (d =>{
         this.showSuccess();
          },
          err => {
            this.showError();
        }
          );
          
    }
    getAllRows() {
      let rowData = [];
      this.gridApi.forEachNode(node => rowData.push(node.data));
      return rowData;
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


  @ViewChild('agGridComponent', {static: true}) agGridComponent : AgGridAngular
 // datePresenceString : string = "2020-10-19T08:00Z"
 getListregistre(): void {

  if(this.dateSelectionner){
    localStorage.setItem("dateSelectionner",this.dateSelectionner)
  }
let list : any [];
let hour : any = []; 
let etat : any = [];
let nouveauObjet : any={} ;

  this.getRegistre ( ).subscribe(result => {
    console.log(result);

    let list : RowData[]=[] ;
    let map = Object.keys(result);  
    map.forEach (nom => {
      let rd = { nomEleve: nom  }
     for ( let object of result[nom] ) {
      hour = object.datePresence.hour ;
     
         etat = object.nomEtat ;
         let houObjct = { "etat":etat ,"datePresenceTimeStamp":object.datePresenceTimeStamp ,"idEleve" : object.idEleve }
         rd[hour]= houObjct;
        //  this.datePresence = object.datePresence ;
    }
  // this.date.push(hour , month )
    list.push(rd);

    })
this.listresult = list;
console.log(this.listresult);


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
  return this.httpClient.get<Niveau[]>('http://localhost:8080/madrasati/getListNiveau?idNiveau= 1,2,3',{headers:httpHeader,withCredentials:true},);


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
  ajouterPresence(dataBaseObject : any ): Observable<any> {
    
    return this.httpClient.post<any>('http://localhost:8080/madrasati/sauvegarderPresence', dataBaseObject)
  }



}
