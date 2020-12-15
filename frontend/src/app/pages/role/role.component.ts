import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Role } from 'src/app/shared/interface/role.interface';
import { SettingService } from 'src/app/shared/service/setting.service';

@Component({
  selector: 'app-role',
  templateUrl: './role.component.html',
  styleUrls: ['./role.component.css']
})
export class RoleComponent implements OnInit {

  roles: Role[] = [];

  constructor(private setting: SettingService, private http: HttpClient) { }

  ngOnInit(): void {
    this.setting.pageTitle = 'Role';
    this.fetchRoleList();
  }

  fetchRoleList(): void {
    this.http.get<Role[]>('/app-hotel-management/role').subscribe(
      response => {
        this.roles = response;
      },
      error => {
        debugger;
        // To Do: Implement error handler
      }
    );
  }

}
