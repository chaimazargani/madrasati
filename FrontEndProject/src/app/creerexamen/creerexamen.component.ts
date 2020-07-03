import { Component, OnInit, ViewChild, Inject } from '@angular/core';
import { ExamenService } from './creerexamen.service';
import { Observable } from 'rxjs';
import { Examen } from '../model/examen';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { MatTableDataSource, MatPaginator, MatSort, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { SelectionModel } from '@angular/cdk/collections';
const initialSelection = [];
const allowMultiSelect = true;
this.selection = new SelectionModel<Examen>(allowMultiSelect, initialSelection);
@Component({
  selector: 'app-creerexamen',
  templateUrl: './creerexamen.component.html',
  styleUrls: ['./creerexamen.component.css']
})
export class CreerexamenComponent implements OnInit {
 

  constructor(private httpClient : HttpClient ,public dialogRef: MatDialogRef<CreerexamenComponent>, @Inject(MAT_DIALOG_DATA)public data: any) {
 
  }

  ngOnInit() {
  }
 
  onNoClick(): void {
    this.dialogRef.close()
  }

 

  dialogClose(){
    this.dialogRef.close({examen:this.data.examen,validation:"sauvegarder"});
    
  }

}
