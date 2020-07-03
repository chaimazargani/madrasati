import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource, MatPaginator, MatSort, MatDialogRef, MatDialog } from '@angular/material';
import { Examen } from '../model/examen';
import { SelectionModel } from '@angular/cdk/collections';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CreerexamenComponent } from '../creerexamen/creerexamen.component';

@Component({
  selector: 'app-listexamen',
  templateUrl: './listexamen.component.html',
  styleUrls: ['./listexamen.component.css']
})
export class ListexamenComponent implements OnInit {
  public listExamendata : MatTableDataSource<Examen>
  public examen : Examen[] = [];
  displayedColumns: string[] = ['nomExamen' , 'coefficeint' , 'modifier' ,'supprimer'];
 public examens : Examen ;
 @ViewChild('alertDialog')  dialogsuppression ;
 @ViewChild(MatPaginator) paginator: MatPaginator;
 @ViewChild(MatSort) sort: MatSort;
 selection = new SelectionModel<Examen>(true, []);
 public dialogRefCreerClass: MatDialogRef<CreerexamenComponent> ;
 public dialogRefAlert: MatDialogRef<any>;
  constructor(private httpClient : HttpClient , public dialog: MatDialog) { 
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
      this.getListExamen().subscribe(listdesexamens=> {
         this.examen = listdesexamens 
         this.listExamendata = new MatTableDataSource(this.examen);
    });
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
              .subscribe (d =>{
                      console.log(d);
                  this.afficherListDesExamen();
        
                 });
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
                      this.afficherListDesExamen();        
                 });
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
                      this.afficherListDesExamen();  
        
                 });
            }
           
              });
        }
        dialogClose(){
          this.dialogRefAlert.close("supprimer");
        }
}
