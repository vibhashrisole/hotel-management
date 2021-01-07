import { Component, OnInit } from '@angular/core';
import { SettingService } from 'src/app/shared/service/setting.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor(private setting: SettingService) { }

  ngOnInit(): void {
    this.setting.pageTitle = 'Dashboard';
  }

}
