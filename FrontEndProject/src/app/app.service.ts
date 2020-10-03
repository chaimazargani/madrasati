import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AppService {
  public authorities = [];
  public currentUser;
  public defaultScreen;
  constructor() { }
}
