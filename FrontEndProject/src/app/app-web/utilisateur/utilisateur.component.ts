import { Component, OnInit } from '@angular/core';
import { CenderCellRendererComponent } from '../../cender-cell-renderer/cender-cell-renderer.component';
@Component({
  selector: 'app-utilisateur',
  templateUrl: './utilisateur.component.html',
  styleUrls: ['./utilisateur.component.css']
})
export class UtilisateurComponent {
    nom : String = 'nom' ;
    prenom : String = 'prenom' ;
    age : String = 'age'; 
    specificite : any ;
    cellEditorParams  : any ;
    nomEns : Array<String> = ['arwa' , 'chaima'] ;
public nomUtilisateur: Array<String> = ['ahmed', 'amal', 'asma'];
public ageUtilisateur: Array<String> = ['22', '25', '26'];
public columnDefs : any ;
 public  rowData : any ; 
  public defaultColDef : any ;
  public frameworkComponents : any ; 
  onkeyup(newTitle ) { 
    //this.specificite.enseignant = newTitle ;
    console.log(newTitle)
  }
  private gridApi;
  private gridColumnApi;


  onGridReady(params) {
    this.gridApi = params.api;
    this.gridColumnApi = params.columnApi;
  }
  onLogoClicked() {

    alert ('Hello word ') ;
  }
   addens(nomEnseignant : String)  {
     //console.log(nomEnseignant) ;
     this.nomEns.push(nomEnseignant);
  }
  constructor() { 
    
    this.specificite = { 
      enseignant :'salah'  ,
      matier : ' angular ' ,
  }
  this.columnDefs = [
    {
      field: 'gender',
      cellRenderer: 'GenderCellRenderer' ,
      cellEditorParams: {
        cellRenderer: 'genderCellRenderer',
       }
      }
  ];
  
  this.rowData = [
    {
      gender: 'Male'
    }];

        this.defaultColDef = {
      flex: 1,
      minWidth: 130,
      editable: true,
      resizable: true,
    };

  this.frameworkComponents = { genderCellRenderer : CenderCellRendererComponent }
}
}