import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-creereventemploi',
  templateUrl: './creereventemploi.component.html',
  styleUrls: ['./creereventemploi.component.css']
})
export class CreereventemploiComponent implements OnInit {

  constructor(private httpClient : HttpClient ,public dialogRef: MatDialogRef<CreereventemploiComponent>, @Inject(MAT_DIALOG_DATA)public data: any) { 



  }

  ngOnInit() {
  }

  onNoClick(): void {
    this.dialogRef.close()
  } 

    

  dialogClose(){
    this.dialogRef.close({event: this.data.event,validation:"sauvegarder"});
    
  }
}
