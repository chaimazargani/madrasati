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
import { PopupData } from '../model/popupData';
import { start } from 'repl';
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
  public popupData: any = [];
  data: any[];
  event: EventMadrasati[] = [];
  public dialogRefCreerevent: MatDialogRef<CreereventemploiComponent>;
  public dialogRefAlert: MatDialogRef<any>;
  @ViewChild('daySchedule', { static: true }) fc: FullCalendar;
  @ViewChild('alertDialog', { static: true }) dialogsuppression;

  public selectedScreen = "Emploi du Temps";
  options: any;

  constructor(private eventService: EventService, public dialog: MatDialog, private httpClient: HttpClient,) {
    this.data = [
      {
        id: 1,
        title: "anglais",
        start: "2020-09-15 08:00:00",
        end: "2020-09-15 09:00:00",

      },
      {
        id: 2,
        title: "Phisique",
        start: "2020-09-15 09:00:00",
        end: "2020-09-15 11:00:00",
      },
      {
        id: 3,
        title: "Arab",
        start: "2020-09-15 14:00:00",
        end: "2020-09-15 16:00:00",
      },
      {
        id: 4,
        title: "Géographie",
        start: "2020-09-15 16:00:00",
        end: "2020-09-15 17:00:00",
      },
      {
        id: 5,
        title: "Français",
        start: "2020-09-16 08:00:00",
        end: "2020-09-15 10:00:00",
      },
      {
        id: 6,
        title: "Science de la vie et de la terPre",
        start: "2020-09-16 10:00:00",
        end: "2020-09-16 12:00:00",
      },
      {
        id: 7,
        title: "Anglais",
        start: "2020-09-16 14:00:00",
        end: "2020-09-16 16:00:00",
      },
      {
        id: 8,
        title: "Dessin",
        start: "2020-09-16 16:00:00",
        end: "2020-09-16 17:00:00",
      },
      {
        id: 9,
        title: "Histoire",
        start: "2020-09-17 08:00:00",
        end: "2020-09-17 09:00:00",
      },
      {
        id: 10,
        title: "Sport",
        start: "2020-09-17  10:00:00",
        end: "2020-09-17  12:00:00",
      },
      {
        id: 11,
        title: "Mathématique",
        start: "2020-09-17  12:00:00",
        end: "2020-09-17  13:00:00",
      },
      {
        id: 11,
        title: "Arab",
        start: "2020-09-17  12:00:00",
        end: "2020-09-17  13:00:00",
      },
      {
        id: 12,
        title: "Education civile",
        start: "2020-09-18 08:00:00",
        end: "2020-09-18 09:00:00",
      },
      {
        id: 13,
        title: "Education islamique",
        start: "2020-09-18 09:00:00",
        end: "2020-09-18 10:00:00",
      },
      {
        id: 14,
        title: "Arab",
        start: "2020-09-18 10:00:00",
        end: "2020-09-18 12:00:00",
      },
      {
        id: 15,
        title: "Mathématique",
        start: "2020-09-18 14:00:00",
        end: "2020-09-18 16:00:00",
      },
      {
        id: 16,
        title: "Français",
        start: "2020-09-18 16:00:00",
        end: "2020-09-18 17:00:00",
      },
      {
        id: 17,
        title: "Français",
        start: "2020-09-19 08:00:00",
        end: "2020-09-17 10:00:00",
      },
      {
        id: 18,
        title: "Téathre",
        start: "2020-09-19 10:00:00",
        end: "2020-09-18 12:00:00",
      },
      {
        id: 19,
        title: "Technique",
        start: "2020-09-19 14:00:00",
        end: "2020-09-18 15:00:00",
      },
      {
        id: 20,
        title: "Informatique",
        start: "2020-09-19 15:00:00",
        end: "2020-09-17 16:00:00",
      },
      {
        id: 20,
        title: "Sport",
        start: "2020-09-19 16:00:00",
        end: "2020-09-17 17:00:00",
      },
      {
        id: 12,
        title: "Click for Google",
        url: "http://google.com/",
        start: "2020-09-15",
        color: 'yellow',   // an option!
        textColor: 'black' // an option!,
      }
    ]

    this.options =
    {
      plugins: [dayGridPlugin, timeGridPlugin, interactionPlugin],
      defaultDate: '2020-09-15',
      header: {
        left: 'prev,next',
        center: 'title',
        right: 'dayGridMonth,timeGridWeek,timeGridDay'
      },
      dateClick: ($dateObject) => { this.dateClick($dateObject, null) },
      eventClick: ($eventObject) => { this.dateClick(null, $eventObject) },
      eventDrop: eventDropInfo => {
        const { event } = eventDropInfo;
        this.eventService.modifiedElements.push(event);
      },
      editable: true,
      durationEditable: true,
      defaultView: 'timeGridWeek',
      allDaySlot: false,
      firstHour: 8
    }
  }

  //this.eventService.getEvents().then(events => {this.events = events;});



  ngOnInit() {
    this.getListclasse();
  }


  dateClick(dateObject, eventObject) {
    let popupData: any = [];
    if (dateObject) {
      this.popupData.start = new Date(dateObject.dateStr);
      let _endDate = new Date(this.popupData.start);
      this.popupData.end = new Date(_endDate.setHours(_endDate.getHours() + 1));
      this.dialogRefCreerevent = this.dialog.open(CreereventemploiComponent, {
        width: '400px',
        height: '100%',
        data: { popupData: this.popupData }
      });
      this.dialogRefCreerevent.afterClosed()
        .subscribe(result => {

          if (result.validation == "sauvegarder") {
            let event = new EventMadrasati();
            event.startString = new Date(result.event.start).toISOString().substring(0, 19);
            event.endString = new Date(result.event.end).toISOString().substring(0, 19);
            event.title = result.event.title;
            event.idclasse = this.classeSelectionner;
            event.color = '#116fbf'
            this.httpClient.post<any>('/creerEvent', event)
              .subscribe(d => {
                this.getListEvent();
              });
          }

        });
    }
    else {
      popupData.start = eventObject.event.start;
      popupData.title = eventObject.event.title;
      popupData.end = eventObject.event.end;
      popupData.id = +eventObject.event.id;
      popupData.idclasse = this.classeSelectionner;
      popupData.color = eventObject.event.backgroundColor;
      this.dialogRefCreerevent = this.dialog.open(CreereventemploiComponent, {
        width: '400px',
        height: '100%',
        data: { popupData: popupData }
      });
      this.dialogRefCreerevent.afterClosed()
        .subscribe(result => {
          if (result.validation == "sauvegarder") {
            let event = new EventMadrasati();
            event.startString = new Date(result.event.start).toISOString().substring(0, 19);
            event.endString = new Date(result.event.end).toISOString().substring(0, 19);
            event.title = result.event.title;
            event.id = +result.event.id;
            event.color = result.event.color;
            event.idclasse = this.classeSelectionner;
            this.httpClient.post<any>('/modifierEvent', event)
              .subscribe(d => {
                this.getListEvent();
              });
          } else if (result.validation == "supprimer") {
            console.log('Suppression en cours ...');
            this.httpClient.post<any>('/supprimerEvent', result.event)
              .subscribe(d => {
                this.getListEvent()
              });
          } 
        });
    }

  }
  getClasse(): Observable<Classe[]> {

    let httpHeader: HttpHeaders = new HttpHeaders();
    httpHeader = httpHeader.set('Content-Type', 'application/json; charset=utf-8');
    return this.httpClient.get<Classe[]>('/getClasseFiltre', { headers: httpHeader });
  }
  getListclasse(): void {
    this.getClasse().subscribe(result => {
      this.classeList = result;
      this.classeSelectionner = this.classeList[0].idClasse;
      this.getListEvent();
    });
  }


  getEventByClasse(): Observable<EventMadrasati[]> {
    let httpHeader: HttpHeaders = new HttpHeaders();
    let params: HttpParams = new HttpParams();
    params = params.append('idClasse', this.classeSelectionner.toString());

    httpHeader = httpHeader.set('Content-Type', 'application/json; charset=utf-8');
    return this.httpClient.get<any[]>('/getEventByClasse', { headers: httpHeader, params: params });
  }

  convertDate(dateJson) {
    // var input = JSON.parse(dateJson);

    var day = dateJson.dayOfMonth;
    var month = dateJson.monthValue - 1; // Month is 0-indexed
    var year = dateJson.year;
    var hour = dateJson.hour;
    var minute = dateJson.minute;
    var second = dateJson.second;
    return new Date(Date.UTC(year, month, day, hour, minute, second));
  }
  getListEvent(): void {
    this.getEventByClasse().subscribe(result => {
      result.map((event) => {

        event.start = this.convertDate(event.start);
        event.end = this.convertDate(event.enddate);
      })
      this.eventList = result;
      this.eventList = this.eventList.concat(this.data);
    })
  }

  dialogClose() {
    this.dialogRefAlert.close("supprimer");
  }

  sauvegarder() {
    let listFinal = [];
    this.eventService.modifiedElements.forEach((modifiedElem) => {
      let event = new EventMadrasati();
      event.id = +modifiedElem.id;
      event.title = modifiedElem.title;
      event.startString = new Date(modifiedElem.start).toISOString().substring(0, 19);
      event.endString = new Date(modifiedElem.end).toISOString().substring(0, 19);
      event.color = modifiedElem.backgroundColor;
      event.idclasse = this.classeSelectionner;
      listFinal.push(event);
    })
    this.httpClient.post<any>('/modifierEventList', listFinal)
      .subscribe(d => {
        this.eventService.modifiedElements = [];
        this.getListEvent();
      });
  }
}



