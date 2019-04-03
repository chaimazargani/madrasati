import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
   public login:string;
    public motdepasse:string;
  
    onClick():void {
        console.log(this.login);
        console.log(this.motdepasse);
    }

    constructor(private router: Router) { }
    redirection () {
    this.router.navigate(['/creerEnseignant']);
    }
  ngOnInit() {
  }

}
