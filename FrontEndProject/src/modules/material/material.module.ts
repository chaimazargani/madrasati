import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatSelectModule, MatButtonModule, MatCheckboxModule, MatFormFieldModule, MatInputModule, MatTableModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { enableProdMode } from '@angular/core';
import {CdkTableModule} from '@angular/cdk/table';
import {A11yModule} from '@angular/cdk/a11y';
import {PortalModule} from '@angular/cdk/portal';
import {CdkStepperModule} from '@angular/cdk/stepper';
import {MatAutocompleteModule} from '@angular/material/autocomplete';
import {MatButtonToggleModule} from '@angular/material/button-toggle';
import {MatCardModule} from '@angular/material/card';
import {MatChipsModule} from '@angular/material/chips';
import {MatStepperModule} from '@angular/material/stepper';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatDialogModule} from '@angular/material/dialog';
import {MatDividerModule} from '@angular/material/divider';
import {MatExpansionModule} from '@angular/material/expansion';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatIconModule} from '@angular/material/icon';
import {MatListModule} from '@angular/material/list';
import {MatMenuModule} from '@angular/material/menu';
import {MatNativeDateModule, MatRippleModule} from '@angular/material/core';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatProgressBarModule} from '@angular/material/progress-bar';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import {MatRadioModule} from '@angular/material/radio';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatSliderModule} from '@angular/material/slider';
import {MatSlideToggleModule} from '@angular/material/slide-toggle';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {MatSortModule} from '@angular/material/sort';
import {MatTabsModule} from '@angular/material/tabs';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatTooltipModule} from '@angular/material/tooltip';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AgGridModule } from 'ag-grid-angular';
import { HttpClientModule } from '@angular/common/http';



@NgModule({
  imports: [
    CommonModule,
    MatSelectModule,
    MatButtonModule,
    MatCheckboxModule,
    MatFormFieldModule,
    MatSelectModule,
    MatInputModule,
    BrowserAnimationsModule,
    BrowserModule,
    FormsModule,
    CdkTableModule,
    MatTableModule,
    A11yModule,
    MatTooltipModule,
    MatTabsModule,
    MatSortModule,
    MatSnackBarModule,
    MatSlideToggleModule,
    MatSliderModule,
    MatSidenavModule,
    MatRadioModule,
    MatProgressSpinnerModule,
    MatProgressBarModule,
    MatPaginatorModule,
    MatNativeDateModule, MatRippleModule,
    MatMenuModule,
    MatListModule,
    MatIconModule,
    MatGridListModule,
    MatExpansionModule,
    MatDividerModule,
    MatDialogModule,
    MatDatepickerModule,
    MatStepperModule,
    MatChipsModule,
    MatCardModule,
    MatButtonToggleModule,
    MatAutocompleteModule,
    CdkStepperModule,
    PortalModule,
    ReactiveFormsModule,
    BrowserModule,
    AgGridModule.withComponents([]),
    CommonModule,  
    HttpClientModule,  
    ],
    exports: [
      MatSelectModule,
      MatButtonModule,
      MatCheckboxModule,
      MatFormFieldModule,
      MatSelectModule,
      MatInputModule,
      BrowserAnimationsModule,
      BrowserModule,
      FormsModule,
      CdkTableModule,
      MatTableModule,
      A11yModule,
      MatToolbarModule,
      MatTabsModule,
      MatSortModule,
      MatSnackBarModule,
      MatSlideToggleModule,
      MatSliderModule,
      MatSidenavModule,
      MatRadioModule,
      MatProgressSpinnerModule,
      MatProgressBarModule,
      MatPaginatorModule,
      MatNativeDateModule, MatRippleModule,
      MatMenuModule,
      MatListModule,
      MatIconModule,
      MatGridListModule,
      MatExpansionModule,
      MatDividerModule,
      MatDialogModule,
      MatDatepickerModule,
      MatStepperModule,
      MatChipsModule,
      MatCardModule,
      MatButtonToggleModule,
      MatAutocompleteModule,
      CdkStepperModule,
      PortalModule,
      ReactiveFormsModule,
      BrowserModule,
      AgGridModule,
      CommonModule,
      HttpClientModule,
    ],
  declarations: [
    
  ]
})
export class MaterialModule { }
