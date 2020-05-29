// import { Component } from '@angular/core';
// import { GenderCellRenderer } from '../../cender-cell-renderer/cender-cell-renderer.component';

// @Component({
//   selector: 'my-app',
//   template: `
//     <ag-grid-angular
//       #agGrid
//       style="width: 100%; height: 100%;"
//       id="myGrid"
//       class="ag-theme-alpine"
//       [modules]="modules"
//       [rowData]="rowData"
//       [columnDefs]="columnDefs"
//       [defaultColDef]="defaultColDef"
//       [frameworkComponents]="frameworkComponents"
//       (cellValueChanged)="onCellValueChanged($event)"
//       (gridReady)="onGridReady($event)"
//     ></ag-grid-angular>
//   `,
// })
// export class UtilisateurComponent {
//   private gridApi;
//   private gridColumnApi;

  
//   private rowData;
//   private columnDefs;
//   private defaultColDef;
//   private frameworkComponents;

//   constructor() {
//     this.rowData = [
//       {
//         name: 'Bob Harrison',
//         gender: 'Male',

//       },
//       {
//         name: 'Mary Wilson',
//         gender: 'Female',

//       },
//       {
//         name: 'Sadiq Khan',
//         gender: 'Male',
//       },
      
//     ];
//     this.columnDefs = [
//       { field: 'name' },
//       {
//         field: 'gender',
//         cellRenderer: 'genderCellRenderer',
//       },
   
//     ];
//     this.defaultColDef = {
//       flex: 1,
//       minWidth: 130,
//       editable: true,
//       resizable: true,
//     };
//     this.frameworkComponents = { genderCellRenderer: GenderCellRenderer };
//   }

//   onCellValueChanged(params) {
//     var colId = params.column.getId();
//     if (colId === 'country') {
//       var selectedCountry = params.data.country;
//       var selectedCity = params.data.city;
//       var allowedCities = countyToCityMap(selectedCountry);
//       var cityMismatch = allowedCities.indexOf(selectedCity) < 0;
//       if (cityMismatch) {
//         params.node.setDataValue('city', null);
//       }
//     }
//   }

//   onGridReady(params) {
//     this.gridApi = params.api;
//     this.gridColumnApi = params.columnApi;
//   }
// }

// function countyToCityMap(match) {
//   var map = {
//     Ireland: ['Dublin', 'Cork', 'Galway'],
//     USA: ['New York', 'Los Angeles', 'Chicago', 'Houston'],
//   };
//   return map[match];
// }