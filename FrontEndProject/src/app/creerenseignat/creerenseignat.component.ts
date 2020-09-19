import { Component, OnInit, ViewChild, Inject } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Classe } from '../model/classe';
import { Utilisateur } from '../model/utilisateur';
import { MatTableDataSource, MatPaginator, MatSort, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-creerenseignat',
  templateUrl: './creerenseignat.component.html',
  styleUrls: ['./creerenseignat.component.css']
})
export class CreerenseignatComponent implements OnInit {

  public listEnseignantdata : MatTableDataSource<Utilisateur>
  public  profileFormGroup :FormGroup ;
  fb: any;
  
  constructor(private httpClient : HttpClient ,public dialogRef: MatDialogRef<CreerenseignatComponent>, @Inject(MAT_DIALOG_DATA)public data: any) {
  
  }
  ngOnInit(): void {
    this.profileFormGroup = new FormGroup({
      nom: new FormControl(this.data.enseignant.nom,Validators.maxLength(15)),
      prenom: new FormControl(this.data.enseignant.prenom  , Validators.max(15)),
      numTel: new FormControl(this.data.enseignant.numTel , [Validators.max(8) ]),
      email: new FormControl(this.data.enseignant.email , Validators.email),
      adresse: new FormControl(this.data.enseignant.adresse , Validators.maxLength(10)),
      login: new FormControl(this.data.enseignant.login , Validators.maxLength(8)),
      motDepasse: new FormControl(this.data.enseignant.motDepasse  , Validators.maxLength(8)),
      identifiant: new FormControl(this.data.enseignant.identifiant ,Validators.max(200)),
      // dateNaissance: new FormControl(this.data.enseignant.dateNaissanceString ),




    });
    // this.profileFormGroup = this.fb.group({
    //   nom: [this.data.enseignant.nom,Validators.maxLength(5), Validators.required],
    //   prenom: [this.data.enseignant.prenom , Validators.max(8) , Validators.required],
    //   numTel: [this.data.enseignant.numTel, Validators.max(8) ,Validators.required],
    //   email: [this.data.enseignant.email , Validators.email , Validators.required],
    //   login: [this.data.matiere.coefficeint , Validators.max(8)],
    //   motDepasse: [this.data.enseignant.motDepasse , Validators.max(8) , Validators.required],
    //   dateNaissance: [this.data.enseignant.dateNaissance  , Validators.max(8) , Validators.required],
    //   adresse: [this.data.enseignant.adresse , Validators.max(8) , Validators.required],
    //   cin: [this.data.enseignant.cin , Validators.max(8) , Validators.required],

      
    // });
  
  }
 
  onNoClick(): void {
    this.dialogRef.close()
  }

 

  dialogClose(){
    this.dialogRef.close({enseignant:this.data.enseignant,validation:"sauvegarder"});
    console.log(this.data);
  }

}
