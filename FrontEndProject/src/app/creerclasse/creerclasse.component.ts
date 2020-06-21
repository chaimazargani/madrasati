import { Component, OnInit , ViewChild } from '@angular/core';
import { Classe } from '../model/classe';
import { Observable } from 'rxjs/Observable';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { MatSort, MatPaginator, MatTableDataSource } from '@angular/material';
import { PeriodicElement } from '../model/PeriodicElement';
import { SelectionModel } from '@angular/cdk/collections';






@Component({

  selector: 'app-creerclasse',
  templateUrl: './creerclasse.component.html',
  styleUrls: ['./creerclasse.component.css']
})

export class CreerclasseComponent implements OnInit {
  public rd : any ;
 public dataSource : any ; 
 public niveau : any = [];  
 public eleve : any = [];

  // ELEMENT_DATA: PeriodicElement[] = [
  //   { nomClasse: '7 eme b1', niveauClasse: 'niveau 1', nombreEleve: 25 },
  //   { nomClasse: '8 eme b1', niveauClasse: 'niveau 2', nombreEleve: 26},
  //   { nomClasse: '9 eme b1', niveauClasse: 'niveau 3', nombreEleve: 27 },
  //   { nomClasse: '7 eme b1', niveauClasse: 'niveau 1', nombreEleve: 25 },
  //   { nomClasse: '8 eme b1', niveauClasse: 'niveau 2', nombreEleve: 26},
  //   { nomClasse: '9 eme b1', niveauClasse: 'niveau 3', nombreEleve: 27 },
  //   { nomClasse: '7 eme b1', niveauClasse: 'niveau 1', nombreEleve: 25 },
  //   { nomClasse: '8 eme b1', niveauClasse: 'niveau 2', nombreEleve: 26},
  //   { nomClasse: '9 eme b1', niveauClasse: 'niveau 3', nombreEleve: 27 },
   

  // ];

  displayedColumns = ['nomClasse', 'niveauClasse', 'nombreEleve'];



  selection = new SelectionModel<PeriodicElement>(true, []);
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  private classe: Classe;
  private listeDesclasse : Classe[] ; 
  public    listresult = []; 
  public    listresultNiveau = []; 
  public    listresultEleve = []; 

  constructor(private httpClient: HttpClient) {
    this.classe = new Classe();
    this.listeDesclasse = [];
   
  }
 
  applyFilter(filterValue: string) {
    filterValue = filterValue.trim(); // Remove whitespace
    filterValue = filterValue.toLowerCase(); // MatTableDataSource defaults to lowercase matches
    this.dataSource.filter = filterValue;
  }
  isAllSelected() {
    const numSelected = this.selection.selected.length;
    const numRows = this.dataSource.data.length;
    return numSelected === numRows;
  }

  /** Selects all rows if they are not all selected; otherwise clear selection. */
  masterToggle() {
    this.isAllSelected() ?
        this.selection.clear() :
        this.dataSource.data.forEach(row => this.selection.select(row));
  }
  ngOnInit() {

  }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
  

  sauvegarder(): void { 
    this.Creerclasse().subscribe(result => {
      console.log(result);
    });
  }

  Creerclasse(): Observable<Classe> {
  
    return this.httpClient.post<Classe>('http://localhost:8080/madrasati/creerclasse', this.classe,);
  }


  afficherListe(): Observable<Classe[]> {
    console.log(this.listeDesclasse);
  let httpHeader:HttpHeaders = new HttpHeaders();
  httpHeader = httpHeader.set('Content-Type', 'application/json; charset=utf-8');
    return this.httpClient.get<Classe[]>('http://localhost:8080/madrasati/getClasse',{headers:httpHeader});
  }

 

 afficheListeDesClasses() : void  {

   this.afficherListe().subscribe(result=> {
     console.log(result); 
    let list : any[]=[] ;
    let listNiveau : any[]=[] ;
    let listEleve : any[]=[] ;

    let map = Object.keys(result);  
    map.forEach (nom => {
    this.rd = { nomClasse: nom  }
    
     for ( let object of result[nom] ) {
      
      this.niveau = object.idNiveau ;
      this.eleve = object.nombreEleve ;
      this.rd[this.eleve ] = this.rd[this.niveau ] 
    }
    list.push(this.rd);
    listEleve.push(this.eleve)
    listNiveau.push(this.niveau)
    //this.dataSource = new MatTableDataSource<Classe>(this.niveau);

   })
this.listresult = list;
this.listresultNiveau = listEleve ;
this.listresultEleve = listNiveau ;
this.dataSource = new MatTableDataSource<Classe>( this.listresult);
//this.dataSource = new MatTableDataSource<PeriodicElement>( this.listresultNiveau );

 console.log(this.listresult);

   });
}
// ngAfterViewInit() {
//   this.dataSource.paginator = this.paginator;
//   this.dataSource.sort = this.sort;
// }
supprimerClasse(): Observable<Classe> {
  return this.httpClient.post<Classe>('http://localhost:8080/madrasati/supprimerClasse', this.classe );
 }
 supprimerUnClasse() : void {
 this.supprimerClasse().subscribe(result=>{
   console.log(result);
 })
 
 }
 modifierClasse(): Observable<Classe> {
  return this.httpClient.post<Classe>('http://localhost:8080/madrasati/modifierClasse', this.classe );
 }
 modifierUnExamen() : void {
  this.modifierClasse().subscribe(result=>{
    console.log(result);
  })
  
  }
}
