import { Component, OnInit, ViewChild, ViewEncapsulation } from '@angular/core';
import { MatTableDataSource, MatPaginator, MatSort, MatDialogRef, MatDialog } from '@angular/material';
import { Examen } from '../model/examen';
import { SelectionModel } from '@angular/cdk/collections';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CreerexamenComponent } from '../creerexamen/creerexamen.component';
import { MessageService } from 'primeng/api';

@Component({
  selector: 'app-listexamen',
  templateUrl: './listexamen.component.html',
  styleUrls: ['./listexamen.component.css'],
  encapsulation:ViewEncapsulation.None,
  providers: [MessageService]
})
export class ListexamenComponent implements OnInit {
  public listExamendata : MatTableDataSource<Examen>
  public examen : Examen[] = [];
  displayedColumns: string[] = ['nomExamen' , 'coefficeint' , 'modifier' ,'supprimer'];
 public examens : Examen ;
@ViewChild(MatPaginator, {static: true}) paginator: MatPaginator; // For pagination
@ViewChild('alertDialog', {static: true})  dialogsuppression ;
 @ViewChild(MatSort, {static: true}) sort: MatSort; // For pagination
 selection = new SelectionModel<Examen>(true, []);
 public dialogRefCreerClass: MatDialogRef<CreerexamenComponent> ;
 public dialogRefAlert: MatDialogRef<any>;

 public selectedScreen = "Configuration Examens";

  constructor(private httpClient : HttpClient , public dialog: MatDialog , private  messageService : MessageService)  { 
    this.examens = new Examen();
  }

  ngOnInit() {
    this.afficherListDesExamen();

  }
  isAllSelected() {
    const numSelected = this.selection.selected.length;
    const numRows = this.listExamendata.data.length;
    return numSelected === numRows;
  }
  
  masterToggle() {
    this.isAllSelected() ?
        this.selection.clear() :
        this.listExamendata.data.forEach(row => this.selection.select(row));
  }
  checkboxLabel(row?: Examen): string {
    if (!row) {
      return `${this.isAllSelected() ? 'select' : 'deselect'} all`;
    }
    return `${this.selection.isSelected(row) ? 'deselect' : 'select'} row ${row.nomExamen + 1}`;
  }

  getListExamen(): Observable<Examen[]> {
  
    let httpHeader:HttpHeaders = new HttpHeaders();
    httpHeader = httpHeader.set('Content-Type', 'application/json; charset=utf-8');
      return this.httpClient.get<Examen[]>('http://localhost:8080/madrasati/getExamen',{headers:httpHeader});
    }

    afficherListDesExamen() : void {
      this.getListExamen().subscribe(
                        listdesexamens => {
                                  this.examen = listdesexamens 
                                  this.listExamendata = new MatTableDataSource(this.examen);
                              //  this.showSuccess(); 
                              },
                        err => {
                          this.showError();
                      });
    }


    showSuccess() {
      this.messageService.add({severity:'success', summary: 'Sauvegarde avec succé', detail:'Examen Sauvegardé'});
  }
  showSuccessSuppression() {
    this.messageService.add({severity:'success', summary: 'Suppression avec succé', detail:'Examen Supprimé'});
}
showSuccessModification() {
  this.messageService.add({severity:'success', summary: 'Modification avec succé', detail:'Examen Modifié'});
}
  showError() {
    this.messageService.add({severity:'error', summary: 'Error', detail:'failed'});
}
        ajouterExamen(){
          this.dialogRefCreerClass = this.dialog.open(CreerexamenComponent, {
            width: '400px',
            data: {examen :new Examen()}
         });
         this.dialogRefCreerClass.afterClosed()
          .subscribe(result => {
            if (result.validation == "sauvegarder"){
              console.log('Creation en cours ...');
        
              this.httpClient.post<Examen>('http://localhost:8080/madrasati/ajouterExamen', result.examen )
              .subscribe (
                dataAfterSave =>{
                      this.showSuccess(); 
                      this.afficherListDesExamen();
                },
                 err => {
                  this.showError();
              }
             );

            }
           
              });
        }

        modifierExamen(examen) {
          this.dialogRefCreerClass = this.dialog.open(CreerexamenComponent, {
            width: '400px',
            data: {examen:examen},
        
         });
         this.dialogRefCreerClass.afterClosed()
          .subscribe(result => {
            if (result.validation == "sauvegarder"){
              console.log('Modification en cours ... ');
        
              this.httpClient.post<Examen>('http://localhost:8080/madrasati/modifierExamen', result.examen )
              .subscribe (d =>{
                      console.log(d);
                      this.showSuccessModification(); 
                      this.afficherListDesExamen();        
                 },
                 err => {
                  this.showError();
              }
                 
                 );
                
            }
           
              });
        }
        supprimerExamen(examen) {
          this.dialogRefAlert = this.dialog.open(this.dialogsuppression, {
            width: '250px',
        
         });
         this.dialogRefAlert.afterClosed()
          .subscribe(result => {
            if (result == "supprimer"){
              console.log('Suppression en cours ...');
        
              this.httpClient.post<Examen>('http://localhost:8080/madrasati/supprimerExamen', examen )
              .subscribe (d =>{
                      console.log(d);
                      this.showSuccessSuppression(); 
                      this.afficherListDesExamen();  
        
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
