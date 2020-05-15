export class AuthService {

isAuth = false ;

constructor(){

}
singIn(){
   
  this.isAuth = false;
}
singOut (){
    
    this.isAuth = true;
              
}
}