import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, NgForm, Validators } from '@angular/forms';

@Component({
  selector: 'app-customer-registrationform',
  templateUrl: './customer-registrationform.component.html',
  styleUrls: ['./customer-registrationform.component.css']
})
export class CustomerRegistrationformComponent implements OnInit {
  registrationForm = new FormGroup({
    fullname: new FormControl('', Validators.required),
    address: new FormControl('', Validators.required),
    contactno: new FormControl('', Validators.required),
    emailid: new FormControl('', Validators.required)
  });

  show = true;

  onSubmit(): void {
    debugger;
  }

  onReset(): void {
    debugger;
  }
  constructor() { }

  ngOnInit(): void {
  }

}
