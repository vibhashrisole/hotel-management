import { Component } from '@angular/core';
import { FormGroup, FormControl, NgForm, Validators } from '@angular/forms';
import { CustomerRegistration } from 'C:/Users/PEC/Documents/Angular/Hotel-Management-app/src/app/shared/class/customer-registration';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Hotel-Management-app';
  registrationForm = new FormGroup({
    fullname: new FormControl('', Validators.required),
    address: new FormControl('', Validators.required),
    contactno: new FormControl('', Validators.required),
    emailid: new FormControl('', Validators.required)
  });

  show = true;

  /*constructor(private http: HttpClient){
    setTimeout(() => {
      this.show = false;
    }, 2000);
  }*/

  onSubmit(): void {
    debugger;
  }

  onReset(): void {
    debugger;
  }
}
