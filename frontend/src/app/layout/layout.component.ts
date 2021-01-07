import { Component, OnInit } from '@angular/core';
import { Menu } from '../shared/interface/menu.interface';

export const menus: Menu[] = [
  {
    path: 'role',
    title: 'Role',
    icon: 'nc-single-02'
  },
  {
    path: 'department',
    title: 'Department',
    icon: 'nc-single-02'
  }
];

@Component({
  selector: 'app-layout',
  templateUrl: './layout.component.html',
  styleUrls: ['./layout.component.css']
})
export class LayoutComponent implements OnInit {

  menuItems = menus;

  constructor() { }

  ngOnInit(): void {
  }

}
