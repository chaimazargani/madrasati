import { Component, OnInit , ViewChild, Inject } from '@angular/core';
import { Classe } from '../model/classe';
import { Observable } from 'rxjs/Observable';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { MatSort, MatPaginator, MatTableDataSource, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { PeriodicElement } from '../model/PeriodicElement';
import { SelectionModel } from '@angular/cdk/collections';
import { ListclasseComponent } from '../listclasse/listclasse.component';
import { FormGroup, FormControl, Validators } from '@angular/forms';






@Component({

  selector: 'app-creerclasse',
  templateUrl: './creerclasse.component.html',
  styleUrls: ['./creerclasse.component.css']
})

export class CreerclasseComponent implements OnInit {
public listClassedata : MatTableDataSource<Classe> ;
 public profileFormGroup : FormGroup
 constructor(private httpClient : HttpClient , public dialogRef: MatDialogRef<CreerclasseComponent>, @Inject(MAT_DIALOG_DATA) public data: any)
  {
  }

  ngOnInit() {
    this.profileFormGroup = new FormGroup({
      nomClasse: new FormControl(this.data.classe.nomClasse,Validators.maxLength(10)),
      idNiveau: new FormControl(this.data.classe.idNiveau , Validators.min(3)),
      nombreEleve: new FormControl(this.data.classe.nombreEleve , Validators.min(3)),

    });

  } 
 

  onNoClick(): void {
    this.dialogRef.close()
  }

 

  dialogClose(){
    this.dialogRef.close({classe:this.data.classe,validation:"sauvegarder"});
    
  }


                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
}
