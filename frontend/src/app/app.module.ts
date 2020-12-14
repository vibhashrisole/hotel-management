import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';

import { CustomerRegistrationformComponent } from './customer-registrationform/customer-registrationform.component';
import { RawMaterialComponent } from './raw-material/raw-material.component';
import { DepartmentComponent } from './department/department.component';
import { RoleComponent } from './pages/role/role.component';
import { LayoutComponent } from './layout/layout.component';
import { NavbarComponent } from './shared/component/navbar/navbar.component';
import { FooterComponent } from './shared/component/footer/footer.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { SettingService } from './shared/service/setting.service';

@NgModule({
  declarations: [
    AppComponent,
    CustomerRegistrationformComponent,
    RawMaterialComponent,
    DepartmentComponent,
    RoleComponent,
    LayoutComponent,
    NavbarComponent,
    FooterComponent,
    DashboardComponent
  ],
  imports: [
    BrowserModule,
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
