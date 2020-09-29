import { Injectable } from '@angular/core';
import { RegistreComponent } from './RegistreComponent';
import { RowData } from '../model/rowData';



@Injectable()
export class RegistreService {
    public modifiedElements : RowData[] = [];
    constructor() {
    }



////getClasseService(idNiveau :number) {
//this.registrecomponent.getClasseByNiveau(idNiveau) ;
//}
}