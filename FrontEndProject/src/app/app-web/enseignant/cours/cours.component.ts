import { Component, OnInit, ViewChild } from '@angular/core';
import { HttpParams, HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { subtractDurations } from '@fullcalendar/core/datelib/duration';
import { CoursService } from './cours.service';
import { MatTableDataSource, MatTable } from '@angular/material';
// import { FileUploader } from '../../../configurations/minio-integration.service';
import { FileObject } from '../../../model/FileObject';

declare module 'file-saver';
import * as saveAs from 'file-saver';

@Component({
  selector: 'app-cours',
  templateUrl: './cours.component.html',
  styleUrls: ['./cours.component.css']
})


export class CoursComponent implements OnInit {
  
public element : any[] = [{cours : "abc", niveauClasse : "a" , nombreEleve : 22}, ];
displayedColumns: string[] = ['cours','telechargement'];
public listnomCours : any = [] ; 
public listNomFichierDataSource : MatTableDataSource<FileObject> ;
public listNomFichier : FileObject [] = [];
@ViewChild('fichierTable', {static:true}) fichierTable: MatTable<any>;
public filesToUploadList:[]=[];

public selectedScreen = "Documents & Cours";

  constructor(public httpClient : HttpClient  ) {
    // let file = new Blob(['hello world'], { type: 'text/csv;charset=utf-8' });
    // saveAs.saveAs(file, 'helloworld.csv')

   }




  ngOnInit() {
    this.listNameFichier();
      }

  getFiles( ): Observable<any> {
    // let params: HttpParams = new HttpParams();
    // params = params.append( 'files' ,  this.files);
     return this.httpClient.get<any> ('http://localhost:8080/madrasati/getNomCours',  );
    }


putFiles(files: File[]) : void  {
  files.forEach((element :File) => {
    let formData = new FormData();
    formData.append('file', element);
 // Append file to formdata
   this.httpClient.post<any[]>('http://localhost:8080/madrasati/putcours', formData).subscribe(() => {
    this.listNameFichier();
    this.filesToUploadList =[];
    });
     
});
}
 


listNameFichier(){

  this.getFiles().subscribe((listStringNomComplet:string[]) => {
    this.listNomFichier = [];
    for(let stringNomComplet of listStringNomComplet){
let fichier :FileObject = new FileObject()  ;
   let nomFichierSplit = stringNomComplet.split("/").pop();
   
   if(nomFichierSplit){
   fichier.nomFichier = nomFichierSplit ;
   fichier.nomFichierComp = stringNomComplet;
   fichier.typeFichier = nomFichierSplit.split(".").pop();
   this.listNomFichier.push(fichier)
   }
  }
  this.listNomFichierDataSource = new MatTableDataSource<FileObject>(this.listNomFichier);
  if(this.listNomFichier){
    this.fichierTable.renderRows();
  }  
});

} 



ObjectFile(nomFichier : any ): Observable<any>{
 let params : HttpParams = new HttpParams();
 params = params.append("nomFichier" , nomFichier);
//  params = params.append("url",downloads.showDefaultFolder())
  return this.httpClient.get<any> ('http://localhost:8080/madrasati/getObjectCours', 
  { params:params, responseType: 'arraybuffer' as 'json', observe: 'response' });
}


getObjectFile(nomFichier){
this.ObjectFile(nomFichier ).subscribe(result => {
  // FileSaver saveAs(Blob/File/Url, optional DOMString filename, optional Object { autoBom })
  let blob = new 
     Blob([result.body]);
    saveAs.saveAs(blob, nomFichier);

  // saveAs.saveAs(file, 'helloworld.csv')

}); 
}
}


