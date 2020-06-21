import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Classe } from '../model/classe';
import { Utilisateur } from '../model/utilisateur';

@Component({
  selector: 'app-creerenseignat',
  templateUrl: './creerenseignat.component.html',
  styleUrls: ['./creerenseignat.component.css']
})
export class CreerenseignatComponent implements OnInit {
  private utilisateur: Utilisateur;
  private listeDesutilisateur: Utilisateur[];

  constructor(private httpClient: HttpClient) {
    this.utilisateur = new Utilisateur();
    this.listeDesutilisateur = [];
  }
  ngOnInit() {}

   enregistrer(): void {
  // tslint:disable-next-line:no-debugger
    this.creerEnseignant().subscribe(result => {
      console.log(result);
    });
   }
    //  karthouna li feha les infrs
creerEnseignant(): Observable<Utilisateur> {
  // tslint:disable-next-line:no-debugger
  return this.httpClient.post<Utilisateur>('http://localhost:8080/madrasati/creerUtilisateur', this.utilisateur);
}
afficherListeutilisateur(): void {
  // tslint:disable-next-line:no-debugger
    this.afficherListe().subscribe(result => {
      // subsribe ili bch t7el l karthouna observable
      console.log(result);
    });
  }
    afficherListe(): Observable<Utilisateur[]> {
  console.log(this.listeDesutilisateur);
let httpHeader:HttpHeaders = new HttpHeaders();
httpHeader = httpHeader.set('Content-Type', 'application/json; charset=utf-8');
  return this.httpClient.get<Utilisateur[]>('http://localhost:8080/madrasati/listUtilisateur',{headers:httpHeader});
}

supprimerEnseignant(): Observable<Utilisateur> {
  return this.httpClient.post<Utilisateur>('http://localhost:8080/madrasati/supprimerUtilisateur', this.utilisateur );
 }
 supprimerUnenseignant() : void {
 this.supprimerEnseignant().subscribe(result=>{
   console.log(result);
 })
 
 }
 modifierEnseignant(): Observable<Utilisateur> {
  return this.httpClient.post<Utilisateur>('http://localhost:8080/madrasati/modifierUtlisateur', this.utilisateur );
 }
 modifierUnExamen() : void {
  this.modifierEnseignant().subscribe(result=>{
    console.log(result);
  })
  
  }
}
