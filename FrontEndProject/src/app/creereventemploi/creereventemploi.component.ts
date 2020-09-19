import { Component, OnInit, Inject, ViewChild } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA, MatDialog } from '@angular/material';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import dayGridPlugin from '@fullcalendar/daygrid';
import timeGridPlugin from '@fullcalendar/timegrid';
import interactionPlugin from '@fullcalendar/interaction';
import { EventMadrasati } from '../model/Event';
import { Observable } from 'rxjs';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { PopupData } from '../model/popupData';
@Component({
  selector: 'app-creereventemploi',
  templateUrl: './creereventemploi.component.html',
  styleUrls: ['./creereventemploi.component.css']
})
export class CreereventemploiComponent implements OnInit {
 public  profileFormGroup : FormGroup ;
  public dialogRefAlert: MatDialogRef<any>;
  options: any;
    public classeSelectionner: number;
    public eventList: any[];

  @ViewChild('alertDialog', {static: true})  dialogsuppression ;

  constructor(private httpClient : HttpClient ,public dialog: MatDialog , public dialogRef: MatDialogRef<CreereventemploiComponent>,public dialoggRef: MatDialogRef<CreereventemploiComponent> , @Inject(MAT_DIALOG_DATA)public data: any ) { 



  }

  ngOnInit() {
    // this.options =
    // {
    //   plugins: [dayGridPlugin, timeGridPlugin, interactionPlugin],
    //   defaultDate: '2017-02-01',
    //   header: {
    //     left: 'prev,next',
    //     center: 'title',
    //     right: 'dayGridMonth,timeGridWeek,timeGridDay'
    //   },
    //   dateClick: ($dateObject) => {this.supprimerEvent($dateObject)},
    //   eventClick: ($eventObject) => {this.supprimerEvent($eventObject)},
    //   editable: true,
    //   durationEditable:true
     
    // }
    this.profileFormGroup = new FormGroup({
      title: new FormControl(this.data.popupData.title,Validators.maxLength(20)),
      start: new FormControl(this.data.popupData.start),
      end:new FormControl(this.data.popupData.end)
    });
  }
 

  onNoClick(): void {
    this.dialogRef.close()
  } 

    

  dialogClose(){
    let event = new PopupData();
    event.title = this.profileFormGroup.value.title;
    event.start = this.profileFormGroup.value.start;
    event.end = this.profileFormGroup.value.end;
    event.id = this.profileFormGroup.value.id;

    this.dialogRef.close({event: event ,validation:"sauvegarder" });
    
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
