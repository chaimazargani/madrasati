import { Component, OnInit, ViewChild, Inject } from '@angular/core';
import { ExamenService } from './creerexamen.service';
import { Observable } from 'rxjs';
import { Examen } from '../model/examen';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { MatTableDataSource, MatPaginator, MatSort, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { SelectionModel } from '@angular/cdk/collections';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-creerexamen',
  templateUrl: './creerexamen.component.html',
  styleUrls: ['./creerexamen.component.css']
})
export class CreerexamenComponent implements OnInit {
  public profileFormGroup : FormGroup ;
  constructor(private httpClient : HttpClient ,public dialogRef: MatDialogRef<CreerexamenComponent>, @Inject(MAT_DIALOG_DATA)public data: any) {
 
  }

  ngOnInit() {
    this.profileFormGroup = new FormGroup({
      nomExamen: new FormControl(this.data.examen.nomExamen,Validators.maxLength(10)),
      coefficeint: new FormControl(this.data.examen.coefficeint ,  Validators.max(4)),
    });
  }
 
  onNoClick(): void {
    this.dialogRef.close()
  }

 wildiY7ibFtourSbe7($event){
   console.log($event)
 }

  dialogClose(){
    this.dialogRef.close({examen:this.data.examen,validation:"sauvegarder"});
    
  }

}
