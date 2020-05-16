import { Component, OnInit} from '@angular/core';
import {   RegistreDTO } from '../model/RegistreDTO';
import { Registre } from '../model/Registre';
import { Observable } from 'rxjs';
import { HttpClient , HttpHeaders } from '@angular/common/http';



@Component({
  selector: 'app-registre',
  templateUrl: './registre.component.html',
  styleUrls: ['./registre.component.css']
})
export class RegistreComponent   {
  
  registreDTO : RegistreDTO ;
  listRegistredto :RegistreDTO [] ;
  columnDefs: any ;
  rowData: any ;

  constructor(private httpClient: HttpClient){
    this.listRegistredto = [] ;

    
    

   this. columnDefs = [
    {
      headerName: "list des eleves",
      marryChildren: true,
      children: [
        { headerName: 'Nom et prenom', field: "name", minWidth: 300},
      ]
    },
    {
      headerName: "Date par semaine : lundi ",
      children: [
        { headerName: 'lundi', field: "jour", minWidth: 20, maxWidth: 250},

        { headerName: '8h -9h', columnGroupShow: 'open', field: "datePresence", minWidth: 320, maxWidth: 550},
        { headerName: '9h-10h', columnGroupShow: 'open', field: "datePresence", minWidth: 120, maxWidth: 250},
        { headerName: '10h-11h', columnGroupShow: 'open', field: "datePresence", minWidth: 120, maxWidth: 250},
        { headerName: '11h-12', columnGroupShow: 'open', field: "datePresence", minWidth: 120, maxWidth: 250},
        { headerName: '12h-13', columnGroupShow: 'open', field: "datePresence", minWidth: 120, maxWidth: 250},
        { headerName: '13h-14h', columnGroupShow: 'open', field: "datePresence", minWidth: 120, maxWidth: 250},
        { headerName: '14h-15h', columnGroupShow: 'open', field: "datePresence", minWidth: 120, maxWidth: 250},
        { headerName: '15h-16h', columnGroupShow: 'open', field: "datePresence", minWidth: 120, maxWidth: 250},
        { headerName: '16h-17h', columnGroupShow: 'open', field: "datePresence", minWidth: 120, maxWidth: 250},
        { headerName: '17h-18h', columnGroupShow: 'open', field: "datePresence", minWidth: 120, maxWidth: 250},


      ]
    },
    {
        headerName: "Date par semaine : mardi ",
        children: [
          { headerName: 'mardi', field: "jour", minWidth: 20, maxWidth: 250},
          
          { headerName: '8h -9h', columnGroupShow: 'open', field: "distributorName", minWidth: 120, maxWidth: 250},
          { headerName: '9h-10h', columnGroupShow: 'open', field: "distributorName1", minWidth: 120, maxWidth: 250},
          { headerName: '10h-11h', columnGroupShow: 'open', field: "distributorName2", minWidth: 120, maxWidth: 250},
          { headerName: '11h-12', columnGroupShow: 'open', field: "distributorName3", minWidth: 120, maxWidth: 250},
          { headerName: '12h-13', columnGroupShow: 'open', field: "distributorName4", minWidth: 120, maxWidth: 250},
          { headerName: '13h-14h', columnGroupShow: 'open', field: "distributorName5", minWidth: 120, maxWidth: 250},
          { headerName: '14h-15h', columnGroupShow: 'open', field: "distributorName5", minWidth: 120, maxWidth: 250},
          { headerName: '15h-16h', columnGroupShow: 'open', field: "distributorName5", minWidth: 120, maxWidth: 250},
          { headerName: '16h-17h', columnGroupShow: 'open', field: "distributorName5", minWidth: 120, maxWidth: 250},
          { headerName: '17h-18h', columnGroupShow: 'open', field: "distributorName5", minWidth: 120, maxWidth: 250},
  
  
        ]
      },
      {
        headerName: "Date par semaine :mercredi ",
        children: [
          { headerName: 'mercredi', field: "jour", minWidth: 20, maxWidth: 250},
          
          { headerName: '8h -9h', columnGroupShow: 'open', field: "distributorName", minWidth: 120, maxWidth: 250},
          { headerName: '9h-10h', columnGroupShow: 'open', field: "distributorName1", minWidth: 120, maxWidth: 250},
          { headerName: '10h-11h', columnGroupShow: 'open', field: "distributorName2", minWidth: 120, maxWidth: 250},
          { headerName: '11h-12', columnGroupShow: 'open', field: "distributorName3", minWidth: 120, maxWidth: 250},
          { headerName: '12h-13', columnGroupShow: 'open', field: "distributorName4", minWidth: 120, maxWidth: 250},
          { headerName: '13h-14h', columnGroupShow: 'open', field: "distributorName5", minWidth: 120, maxWidth: 250},
          { headerName: '14h-15h', columnGroupShow: 'open', field: "distributorName5", minWidth: 120, maxWidth: 250},
          { headerName: '15h-16h', columnGroupShow: 'open', field: "distributorName5", minWidth: 120, maxWidth: 250},
          { headerName: '16h-17h', columnGroupShow: 'open', field: "distributorName5", minWidth: 120, maxWidth: 250},
          { headerName: '17h-18h', columnGroupShow: 'open', field: "distributorName5", minWidth: 120, maxWidth: 250},
  
  
        ]
      },
      {
        headerName: "Date par semaine :Jeudi ",
        children: [
          { headerName: 'Jeudi', field: "jour", minWidth: 20, maxWidth: 250},
          
          { headerName: '8h -9h', columnGroupShow: 'open', field: "distributorName", minWidth: 120, maxWidth: 250},
          { headerName: '9h-10h', columnGroupShow: 'open', field: "distributorName1", minWidth: 120, maxWidth: 250},
          { headerName: '10h-11h', columnGroupShow: 'open', field: "distributorName2", minWidth: 120, maxWidth: 250},
          { headerName: '11h-12', columnGroupShow: 'open', field: "distributorName3", minWidth: 120, maxWidth: 250},
          { headerName: '12h-13', columnGroupShow: 'open', field: "distributorName4", minWidth: 120, maxWidth: 250},
          { headerName: '13h-14h', columnGroupShow: 'open', field: "distributorName5", minWidth: 120, maxWidth: 250},
          { headerName: '14h-15h', columnGroupShow: 'open', field: "distributorName5", minWidth: 120, maxWidth: 250},
          { headerName: '15h-16h', columnGroupShow: 'open', field: "distributorName5", minWidth: 120, maxWidth: 250},
          { headerName: '16h-17h', columnGroupShow: 'open', field: "distributorName5", minWidth: 120, maxWidth: 250},
          { headerName: '17h-18h', columnGroupShow: 'open', field: "distributorName5", minWidth: 120, maxWidth: 250},
  
  
        ]
      },
      {
        headerName: "Date par semaine :Vendredi ",
        children: [
          { headerName: 'Vendredi', field: "jour", minWidth: 20, maxWidth: 250},
          
          { headerName: '8h -9h', columnGroupShow: 'open', field: "distributorName", minWidth: 120, maxWidth: 250},
          { headerName: '9h-10h', columnGroupShow: 'open', field: "distributorName1", minWidth: 120, maxWidth: 250},
          { headerName: '10h-11h', columnGroupShow: 'open', field: "distributorName2", minWidth: 120, maxWidth: 250},
          { headerName: '11h-12', columnGroupShow: 'open', field: "distributorName3", minWidth: 120, maxWidth: 250},
          { headerName: '12h-13', columnGroupShow: 'open', field: "distributorName4", minWidth: 120, maxWidth: 250},
          { headerName: '13h-14h', columnGroupShow: 'open', field: "distributorName5", minWidth: 120, maxWidth: 250},
          { headerName: '14h-15h', columnGroupShow: 'open', field: "distributorName5", minWidth: 120, maxWidth: 250},
          { headerName: '15h-16h', columnGroupShow: 'open', field: "distributorName5", minWidth: 120, maxWidth: 250},
          { headerName: '16h-17h', columnGroupShow: 'open', field: "distributorName5", minWidth: 120, maxWidth: 250},
          { headerName: '17h-18h', columnGroupShow: 'open', field: "distributorName5", minWidth: 120, maxWidth: 250},
  
  
        ]
      },
      {
        headerName: "Date par semaine : Samedi ",
        children: [
          { headerName: 'Samedi', field: "jour", minWidth: 20, maxWidth: 250},
          
          { headerName: '8h -9h', columnGroupShow: 'open', field: "distributorName", minWidth: 120, maxWidth: 250},
          { headerName: '9h-10h', columnGroupShow: 'open', field: "distributorName1", minWidth: 120, maxWidth: 250},
          { headerName: '10h-11h', columnGroupShow: 'open', field: "distributorName2", minWidth: 120, maxWidth: 250},
          { headerName: '11h-12', columnGroupShow: 'open', field: "distributorName3", minWidth: 120, maxWidth: 250},
          { headerName: '12h-13', columnGroupShow: 'open', field: "distributorName40", minWidth: 120, maxWidth: 250},
          
        ]
      },
];

// specify the data
this.rowData = [
    {
      name: 'ahmed bcc', 
      datePresence: 'A'  ,  
      },
      {
        name: 'chaima zargani', 
        datePresence: 'P'  ,  },
        {
            name: 'asma bcc', 
            datePresence: 'P'  ,  },
            {
                name: 'amal  bcc', 
                datePresence: 'P'  ,  },
];
  
}
 
//this.rowData = this.httpClient.get<RegistreDTO[]>('http://localhost:8080/madrasati/getPresenceByIdEleve',{headers:httpHeader});


getListRegistre (): void {
  this.getRegistre().subscribe(result => {
    // subsribe ili bch t7el l karthouna observable
    console.log(1);
  });
}
getRegistre(): Observable<RegistreDTO[]>  {
 console.log (this.listRegistredto);
 let httpHeader:HttpHeaders = new HttpHeaders();
 httpHeader = httpHeader.set('Content-Type', 'application/json; charset=utf-8');

 return this.httpClient.get<RegistreDTO[]>('http://localhost:8080/madrasati/getPresenceByIdEleve',{headers:httpHeader});
}
}

