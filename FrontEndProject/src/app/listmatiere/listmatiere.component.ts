import { Component, OnInit, ViewChild } from '@angular/core';
import { Matier } from '../model/matier';
import { MatPaginator, MatTableDataSource, MatSort, MatDialog, MatDialogRef } from '@angular/material';
import { SelectionModel } from '@angular/cdk/collections';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CreermatierComponent } from '../creermatier/creermatier.component';

@Component({
  selector: 'app-listmatiere',
  templateUrl: './listmatiere.component.html',
  styleUrls: ['./listmatiere.component.css']
})
export class ListmatiereComponent implements OnInit {
  public listmatieredata : MatTableDataSource<Matier>
  public matiere : Matier[] = [];
  displayedColumns: string[] = ['nomMatier' , 'coefficeint' , 'supprimer' ,'modifier'];
 public matier : Matier ;
 @ViewChild('alertDialog')  dialogsuppression ;
 @ViewChild(MatPaginator) paginator: MatPaginator;
 @ViewChild(MatSort) sort: MatSort;
 selection = new SelectionModel<Matier>(true, []);
 public dialogRefCreermatiere: MatDialogRef<CreermatierComponent> ;
 public dialogRefAlert: MatDialogRef<any>;
  constructor(private httpClient : HttpClient , public dialog: MatDialog) { }

  ngOnInit() {
    this.afficherListDesMatieres();
  }
  getListMatiere(): Observable<Matier[]> {
  
    let httpHeader:HttpHeaders = new HttpHeaders();
    httpHeader = httpHeader.set('Content-Type', 'application/json; charset=utf-8');
      return this.httpClient.get<Matier[]>('http://localhost:8080/madrasati/getMatieres',{headers:httpHeader});
    }
    afficherListDesMatieres() : void {
      this.getListMatiere().subscribe(listdesmatieres=> {
         this.matiere = listdesmatieres
         this.listmatieredata = new MatTableDataSource(this.matiere);
    });
    }

    ajouterMatiere(){
      this.dialogRefCreermatiere = this.dialog.open(CreermatierComponent, {
        width: '400px',
        data: {matiere:new Matier()}
     });
     this.dialogRefCreermatiere.afterClosed()
      .subscribe(result => {
        if (result.validation == "sauvegarder"){
          console.log('Creation en cours ...');
    
          this.httpClient.post<Matier>('http://localhost:8080/madrasati/ajouterMatiere', result.matiere )
          .subscribe (d =>{
                  console.log(d);
              this.afficherListDesMatieres();
    
             });
        }
       
          });
    }

    modifierMatiere(matiere) {
      this.dialogRefCreermatiere = this.dialog.open(CreermatierComponent, {
        width: '400px',
        data: {matiere:matiere},
    
     });
     this.dialogRefCreermatiere.afterClosed()
      .subscribe(result => {
        if (result.validation == "sauvegarder"){
          console.log('Modification en cours ... ');
    
          this.httpClient.post<Matier>('http://localhost:8080/madrasati/modifierMatiere', result.matiere )
          .subscribe (d =>{
                  console.log(d);
                  this.afficherListDesMatieres();        
             });
        }
       
          });
    }
    supprimerMatiere(matiere) {
      this.dialogRefAlert = this.dialog.open(this.dialogsuppression, {
        width: '250px',
    
     });
     this.dialogRefAlert.afterClosed()
      .subscribe(result => {
        if (result == "supprimer"){
          console.log('Suppression en cours ...');
    
          this.httpClient.post<Matier>('http://localhost:8080/madrasati/supprimerMatiers', matiere )
          .subscribe (d =>{
                  console.log(d);
                  this.afficherListDesMatieres();  
    
             });
        }
       
          });
    }
    dialogClose(){
      this.dialogRefAlert.close("supprimer");
    }
}
