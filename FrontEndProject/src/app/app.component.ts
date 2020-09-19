import { Component, Input, OnInit } from '@angular/core';
import { MenubarModule } from 'primeng/menubar';
import { MenuItem } from 'primeng/api';
import { AuthService } from './service/auth.service';
import {Location} from '@angular/common';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  public items: MenuItem[];
  constructor() {
    this.items = [
      {
        label: 'Administration',
        items: [
          { label: 'Configuration Examen', routerLink: "listexamen"},
          { separator: true },
          { label: 'Configuration Note', routerLink: "note" },
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
        label: 'NoteEleve', routerLink: "noteeleve",
      },
      {
        label: 'Cours', routerLink: "cours",
      }
    ];
  }
  ngOnInit(): void {

  }
}






