import { Component, OnInit } from '@angular/core';
import { Enseignant } from '../model/enseignant';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-creerenseignat',
  templateUrl: './creerenseignat.component.html',
  styleUrls: ['./creerenseignat.component.css']
})
export class CreerenseignatComponent implements OnInit {
  private enseignant:Enseignant;

  constructor(private httpClient: HttpClient) {
    this.enseignant = new Enseignant();
  }
  ngOnInit() {}

   enregistrer():void {
  // tslint:disable-next-line:no-debugger
  debugger;
    this.creerEnseignant().subscribe(result => {
      console.log(result);
    });
   }

creerEnseignant(): Observable<void> {
  // tslint:disable-next-line:no-debugger
  debugger;
  return this.httpClient.get<any> ('http://localhost:8080/madrasati/utilisateur');
}
}
