import { Component, OnInit, ViewChild, Inject } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Classe } from '../model/classe';
import { Utilisateur } from '../model/utilisateur';
import { MatTableDataSource, MatPaginator, MatSort, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';

@Component({
  selector: 'app-creerenseignat',
  templateUrl: './creerenseignat.component.html',
  styleUrls: ['./creerenseignat.component.css']
})
export class CreerenseignatComponent implements OnInit {

  public listEnseignantdata : MatTableDataSource<Utilisateur>
  
  
  constructor(private httpClient : HttpClient ,public dialogRef: MatDialogRef<CreerenseignatComponent>, @Inject(MAT_DIALOG_DATA)public data: any) {
  
  }
  ngOnInit(): void {
  
  }
 
  onNoClick(): void {
    this.dialogRef.close()
  }

 

  dialogClose(){
    this.dialogRef.close({enseignant:this.data.enseignant,validation:"sauvegarder"});
    
  }

}
