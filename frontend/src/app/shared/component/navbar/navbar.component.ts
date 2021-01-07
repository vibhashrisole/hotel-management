import { Component, ElementRef, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SettingService } from '../../service/setting.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  private toggleButton;
  private sidebarVisible: boolean;

  public isCollapsed = true;

  constructor(private setting: SettingService, private element: ElementRef, private router: Router) {
    this.sidebarVisible = false;
  }

  ngOnInit(): void {
    const navbar: HTMLElement = this.element.nativeElement;
    this.toggleButton = navbar.getElementsByClassName('navbar-toggle')[0];
    this.router.events.subscribe((event) => { this.sidebarClose(); });
  }

  getTitle(): string {
    return this.setting.pageTitle;
  }

  sidebarToggle(): void {
    if (this.sidebarVisible) {
      this.sidebarClose();
    } else {
      this.sidebarOpen();
    }
  }

  sidebarOpen(): void {
    const toggleButton = this.toggleButton;
    const html = document.getElementsByTagName('html')[0];
    const mainPanel: HTMLElement = document.getElementsByClassName('main-panel')[0] as HTMLElement;
    setTimeout(() => { toggleButton.classList.add('toggled'); }, 500);

    html.classList.add('nav-open');
    if (window.innerWidth < 991) {
      mainPanel.style.position = 'fixed';
    }
    this.sidebarVisible = true;
  }

  sidebarClose(): void {
    const html = document.getElementsByTagName('html')[0];
    const mainPanel: HTMLElement = document.getElementsByClassName('main-panel')[0] as HTMLElement;
    if (window.innerWidth < 991) {
      setTimeout(() => { mainPanel.style.position = ''; }, 500);
    }
    this.toggleButton.classList.remove('toggled');
    this.sidebarVisible = false;
    html.classList.remove('nav-open');
  }

  collapse(): void {
    this.isCollapsed = !this.isCollapsed;
    const navbar = document.getElementsByTagName('nav')[0];
    console.log(navbar);
    if (!this.isCollapsed) {
      navbar.classList.remove('navbar-transparent');
      navbar.classList.add('bg-white');
    } else {
      navbar.classList.add('navbar-transparent');
      navbar.classList.remove('bg-white');
    }
  }

}
