import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatSelectModule, MatButtonModule, MatCheckboxModule, MatFormFieldModule, MatInputModule } from '@angular/material';
import { AppWebModule } from '../../app/app-web/app-web.module';
import { AppModule } from '../../app/app.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

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
    ],
    exports: [
      MatSelectModule,
      MatButtonModule,
      MatCheckboxModule,
      MatFormFieldModule,
      MatSelectModule,
      MatInputModule,
      BrowserAnimationsModule,

    ],
  declarations: [
  ]
})
export class MaterialModule { }
