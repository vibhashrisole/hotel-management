import { Component, Inject, Injectable, OnInit } from '@angular/core';
import { SettingService } from 'src/app/shared/service/setting.service';

@Component({
  selector: 'app-department',
  templateUrl: './department.component.html',
  styleUrls: ['./department.component.css']
})
export class DepartmentComponent implements OnInit {

  constructor(private setting: SettingService) { }

  ngOnInit(): void {
    this.setting.pageTitle = 'Department';
  }

}
