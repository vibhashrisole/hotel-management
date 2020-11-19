export class CustomerRegistration {

  private id: string;
  private name: string;
  private adrs: string;
  private contactno: number;
  private emailid: string;

  constructor(id: string, name: string, adrs: string, contactno: number, emailid: string) {
    this.id = id;
    this.name = name;
    this.adrs = adrs;
    this.contactno = contactno;
    this.emailid = emailid;
  }

  set Name(Name: string) {
    this.name = Name;
  }

  get Name(): string {
    return this.name;
  }

  set Address(address: string) {
    this.adrs = address;
  }

  get Address(): string {
    return this.adrs;
  }

  set Contactno(contact: number) {
    this.contactno = contact;
  }

  get Contactno(): number {
    return this.contactno;
  }

  set Emailid(email: string) {
    this.emailid = email;
  }

  get Emailid(): string {
    return this.emailid;
  }

}
