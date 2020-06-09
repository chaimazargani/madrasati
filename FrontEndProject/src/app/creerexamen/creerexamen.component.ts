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
public cars : any 
cols: any[];
dataSource :  any[];
displayedColumns: string[] = ['position', 'name', 'weight', 'symbol'];

  constructor(private httpClient : HttpClient) {
  this.examen = new Examen();

   }

  ngOnInit() {
    this.cols = [
      { field: 'vin', header: 'Vin' },
      {field: 'year', header: 'Year' },
      { field: 'brand', header: 'Brand' },
      { field: 'color', header: 'Color' }
  ];
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
  this.getListExamen().subscribe(result=> {
    console.log(result) ; 
  })
}
}
