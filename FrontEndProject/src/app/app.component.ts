import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'primeng/api';
import { HttpClient } from '@angular/common/http';
import { NgxPermissionsService } from 'ngx-permissions';
import { AppService } from './app.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  public items: MenuItem[];
  public isLoggedIn = JSON.parse(localStorage.getItem('isLoggedIn'));
  public authorityList;
  public currentUser;
  constructor(private httpClient: HttpClient, private permissionsService: NgxPermissionsService, private appService: AppService) {
  }
  ngOnInit(): void {
    let authoritiesList: string [] = JSON.parse(localStorage.getItem('authorities'));
    this.permissionsService.loadPermissions(authoritiesList);
    this.createMenuBar();
  }
  
  createMenuBar() {
    if (this.permissionsService.getPermission('administration')) {
      this.items = [
        {
          label: 'Administration',
          items: [
            { label: 'Configuration Examen', routerLink: "listexamen" },
            { separator: true },
            { label: 'Géstion les Personnels', routerLink: "listenseignant" },
            { separator: true },
            { label: 'Configuration Matiére', routerLink: "listmatiere" },
            { separator: true },

            { label: 'Configuration Classe', routerLink: "listclasse" },
            { separator: true },

            { label: 'Configuration Eléve', routerLink: "" },
          ]
        },
        {
          label: 'Registre', routerLink: "registre",
        },

        {
          label: 'Emploi du Temps', routerLink: "emploi",
        },
        {
          label: 'Note', routerLink: "note",
        },
        {
          label: 'Cours', routerLink: "cours",
        }
      ];
    } else if (this.permissionsService.getPermission('enseignant')) {
      this.items = [
        {
          label: 'Registre', routerLink: "registre",
        },
        {
          label: 'Emploi du Temps', routerLink: "emploi",
        },
        {
          label: 'Note', routerLink: "note",
        },
        {
          label: 'Cours', routerLink: "cours",
        }
      ];
    }
    else if (this.permissionsService.getPermission('eleve')) {
      this.items = [
        {
          label: 'Emploi du Temps', routerLink: "emploi",
        },
        {
          label: 'NoteEleve', routerLink: "noteeleve",
        },
        {
          label: 'Cours', routerLink: "cours",
        }
      ];
    }
  }

  logout() {
    this.httpClient.post<any>('/logout', null).subscribe(() => {
      this.isLoggedIn = false;
      localStorage.setItem('isLoggedIn', "false");
      window.location.href = 'http://localhost:4200/login';
    }

    )
  }
}






