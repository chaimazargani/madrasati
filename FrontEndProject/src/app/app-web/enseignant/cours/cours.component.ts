import { Component, OnInit } from '@angular/core';
import { HttpParams, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { subtractDurations } from '@fullcalendar/core/datelib/duration';
import { CoursService } from './cours.service';
import { PeriodicElement } from 'src/app/model/PeriodicElement';
import { MatTableDataSource } from '@angular/material';
// import { FileUploader } from '../../../configurations/minio-integration.service';

@Component({
  selector: 'app-cours',
  templateUrl: './cours.component.html',
  styleUrls: ['./cours.component.css']
})


export class CoursComponent implements OnInit {
public element : any[] = [{cours : "abc", niveauClasse : "a" , nombreEleve : 22}, ];
displayedColumns: string[] = ['cours' , 'telechargement' ];
public listnomCours : any = [] ; 
public listNomFichier : any = [];
public nomFichier : any ; 
  constructor(public httpClient : HttpClient  ) {


   }




  ngOnInit() {
  }

  getFiles( ): Observable<any> {
    // let params: HttpParams = new HttpParams();
    // params = params.append( 'files' ,  this.files);
     return this.httpClient.get<any> ('http://localhost:8080/madrasati/getNomCours',  );
    }


putFiles(files: any) : void  {
  let file: File = files[0];

  let formData = new FormData();
  formData.append('file', file); // Append file to formdata
  
  // const req = this.http.post('/abc', formData);
  this.httpClient.post<any>('http://localhost:8080/madrasati/putcours', formData).subscribe(() => console.log("came back"));
    // this.fileUploader.putCour(event)
}
 


listCour(){
this.getFiles().subscribe(result => {
  this.listNomFichier = result
  
  //  this.listnomCours = new MatTableDataSource(this.nomFiles);
  
  console.log(this.listnomCours);
});
}



ObjectFile(nomFichier : any ): Observable<any>{
 let params : HttpParams = new HttpParams();
 params = params.append("nomFichier" , nomFichier);
  return this.httpClient.get<any> ('http://localhost:8080/madrasati/getObjectCours', {params : params} );

}


getObjectFile(nomFichier){
this.ObjectFile(nomFichier).subscribe(result => {

}); 
}
}


