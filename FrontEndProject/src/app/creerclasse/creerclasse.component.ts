import { Component, OnInit } from '@angular/core';
import { Classe } from '../model/classe';
import { Observable } from 'rxjs/Observable';
import { HttpClient } from '@angular/common/http';
@Component({

  selector: 'app-creerclasse',
  templateUrl: './creerclasse.component.html',
  styleUrls: ['./creerclasse.component.css']
})
export class CreerclasseComponent implements OnInit {
       private classe: Classe;

  constructor(private httpClient: HttpClient) {
    this.classe = new Classe();
  }

  ngOnInit () {

  }

  sauvegarder(): void {
      this.Creerclasse().subscribe(result => {
        console.log(result);
      });
     }
  
   Creerclasse(): Observable<void> {
  return this.httpClient.get<any> ('http://localhost:18080/madrasati/classe');
}
}