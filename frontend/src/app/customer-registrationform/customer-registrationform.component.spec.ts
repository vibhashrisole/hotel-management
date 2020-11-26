import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerRegistrationformComponent } from './customer-registrationform.component';

describe('CustomerRegistrationformComponent', () => {
  let component: CustomerRegistrationformComponent;
  let fixture: ComponentFixture<CustomerRegistrationformComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomerRegistrationformComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerRegistrationformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
