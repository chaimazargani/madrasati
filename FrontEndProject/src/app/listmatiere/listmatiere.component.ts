import { Component, OnInit, ViewChild, ViewEncapsulation } from '@angular/core';
import { Matier } from '../model/matier';
import { MatPaginator, MatTableDataSource, MatSort, MatDialog, MatDialogRef } from '@angular/material';
import { SelectionModel } from '@angular/cdk/collections';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CreermatierComponent } from '../creermatier/creermatier.component';
import { MessageService } from 'primeng/api';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-listmatiere',
  templateUrl: './listmatiere.component.html',
  styleUrls: ['./listmatiere.component.css'],
  encapsulation:ViewEncapsulation.None,
  providers: [MessageService]
})
export class ListmatiereComponent implements OnInit {
  public listmatieredata : MatTableDataSource<Matier>
  public matiere : Matier[] = [];
  displayedColumns: string[] = ['nomMatier' , 'coefficeint' , 'supprimer' ,'modifier'];
 public matier : Matier ;
 @ViewChild('alertDialog', {static: true})  dialogsuppression ;
@ViewChild(MatPaginator, {static: true}) paginator: MatPaginator; // For pagination

 @ViewChild(MatSort, {static: true}) sort: MatSort; // For pagination
 public selectedScreen = "Configuration Matières";

 selection = new SelectionModel<Matier>(true, []);
 public dialogRefCreermatiere: MatDialogRef<CreermatierComponent> ;
 public dialogRefAlert: MatDialogRef<any>;
//  nomMatier = new FormControl('');
public heroForm : any ;
 

  constructor(private httpClient : HttpClient , public dialog: MatDialog , private messageService : MessageService) { }
  



  ngOnInit() {
    this.afficherListDesMatieres();
  }

  getListMatiere(): Observable<Matier[]> {
  
    let httpHeader:HttpHeaders = new HttpHeaders();
    httpHeader = httpHeader.set('Content-Type', 'application/json; charset=utf-8');
      return this.httpClient.get<Matier[]>('/getMatiere',{headers:httpHeader});
    }
    afficherListDesMatieres() : void {
      this.getListMatiere().subscribe(listdesmatieres=> {
         this.matiere = listdesmatieres
         this.listmatieredata = new MatTableDataSource(this.matiere);
    });
    }
    showSuccess() {
      this.messageService.add({severity:'success', summary: 'Sauvegarde avec succé', detail:'Matiére Sauvegarder'});
    }
showSuccessSuppression() {
  this.messageService.add({severity:'success', summary: 'Suppression avec succé', detail:'Matiére Supprimé'});
}
showSuccessModification() {
this.messageService.add({severity:'success', summary: 'Modification avec succé', detail:'Matiére Modifié'});
}
  showError() {
    this.messageService.add({severity:'error', summary: 'Error ', detail:'failed'});
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
    
          this.httpClient.post<Matier>('/ajouterMatiere', result.matiere )
          .subscribe (d =>{
                  console.log(d);
                  this.showSuccess(); 
              this.afficherListDesMatieres();
    
             },
             err => {
              this.showError();
          }
             );
             
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
    
          this.httpClient.post<Matier>('/modifierMatiere', result.matiere )
          .subscribe (d =>{
                  console.log(d);
                  this.showSuccessModification(); 
         this.afficherListDesMatieres();        
             },
             err => {
              this.showError();
          }
             );
            
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
    
          this.httpClient.post<Matier>('/supprimerMatiers', matiere )
          .subscribe (d =>{
                  console.log(d);
                  this.showSuccessSuppression(); 
         this.afficherListDesMatieres();  
    
             },
             err => {
              this.showError();
          }
             );
           
        }
       
          });
    }
    dialogClose(){
      this.dialogRefAlert.close("supprimer");
    }
}
