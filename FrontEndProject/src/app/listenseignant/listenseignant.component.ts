import { Component, OnInit, ViewChild, ViewEncapsulation } from '@angular/core';
import { Utilisateur } from '../model/utilisateur';
import { MatTableDataSource, MatPaginator, MatSort, MatDialog, MatDialogRef } from '@angular/material';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CreerenseignatComponent } from '../creerenseignat/creerenseignat.component';
import { MessageService } from 'primeng/api';

@Component({
  selector: 'app-listenseignant',
  templateUrl: './listenseignant.component.html',
  styleUrls: ['./listenseignant.component.css'],
  encapsulation:ViewEncapsulation.None,
  providers: [MessageService]
})
export class ListenseignantComponent implements OnInit {
  public Listenseignant : Utilisateur[] = [] ;
  public listEnseignantdata : MatTableDataSource<Utilisateur>
  displayedColumns: string[] = ['nom', 'prenom', 'cin' ,'numTel' ,'email', 'dateNaissance' , 'adresse', 'login' ,'motDepasse', 'supprimer' ,'modifier'];
  private utilisateur: Utilisateur;
  private listeDesutilisateur: Utilisateur[];
  public listdesnewdate : any[] = [];
  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator; // For pagination
  @ViewChild(MatSort, {static: true}) sort: MatSort; // For pagination

  @ViewChild('alertDialog',{static: true}) daialogSuppression ; ;


  public selectedScreen = "Configuration Utilisateurs";

  public dialogRefCreerEnseignant: MatDialogRef<CreerenseignatComponent> ;
  public dialogRefAlert: MatDialogRef<any>;
  constructor(private httpClient: HttpClient , public dialog: MatDialog ,private messageService : MessageService) {
     this.utilisateur = new Utilisateur();
    this.listeDesutilisateur = []; }

  ngOnInit() {
    this.afficherListeutilisateur();
  }


  showSuccess() {
    this.messageService.add({severity:'success', summary: 'Sauvegarde avec succé', detail:'Utilisateur Sauvegarder'});
  }
showSuccessSuppression() {
this.messageService.add({severity:'success', summary: 'Suppression avec succé', detail:'Utilisateur Supprimé'});
}
showSuccessModification() {
this.messageService.add({severity:'success', summary: 'Modification avec succé', detail:'Utilisateur Modifié'});
}
showError() {
  this.messageService.add({severity:'error', summary: 'Error ', detail:'failed'});
}
  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.listEnseignantdata.filter = filterValue.trim().toLowerCase();
  }
  afficherListeutilisateur(): void {
    // tslint:disable-next-line:no-debugger
      this.afficherListe().subscribe(result => {
        // subsribe ili bch t7el l karthouna observable
        this.Listenseignant = result;

        for(let enseignant of this.Listenseignant){
          let list : any[]  = [];
        let newdate = new Date(enseignant.dateNaissance ) ; 
      let mois = newdate.getMonth();
      let annee = newdate.getFullYear();
      let jour = newdate.getDate();
      let datefinalString:string =  mois+"/"+jour+"/"+annee ;
      // list.push(datefinalString)
      // this.listdesnewdate = this.listdesnewdate.concat(list)
      enseignant.dateNaissanceString =datefinalString;
       
      }
      this.listEnseignantdata = new MatTableDataSource(this.Listenseignant);
        console.log(this.Listenseignant);
      
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
                this.showSuccessSuppression()
            this.afficherListeutilisateur();
  
           },
           err => {
            this.showError();
        }
           );
       
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
                this.showSuccess();
            this.afficherListeutilisateur();
  
           },
           err => {
            this.showError();
        }
           );
          
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
                this.showSuccessModification()
            this.afficherListeutilisateur();
  
           },
           err => {
            this.showError();
        }
           );
          
      }
     
        });
  }
}
