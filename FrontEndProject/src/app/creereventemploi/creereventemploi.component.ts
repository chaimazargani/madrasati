import { Component, OnInit, Inject, ViewChild } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA, MatDialog } from '@angular/material';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import dayGridPlugin from '@fullcalendar/daygrid';
import timeGridPlugin from '@fullcalendar/timegrid';
import interactionPlugin from '@fullcalendar/interaction';
import { EventMadrasati } from '../model/Event';
import { Observable } from 'rxjs';
@Component({
  selector: 'app-creereventemploi',
  templateUrl: './creereventemploi.component.html',
  styleUrls: ['./creereventemploi.component.css']
})
export class CreereventemploiComponent implements OnInit {
  public dialogRefAlert: MatDialogRef<any>;
  options: any;
    public classeSelectionner: number;
    public eventList: any[];

  @ViewChild('alertDialog', {static: true})  dialogsuppression ;

  constructor(private httpClient : HttpClient ,public dialog: MatDialog , public dialogRef: MatDialogRef<CreereventemploiComponent>,public dialoggRef: MatDialogRef<CreereventemploiComponent> , @Inject(MAT_DIALOG_DATA)public data: any) { 



  }

  ngOnInit() {


    this.options =
    {
      plugins: [dayGridPlugin, timeGridPlugin, interactionPlugin],
      defaultDate: '2017-02-01',
      header: {
        left: 'prev,next',
        center: 'title',
        right: 'dayGridMonth,timeGridWeek,timeGridDay'
      },
      dateClick: ($dateObject) => {this.supprimerEvent($dateObject)},
      eventClick: ($eventObject) => {this.supprimerEvent($eventObject)},
      editable: true,
      durationEditable:true
     
    }

  }
 

  onNoClick(): void {
    this.dialogRef.close()
  } 

    

  dialogClose(){
    this.dialogRef.close({event: this.data.popupData ,validation:"sauvegarder" });
    
  }
  


  supprimerEvent(data) {
    this.dialogRefAlert = this.dialog.open(this.dialogsuppression, {
      width: '250px',
  
   });
   this.dialogRefAlert.afterClosed()
    .subscribe(result => {
      if (result == "supprimer"){
        console.log('Suppression en cours ...');
  
        this.httpClient.post<any>('http://localhost:8080/madrasati/supprimerEvent', data.event )
        .subscribe (d =>{
                console.log(d);
                
  
           });
      }
     
        });
  }


  dialoggClose(){
    this.dialogRefAlert.close("supprimer");
  }

  
  getEventByClasse(): Observable<EventMadrasati[]> {
    let httpHeader: HttpHeaders = new HttpHeaders();
    let params: HttpParams = new HttpParams();
    params = params.append('idClasse', this.classeSelectionner.toString());

    httpHeader = httpHeader.set('Content-Type', 'application/json; charset=utf-8');
    return this.httpClient.get<any[]>('http://localhost:8080/madrasati/getEventByClasse', { headers: httpHeader, params: params });
  }

  getListEvent(): void {
    this.getEventByClasse().subscribe(result => {
      this.eventList = result;
    
      console.log(this.eventList);
      this.eventList = this.eventList.concat(this.data);
      
    })
  }
}
