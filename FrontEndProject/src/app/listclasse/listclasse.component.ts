import { Component, OnInit , ViewChild, ViewEncapsulation } from '@angular/core';
import { Classe } from '../model/classe';
import { Observable } from 'rxjs/Observable';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { MatSort, MatPaginator, MatTableDataSource, MatDialog, MatDialogContent, MatDialogRef } from '@angular/material';
import { PeriodicElement } from '../model/PeriodicElement';
import { SelectionModel } from '@angular/cdk/collections';
import { CreerclasseComponent } from '../creerclasse/creerclasse.component';
import { MessageService } from 'primeng/api';

@Component({
  selector: 'app-listclasse',
  templateUrl: './listclasse.component.html',
  styleUrls: ['./listclasse.component.css'],
  encapsulation:ViewEncapsulation.None,
  providers: [MessageService]
})
export class ListclasseComponent implements OnInit {
  public listClassedata : MatTableDataSource<Classe> ;
  public classe : Classe[] = [];
  public data : any

  public selectedScreen = "Configuration Classe";

  displayedColumns = ['nomClasse', 'niveauClasse', 'nombreEleve' , 'supprimer' ,'modifier'];
  selection = new SelectionModel<Classe>(true, []);
    @ViewChild(MatPaginator,{static:true}) paginator: MatPaginator;
    //@ViewChild(MatPaginator, {static: false}) paginator: MatPaginator; // For pagination
    @ViewChild(MatSort, {static: true}) sort: MatSort; // For pagination

    //@ViewChild(MatSort) sort: MatSort;

    @ViewChild('alertDialog',{static:true}) chaima ;
    private listeDesclasse : Classe[] ; 
    nomClasse: string;
    nombreEleve: string;
    public dialogRefCreerClass: MatDialogRef<CreerclasseComponent> ;
     public dialogRefAlert: MatDialogRef<any>;

    constructor(private httpClient: HttpClient ,  public dialog: MatDialog , public  messageService : MessageService)  {
      //this.classe = new Classe();
      //this.listeDesclasse = [];
    
    }
  

   
    
  ngOnInit() {
    this.afficheListeDesClasses();
  }
  showSuccess() {
    this.messageService.add({severity:'success', summary: 'Sauvegarde avec succé', detail:'Classe Sauvegarder'});
  }
showSuccessSuppression() {
this.messageService.add({severity:'success', summary: 'Suppression avec succé', detail:'Classe Supprimé'});
}
showSuccessModification() {
this.messageService.add({severity:'success', summary: 'Modification avec succé', detail:'Classe Modifié'});
}
showError() {
  this.messageService.add({severity:'error', summary: 'Error ', detail:'failed'});
}

  afficherListe(): Observable<Classe[]> {
    console.log(this.listeDesclasse);
  let httpHeader:HttpHeaders = new HttpHeaders();
  httpHeader = httpHeader.set('Content-Type', 'application/json; charset=utf-8');
    return this.httpClient.get<Classe[]>('http://localhost:8080/madrasati/getClasse',{headers:httpHeader});
  }

 

 afficheListeDesClasses() : void  {

   this.afficherListe().subscribe(listdesclasse=> {
     console.log(listdesclasse); 
     this.classe = listdesclasse ;
     this.listClassedata = new MatTableDataSource(this.classe);
   });
}
// ngAfterViewInit() {
//   this.dataSource.paginator = this.paginator;
//   this.dataSource.sort = this.sort;
// }
supprimerClasse(classe) {
  this.dialogRefAlert = this.dialog.open(this.chaima, {
    width: '250px',

 });
 this.dialogRefAlert.afterClosed()
  .subscribe(result => {
    if (result == "supprimer"){
      console.log('Suppression en cours ...');

      this.httpClient.post<Classe>('http://localhost:8080/madrasati/supprimerClasse', classe )
      .subscribe (d =>{
              
              this.showSuccessSuppression();
          this.afficheListeDesClasses();

         },
         err => {
          this.showError();
      }
         );
        
    }
   
      });
}

creerClasse() {
  this.dialogRefCreerClass = this.dialog.open(CreerclasseComponent, {
    width: '400px',
    data: {classe:new Classe()}
 });
 this.dialogRefCreerClass.afterClosed()
  .subscribe(result => {
    if (result.validation == "sauvegarder"){
      console.log('Creation en cours ...');

      this.httpClient.post<Classe>('http://localhost:8080/madrasati/creerclasse', result.classe )
      .subscribe (d =>{
              console.log(d);
              this. showSuccess();
          this.afficheListeDesClasses();

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

modifierClasse(classe) {
  this.dialogRefCreerClass = this.dialog.open(CreerclasseComponent, {
    width: '400px',
    data: {classe:classe},

 });
 this.dialogRefCreerClass.afterClosed()
  .subscribe(result => {
    if (result.validation == "sauvegarder"){
      console.log('Modification en cours ... ');

      this.httpClient.post<Classe>('http://localhost:8080/madrasati/creerclasse', result.classe )
      .subscribe (d =>{
              console.log(d);
              this.showSuccessModification();
          this.afficheListeDesClasses();

         },
         err => {
          this.showError();
      }
         );
       
    }
   
      });
}

}
