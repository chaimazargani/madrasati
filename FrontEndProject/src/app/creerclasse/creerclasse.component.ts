import { Component, OnInit } from '@angular/core';
import { Classe } from '../model/classe';
import { Observable } from 'rxjs/Observable';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
@Component({

  selector: 'app-creerclasse',
  templateUrl: './creerclasse.component.html',
  styleUrls: ['./creerclasse.component.css']
})
export class CreerclasseComponent implements OnInit {
  private classe: Classe;
  private listeDesclasse : Classe[] ; 
  constructor(private httpClient: HttpClient) {
    this.classe = new Classe();
    this.listeDesclasse = [];
  }

  ngOnInit() {

  }

  sauvegarder(): void { 
    this.Creerclasse().subscribe(result => {
      console.log(result);
    });
  }

  Creerclasse(): Observable<Classe> {
  
    return this.httpClient.post<Classe>('http://localhost:8080/madrasati/creerclasse', this.classe,);
  }


  afficherListe(): Observable<Classe[]> {
    console.log(this.listeDesclasse);
  let httpHeader:HttpHeaders = new HttpHeaders();
  httpHeader = httpHeader.set('Content-Type', 'application/json; charset=utf-8');
    return this.httpClient.get<Classe[]>('http://localhost:8080/madrasati/getClasse',{headers:httpHeader});
  }
 afficheListeDesClasses() : void  {
   this.afficherListe().subscribe(result=> {
 console.log(result);

   });
}
}
