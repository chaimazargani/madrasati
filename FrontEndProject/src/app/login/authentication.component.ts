import { Component, OnInit, ViewEncapsulation, ViewChild, Input, ElementRef } from '@angular/core';
import { Utilisateur } from '../model/utilisateur';
// import { Store } from '@ngrx/store';
// import { AppState, selectAuthState } from 'src/app/elif-store/auth-store/app.states';
// import * as AuthenticationActions from 'src/app/elif-store/auth-store/actions/auth.actions';
import { Subject, Observable } from 'rxjs';
import { FormGroup, FormBuilder, Validators, PatternValidator } from '@angular/forms';
// import { LogOut } from 'src/app/elif-store/auth-store/actions/auth.actions';
import { HttpClient } from '@angular/common/http';
import { Button } from 'primeng/button';
import { AppService } from '../app.service';
import { NgxPermissionsService } from 'ngx-permissions';

//https://mherman.org/blog/authentication-in-angular-with-ngrx/#configure-login-1

@Component({
  selector: 'app-authentication',
  templateUrl: './authentication.component.html',
  styleUrls: ['./authentication.component.css'],
})
//https://mherman.org/blog/authentication-in-angular-with-ngrx/#configure-login-1
export class AuthenticationComponent implements OnInit {

  public loginFormGroup: FormGroup;
  user: Utilisateur = new Utilisateur();
  errorMessage: string | null;

  private unsubscribe = new Subject<void>();

      // Auth failed
      isAuthFailed: Boolean = false;

  constructor(private httpClient:HttpClient, private formBuilder: FormBuilder,private appService:AppService,private ngxPermissionService:NgxPermissionsService) {
  }
  ngOnInit() {
    this.initFormGroup();
  }

  //From Group Init
  initFormGroup() {
    this.loginFormGroup = this.formBuilder.group({
      email: [
        { value: this.user.email, disabled: false },
        [Validators.required]
      ],
      password: [
        { value: this.user.password },
        [Validators.required]
      ]
    })
  }

  ngOnDestroy() {
    this.unsubscribe.next();
    this.unsubscribe.complete();
  }

  onSubmit(): void {
     let  username =this.loginFormGroup.value.email;
     let password = this.loginFormGroup.value.password
     this.httpClient.post<any>( '/login', `username=${username}&password=${password}`,
            { headers: { 'Content-Type': 'application/x-www-form-urlencoded' },  } ).subscribe(d => {
              localStorage.setItem('isLoggedIn', "true");
              this.getAuthorities();
  } , 
  error => {
    if ( Number( error.status ) == 401 || Number( error.status ) == 500 ) {
      this.isAuthFailed = true;
  }
  })
}
public defaultPath:string;
getAuthorities(){
  this.httpClient.get<any>('/getAuthorities').subscribe(
    (authorities) => {
      localStorage.setItem('authorities', JSON.stringify(authorities));
      this.ngxPermissionService.loadPermissions(authorities);
      if(this.ngxPermissionService.getPermission('administration'))
      this.defaultPath = 'registre';
      if(this.ngxPermissionService.getPermission('enseignant'))
      this.defaultPath = 'note';
      if(this.ngxPermissionService.getPermission('eleve'))
      this.defaultPath = 'noteeleve';
      window.location.href = 'http://localhost:4200/'+this.defaultPath;
    });
}

@ViewChild('emailInput',{static:true}) inputEmail: ElementRef;
@ViewChild('passwordInput',{static:true}) passwordInput: ElementRef;
reset(){
  this.user.email = "";
  this.user.password = "";
  this.inputEmail.nativeElement.value= "";
  this.passwordInput.nativeElement.value= "";
  this.loginFormGroup.value.email = "";
  this.loginFormGroup.value.password =  "";
}
}
