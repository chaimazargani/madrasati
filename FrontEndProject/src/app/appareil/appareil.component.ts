import { Component, OnInit, Input } from '@angular/core';
import { AppareilService } from '../service/appareil.service';

@Component({
  selector: 'app-appareil',
  templateUrl: './appareil.component.html',
  styleUrls: ['./appareil.component.css']
})
export class AppareilComponent implements OnInit {

  @Input() appareilStatus : String ;
   @Input() appareilsName  : String  ;
   @Input() indxApp : number  ;
 

  constructor( private appareilService : AppareilService) { }

  ngOnInit() {
  }
  getStatus() {
    return this.appareilStatus ;
  }
 ngModel(){

}
onkeyup(){

}
getColor(){

   if (this.appareilStatus === 'eteint') {
   return 'red';
   }

   else if (this.appareilStatus === 'allumer') {
    return 'green' ; 

  }
}
  onSwitchOn(){
  this.appareilService.switchOnOne(this.indxApp) ;
 }
 ofSwitchOf(){
 this.appareilService.switchOffOne(this.indxApp);
}
}
