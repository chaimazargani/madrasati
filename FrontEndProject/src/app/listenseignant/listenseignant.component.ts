import { Component, OnInit, ViewChild } from '@angular/core';
import { Utilisateur } from '../model/utilisateur';
import { MatTableDataSource, MatPaginator, MatSort, MatDialog, MatDialogRef } from '@angular/material';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CreerenseignatComponent } from '../creerenseignat/creerenseignat.component';

@Component({
  selector: 'app-listenseignant',
  templateUrl: './listenseignant.component.html',
  styleUrls: ['./listenseignant.component.css']
})
export class ListenseignantComponent implements OnInit {
  public enseignant : Utilisateur[] = [];
  public listEnseignantdata : MatTableDataSource<Utilisateur>
  displayedColumns: string[] = ['nom', 'prenom', 'cin' ,'numTel' ,'email', 'dateNaissance' , 'adresse', 'login' ,'motDepasse', 'supprimer' ,'modifier'];
  private utilisateur: Utilisateur;
  private listeDesutilisateur: Utilisateur[];
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  @ViewChild('alertDialog') daialogSuppression ; ;

  public dialogRefCreerEnseignant: MatDialogRef<CreerenseignatComponent> ;
  public dialogRefAlert: MatDialogRef<any>;
  constructor(private httpClient: HttpClient , public dialog: MatDialog) {
     this.utilisateur = new Utilisateur();
    this.listeDesutilisateur = []; }

  ngOnInit() {
    this.afficherListeutilisateur();
  }
  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.listEnseignantdata.filter = filterValue.trim().toLowerCase();
  }
  afficherListeutilisateur(): void {
    // tslint:disable-next-line:no-debugger
      this.afficherListe().subscribe(listdesenseignant => {
        // subsribe ili bch t7el l karthouna observable
        this.enseignant = listdesenseignant
        this.listEnseignantdata = new MatTableDataSource(this.enseignant);
  
        console.log(this.enseignant);
      });
    }
      afficherListe(): Observable<Utilisateur[]> {
    console.log(this.listeDesutilisateur);
  let httpHeader:HttpHeaders = new HttpHeaders();

  httpHeader = httpHeader.set('Content-Type', 'application/json; charset=utf-8');
    return this.httpClient.get<Utilisateur[]>('http://localhost:8080/madrasati/listUtilisateur',{headers:httpHeader});
  }
  supprimerEnseignant(enseignant) {
    this.dialogRefAlert = this.dialog.open(this.daialogSuppression, {
      width: '250px',
      height:'100%',
   });
   this.dialogRefAlert.afterClosed()
    .subscribe(result => {
      if (result == "supprimer"){
        console.log('Suppression en cours ...');
  
        this.httpClient.post<Utilisateur>('http://localhost:8080/madrasati/supprimerUtiisateur', enseignant )
        .subscribe (d =>{
                console.log(d);
            this.afficherListeutilisateur();
  
           });
      }
     
        });
  }
  
  ajouterEnseignant() {
    this.dialogRefCreerEnseignant = this.dialog.open(CreerenseignatComponent, {
      width: '400px',
      height:'100%',
      data: {enseignant:new Utilisateur()}
   });
   this.dialogRefCreerEnseignant.afterClosed()
    .subscribe(result => {
      if (result.validation == "sauvegarder"){
        console.log('Creation en cours ...');
  
        this.httpClient.post<Utilisateur>('http://localhost:8080/madrasati/creerUtilisateur', result.enseignant )
        .subscribe (d =>{
                console.log(d);
            this.afficherListeutilisateur();
  
           });
      }
     
        });
  }
  // dialoggClose(){
  //   this.dialoggRefAlert.close("modifier");
  // }
  
  
  dialogClose(){
    this.dialogRefAlert.close("supprimer");
  }
  
  modifierEnseignant(enseignant) {
    this.dialogRefCreerEnseignant = this.dialog.open(CreerenseignatComponent, {
      width: '400px',
      height:'100%',
      data: {enseignant:enseignant},
  
   });
   this.dialogRefCreerEnseignant.afterClosed()
    .subscribe(result => {
      if (result.validation == "sauvegarder"){
        console.log('Modification en cours ... ');
  
        this.httpClient.post<Utilisateur>('http://localhost:8080/madrasati/modifierUtlisateur', result.enseignant )
        .subscribe (d =>{
                console.log(d);
            this.afficherListeutilisateur();
  
           });
      }
     
        });
  }
}
