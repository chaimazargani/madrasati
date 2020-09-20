import { Component, OnDestroy } from '@angular/core';
import { ICellRendererAngularComp } from 'ag-grid-angular';
import { IAfterGuiAttachedParams } from 'ag-grid-community';
import { RegistreDTO } from '../model/RegistreDTO';


@Component({
  selector: 'checkbox-renderer',
  template: `
    <p-checkbox 
      type="checkbox" 
      (click)="onChangeEtat($event)"
      (ngModelChange) = "onChangeEtat($event)"
      [(ngModel)]="params ? params.value ? params.value.booleanEtat : return : return"
      [binary]="true"
    ></p-checkbox>
`,
})
export class CheckboxRenderer implements ICellRendererAngularComp {

  public checked :boolean = false;
  refresh(params: any): boolean {
    return true;
      // throw new Error("Method not implemented.");
  }
  afterGuiAttached?(params?: IAfterGuiAttachedParams): void {
      // throw new Error("Method not implemented.");
  }
  private params: any;

  agInit(params: any): void {
    this.params = params;
     if(this.params.value && this.params.value.etat =='P') {
      this.params.value.booleanEtat = true ;
     }
  }

  onChangeEtat(checkbox) {
      let checked = checkbox.target.checked;
    let colId = this.params.column.colId;
    if(this.params.value){
    let hourObject = this.params.value;
      if(hourObject.etat == 'P'){
        hourObject.etat='A';
        this.params.node.setDataValue(colId, hourObject);
      } else {
        hourObject.etat='P';
        this.params.node.setDataValue(colId, hourObject);
      }
    }else {
      let newPresence:any = new Object();
      checked ? newPresence.etat = 'P' : newPresence.etat = 'A';
      let newDatePresence:Date = new Date(localStorage.getItem("dateSelectionner"));
      newDatePresence.setHours(+colId);
      newPresence.datePresenceTimeStamp = +new Date(newDatePresence);
      newPresence.idEleve = this.params.data[Object.keys(this.params.data)[0]].idEleve;
      this.params.node.setDataValue(colId, newPresence);
    }
      
  }
}
