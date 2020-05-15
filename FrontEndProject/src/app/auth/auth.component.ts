import { Component, OnInit } from '@angular/core';
import { AuthService } from '../service/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css']
})
export class AuthComponent implements OnInit {
     authStatuts : Boolean ;

  constructor(private authService : AuthService , private router : Router) { }

  ngOnInit() {
    this.authStatuts = this.authService.isAuth ;
  }
  seConnecter(){
    this.authService.singIn()
     this.router.navigate(['appareilview'])
      this.authStatuts = this.authService.isAuth ;
  }
    
  
}
 
