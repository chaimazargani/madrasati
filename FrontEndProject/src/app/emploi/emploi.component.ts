import { Component, OnInit, ViewChild, Input, Output } from '@angular/core';
import dayGridPlugin from '@fullcalendar/daygrid';
import timeGridPlugin from '@fullcalendar/timegrid';
import interactionPlugin from '@fullcalendar/interaction';
import { EventService } from './eventservice';
import { Data } from '@angular/router';
import { FullCalendar } from 'primeng/fullcalendar';
import { MatDialogRef, MatDialog } from '@angular/material';
import { CreereventemploiComponent } from '../creereventemploi/creereventemploi.component';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Classe } from '../model/classe';
import { EventEmitter } from 'protractor';
import { EventMadrasati } from '../model/Event';
@Component({
  selector: 'app-emploi',
  templateUrl: './emploi.component.html',
  styleUrls: ['./emploi.component.css']
})
export class EmploiComponent implements OnInit {
  selectedValues: string[] = ['val1', 'val2'];
  public classeSelectionner: number;
  public classeList: Classe[];
  public eventList: any[];
  public examen: Event[] = [];

  data: any[];
  event: Event[] = [];
  public dialogRefCreerevent: MatDialogRef<CreereventemploiComponent>;
  public dialogRefAlert: MatDialogRef<any>;
  @ViewChild('daySchedule', { static: true }) fc: FullCalendar;

  options: any;

  constructor(public dialog: MatDialog, private httpClient: HttpClient,) { }
  ngOnInit() {
    this.getListclasse();

    //this.eventService.getEvents().then(events => {this.events = events;});
    this.data = [
      {
        id: 1,
        title: "All Day Event",
        start: "2017-02-01"
      },
      {
        id: 2,
        title: "Long Event",
        start: "2017-02-07",
        end: "2017-02-10"
      },
      {
        id: 3,
        title: "Repeating Event",
        start: "2017-02-09T16:00:00"
      },
      {
        id: 4,
        title: "Repeating Event",
        start: "2017-02-16T16:00:00"
      },
      {
        id: 5,
        title: "Conference",
        start: "2017-02-11",
        end: "2017-02-13"
      },
      {
        id: 6,
        title: "Meeting",
        start: "2017-02-12T10:30:00",
        end: "2017-02-12T12:30:00"
      },
      {
        id: 7,
        title: "Lunch",
        start: "2017-02-12T12:00:00"
      },
      {
        id: 8,
        title: "Meeting",
        start: "2017-02-12T14:30:00"
      },
      {
        id: 9,
        title: "Happy Hour",
        start: "2017-02-12T17:30:00"
      },
      {
        id: 10,
        title: "Dinner",
        start: "2017-02-12T20:00:00"
      },
      {
        id: 11,
        title: "Birthday Party",
        start: "2017-02-13T07:00:00"
      },
      {
        id: 12,
        title: "Click for Google",
        url: "http://google.com/",
        start: "2017-02-28"
      }
    ]

    this.options =
    {
      plugins: [dayGridPlugin, timeGridPlugin, interactionPlugin],
      defaultDate: '2017-02-01',
      header: {
        left: 'prev,next',
        center: 'title',
        right: 'dayGridMonth,timeGridWeek,timeGridDay'
      },
      dateClick: ($dateObject) => {this.dateClick($dateObject,null)},
      eventClick: ($eventObject) => {this.dateClick(null,$eventObject)},
      editable: true,
      durationEditable:true
      // eventClick: (e) => {
      //   console.log(e)
      //   this.dialogRefCreerevent = this.dialog.open(CreereventemploiComponent, {
      //     width: '400px',
      //     height: '100%',
      //     data: { event: event }
      //   });
      //   this.dialogRefCreerevent.afterClosed()
      //     .subscribe(result => {
      //       if (result.validation == "sauvegarder") {
      //         console.log('Creation en cours ...');

      //         this.httpClient.post<Event>('http://localhost:8080/madrasati/creerUtilisateur', result.e)
      //           .subscribe(d => {



      //           });
      //       }

      //     });


      // },
      //  eventClick: (e) =>  {
      //          console.log(e)
      //  },


    }

  }

  dateClick(dateObject,eventObject)  {
     let popupData : any ; 
     if (dateObject) {
      popupData.start = dateObject.event.start ;
     }
    else(eventObject)=>{
      popupData.start = eventObject.event.start ; 
      popupData.title = eventObject.event.title ;
      popupData.end = eventObject.event.end ;


    }

     this.dialogRefCreerevent = this.dialog.open(CreereventemploiComponent, {
       width: '400px',
       height:'100%',
       data: {popupData : popupData}
    });
    this.dialogRefCreerevent.afterClosed() 
    .subscribe(result => {
       if (result.validation == "sauvegarder"){
       console.log('Creation en cours ...');

         this.httpClient.post<Event>('http://localhost:8080/madrasati/creerUtilisateur', result.event )
         .subscribe (d =>{



           });
     }

        });


  }
  getClasse(): Observable<Classe[]> {

    let httpHeader: HttpHeaders = new HttpHeaders();
    httpHeader = httpHeader.set('Content-Type', 'application/json; charset=utf-8');
    return this.httpClient.get<Classe[]>('http://localhost:8080/madrasati/getClasse', { headers: httpHeader });
  }
  getListclasse(): void {
    this.getClasse().subscribe(result => {
      this.classeList = result;
    });
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
      // this.eventList.forEach(e => {
      //   e.click = ($data) => this.dateClick($data)
      // });
      this.eventList = this.eventList.concat(this.data);
      console.log(this.fc._options);
      console.log(this.fc.options);
    })
  }
}

