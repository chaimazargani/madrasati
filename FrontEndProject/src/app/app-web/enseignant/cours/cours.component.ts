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
import { ToastUtils } from '../../utils/toast-util';
import { MessageService } from 'primeng/api';

@Component({
  selector: 'app-cours',
  templateUrl: './cours.component.html',
  styleUrls: ['./cours.component.css'],
  providers: [MessageService]
})


export class CoursComponent implements OnInit {

  public element: any[] = [{ cours: "abc", niveauClasse: "a", nombreEleve: 22 },];
  displayedColumns: string[] = ['cours', 'telechargement'];
  public listnomCours: any = [];
  public listNomFichierDataSource: MatTableDataSource<FileObject>;
  public listNomFichier: FileObject[] = [];
  public filesToUploadList: [] = [];
public matiereSelectione : any ; 
  public selectedScreen = "Documents & Cours";
public listmatiere : string[] = ["Mathématique" , "Français"]
  constructor(public httpClient: HttpClient, public messageService: MessageService) {
    // let file = new Blob(['hello world'], { type: 'text/csv;charset=utf-8' });
    // saveAs.saveAs(file, 'helloworld.csv')

  }



  showSuccessModification() {
    this.messageService.add({ severity: 'success', summary: 'Modification avec succé', detail: 'Utilisateur Modifié' });
  }

  ngOnInit() {
    this.listNameFichier();
  }

  getFiles(): Observable<any> {
    // let params: HttpParams = new HttpParams();
    // params = params.append( 'files' ,  this.files);
    return this.httpClient.get<any>('/getNomCours',);
  }


  putFiles(files: File[]): void {
    files.forEach((element: File) => {
      let formData = new FormData();
      formData.append('file', element);
      // Append file to formdata
      this.httpClient.post<any[]>('/putcours', formData).subscribe((d) => {
        console.log(d);
        this.showSuccessModification();
        // this.toastService.showSuccess('Fichier enregistré avec succé',element.name);
        this.listNameFichier();
        this.filesToUploadList = [];
      },
        err => {
          console.error(err);
        });

    });
  }



  listNameFichier() {

    this.getFiles().subscribe((listStringNomComplet: string[]) => {
      this.listNomFichier = [];
      for (let stringNomComplet of listStringNomComplet) {
        let fichier: FileObject = new FileObject();
        let nomFichierSplit = stringNomComplet.split("/").pop();

        if (nomFichierSplit) {
          fichier.nomFichier = nomFichierSplit;
          fichier.nomFichierComp = stringNomComplet;
          let typeFichier = nomFichierSplit.split(".").pop();
          switch (typeFichier) {
            case 'pdf':
              fichier.typeFichier = 'file-pdf';
              break
            case 'docx':
              fichier.typeFichier = 'file';
              break;
            case 'jpg' || 'png' || 'gif' || 'jpeg':
              fichier.typeFichier = 'image';
              break;
            case 'xls' || 'xlsx':
              fichier.typeFichier = 'file-excel';
            default:
              break;
          }
          this.listNomFichier.push(fichier)
        }
      }
    });

  }



  ObjectFile(nomFichier: any): Observable<any> {
    let params: HttpParams = new HttpParams();
    params = params.append("nomFichier", nomFichier);
    //  params = params.append("url",downloads.showDefaultFolder())
    return this.httpClient.get<any>('/getObjectCours',
      { params: params, responseType: 'arraybuffer' as 'json', observe: 'response' });
  }


  getObjectFile(nomFichier) {
    this.ObjectFile(nomFichier).subscribe(result => {
      // FileSaver saveAs(Blob/File/Url, optional DOMString filename, optional Object { autoBom })
      let blob = new
        Blob([result.body]);
      saveAs.saveAs(blob, nomFichier);

      // saveAs.saveAs(file, 'helloworld.csv')

    });
  }
}


