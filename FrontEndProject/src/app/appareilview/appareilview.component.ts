import { Component, OnInit } from '@angular/core';
import { AppareilService } from '../service/appareil.service';
import { AuthService } from '../service/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-appareilview',
  templateUrl: './appareilview.component.html',
  styleUrls: ['./appareilview.component.css']
})
export class AppareilviewComponent implements OnInit {
  appareils : any[] ;
  isAuth = false ;
  myText = {name : 'bonjour'}
  myText2= 2220.0465 
  authStatuts : Boolean ;

  lastupdate = new Promise (
   (resolve , reject ) => {
     const date = new Date() ;
     setTimeout (()=>{ 
          resolve(date);
        }, 2000 );
      
      }
      

     
   
  );
   constructor(private appareilServie : AppareilService , private authService : AuthService , private router : Router ){
    
  
    setTimeout(()=>{    
      this.isAuth = true ;
 }, 5000);
  

  } 
 onAllume(){
   
   this.appareilServie.switchOnAll() ;
 }

  onkeyup(app){
   console.log(app)
  }

  ngOnInit () {
   this.appareils = this.appareilServie.appareils;
  }
  onEteindre() {
    this.appareilServie.switchOffAll() ;
  }
  

  seDeconnecter(){
    this.authService.singOut
    this.router.navigate(['auth'])
    this.authStatuts = this.authService.isAuth ;

  }


}
