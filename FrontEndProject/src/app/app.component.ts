import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  public login:string;
  public motdepasse:string;

  onClick():void {
      console.log(this.login);
      console.log(this.motdepasse);
  }
}
