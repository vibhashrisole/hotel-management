import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CustomerRegistrationformComponent } from './customer-registrationform/customer-registrationform.component';
import { RawMaterialComponent } from './raw-material/raw-material.component';

@NgModule({
  declarations: [
    AppComponent,
    CustomerRegistrationformComponent,
    RawMaterialComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
