import { Component, OnInit, ViewChild } from '@angular/core';
import { RegistreDTO } from '../model/RegistreDTO';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AgGridAngular } from 'ag-grid-angular';
import { RowData } from '../model/rowData';
import { ColomnDef } from '../model/ColomnDef';
import { Children } from '../model/Children';
@Component({
  selector: 'app-registre',
  templateUrl: './registre.component.html',
  styleUrls: ['./registre.component.css']
})
export class RegistreComponent implements OnInit {
  registreDTO: RegistreDTO;
  listRegistredto: RegistreDTO[];
 public columnDefs: ColomnDef ;
 public  columnDefs1 : ColomnDef ;
 public  rowData: any ;
 public  children : Children ;
  public columnDeflist  : ColomnDef[]= [] ;
  selected = 'option2';
  selected2 = 'option2';


  constructor(private httpClient: HttpClient) {

   
    //construction de objet children
    let children1:Children;
    children1 = {
      headerName:"Nom et Prénom",
      field:"nomEleve",
      minWidth:300,
      maxWidth:null,
      columnGroupShow:null,
      field1: null ,
      cellRenderer : null ,
      cellEditor : null,
      cellEditorParams : null ,
    } ;
    //construction et remplissage du list of children
    let childrenList: Children[] = [] ; 
    childrenList.push(children1);



    this.listRegistredto = [];
  
    this.columnDefs = {  
      headerName:"list des éleves",
      marryChildren:true,
      children : childrenList ,
      field1 : null ,
 cellRenderer :  null ,
 cellEditor : null ,
 cellEditorParams : null ,
    }

let children2 : Children ;
  children2 = {
    headerName:"8h-9h",
    field:"date1heure1",
    minWidth:300,
    maxWidth: 550,
    columnGroupShow: "open",
  
  }
 
  let children3 : Children ;
  children3 = {
    headerName:"9h-10h",
    field:"date1heure3",
    minWidth:300,
    maxWidth: 550,
    columnGroupShow: "open",
   
  }
  let children4 : Children ;
  children4 = {
    headerName:"10h-11h",
    field:"date1heure4",
    minWidth:300,
    maxWidth: 550,
    columnGroupShow: "open",
   
  }
 let children5 : Children ; 
 children5 = {
  headerName:"11h-12h",
  field:"date1heure5",
  minWidth:300,
  maxWidth: 550,
  columnGroupShow: "open",
 
}

let children6 : Children ; 
children6 = {
 headerName:"12h-13h",
 field:"date1heure6",
 minWidth:300,
 maxWidth: 550,
 columnGroupShow: "open",

}

let children7 : Children ; 
children7 = {
 headerName:"13h-14h",
 field:"date1heure7",
 minWidth:300,
 maxWidth: 550,
 columnGroupShow: "open",
 
}

let children8 : Children ; 
children8 = {
 headerName:"15h-16h",
 field:"date1heure8",
 minWidth:300,
 maxWidth: 550,
 columnGroupShow: "open",

}
let children9 : Children ; 
children9 = {
 headerName:"16h-17h",
 field:"date1heure9",
 minWidth:300,
 maxWidth: 550,
 columnGroupShow: "open",

}

let children10 : Children ; 
 children10 = {
 headerName:"17h-18h",
 field:"date1heure10",
 minWidth:300,
 maxWidth: 550,
 columnGroupShow: "open",
 }
 
 let childrenList2: Children[] = [] ;
 childrenList2.push(children2 , children3 , children4 , children5 , children6 , children7 , children8 , children9, children10);

 this.columnDefs1 = {
  headerName : "03-01-2020" ,
  marryChildren: null ,
  children : childrenList2 ,
  field1 : "date1heure1" ,
 cellRenderer :  'genderCellRenderer' ,
 cellEditor : 'agRichSelectCellEditor' ,
 cellEditorParams : null,

}
this.columnDeflist.push(this.columnDefs , this.columnDefs1 )

this.rowData = [
  { nomEleve: 'ahmed', date1heure1: 'present' , date1heure2: 'present' , date1heure3: 'absent', date1heure4: 'present' },
  { nomEleve: 'asma', date1heure1: 'absente' , date1heure2: 'absente' , date1heure3: 'presente', date1heure4: 'presente' },
 { nomEleve: 'amal', date1heure1: 'present' , date1heure2: 'exclut' , date1heure3: 'absent', date1heure4: 'presente' },
  { nomEleve: 'chaima', date1heure1: 'exclut' , date1heure2: 'present' , date1heure3: 'absent', date1heure4: 'present' },

]
}
  ngOnInit(): void {
  
    } 
  
 

 // getRegistre(): Observable<RegistreDTO[]> {
  //  let httpHeader: HttpHeaders = new HttpHeaders();
  // httpHeader = httpHeader.set('Content-Type', 'application/json; charset=utf-8');
  // return this.httpClient.get<RegistreDTO[]>('http://localhost:8080/madrasati/getPresenceByIdEleve?idClasse=2&datePresenceString=2012-02-22T02:06:58.147Z', { headers: httpHeader });

  }


 // @ViewChild('agGridComponent') agGridComponent : AgGridAngular
 // getListregistre(): void {
   //  this.getRegistre ().subscribe(result => {
    //  this.rowData = result;
    //   console.log(result);


   // });
  // }
  //getObjetaggrid(result): any {
  //console.log(result);
  //}
  //getColomnDef(result): any {

  //}
}
