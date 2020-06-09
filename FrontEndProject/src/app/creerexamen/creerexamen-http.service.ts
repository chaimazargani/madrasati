import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Examen } from "../model/examen";
import { Observable } from "rxjs";

@Injectable()
export class ExamenHttpService{
public examen : Examen ;

constructor(private httpClient: HttpClient) {

}


}