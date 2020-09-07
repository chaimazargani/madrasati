import { NgModule } from '@angular/core';
//import { CommonModule } from '@angular/common';
import { MatSelectModule, MatButtonModule, MatCheckboxModule, MatFormFieldModule, MatInputModule, MatTableDataSource } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
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
import {MatSortModule, MatSort} from '@angular/material/sort';
import {MatTabsModule} from '@angular/material/tabs';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatTooltipModule} from '@angular/material/tooltip';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AgGridModule } from 'ag-grid-angular';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { MatTableModule } from '@angular/material/table';
import {AccordionModule} from 'primeng/accordion';     //accordion and accordion tab
import {CheckboxModule} from 'primeng/checkbox';
import {FullCalendarModule} from 'primeng/fullcalendar';
import {CalendarModule} from 'primeng/calendar';
import {ButtonModule} from 'primeng/button';
import {DialogModule} from 'primeng/dialog';
import {InputTextModule} from 'primeng/inputtext';
import {SidebarModule} from 'primeng/sidebar';
import {MenubarModule} from 'primeng/menubar';
import {RouterModule} from '@angular/router';
import {ToastModule} from 'primeng/toast';

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
   MatTableModule,
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
    ReactiveFormsModule,
    BrowserModule,
    AgGridModule.withComponents([]),
    CommonModule,  
    HttpClientModule,  
    MatTableModule,
    AccordionModule,
    CheckboxModule,
    FullCalendarModule,
    CalendarModule,
    ButtonModule,
    DialogModule,
    InputTextModule,
    CalendarModule,
    SidebarModule,
    MenubarModule,
    RouterModule,
    ToastModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    ],
    exports: [
      MatSelectModule,
      MatButtonModule,
      MatCheckboxModule,
      MatFormFieldModule,
      MatSelectModule,
      MatInputModule,
      CheckboxModule,
      FormsModule,
      MatTableModule,
      FullCalendarModule,
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
      ReactiveFormsModule,
      BrowserModule,
      AgGridModule,
      CommonModule,
      HttpClientModule,
      MatSortModule,
      MatTableModule,
      AccordionModule,
      ButtonModule,
      DialogModule,
      InputTextModule,
      CalendarModule,
      SidebarModule,
      RouterModule,
      BrowserModule,
      BrowserAnimationsModule,
      MenubarModule,
      ToastModule,
      ReactiveFormsModule,

    ],
  declarations: [
    
  ]
})
export class MaterialModule { }