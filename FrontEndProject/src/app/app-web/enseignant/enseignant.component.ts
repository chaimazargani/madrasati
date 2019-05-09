import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-enseignant',
  templateUrl: './enseignant.component.html',
  styleUrls: ['./enseignant.component.css']
})
export class EnseignantComponent implements OnInit {
 
  constructor(private router: Router) { 

  }
  redirection() {
    this.router.navigate(['/note']);
   }




  ngOnInit() {}
  
  
}
