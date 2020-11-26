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

  set setName(Name: string) {
    this.name = Name;
  }

  get getName(): string {
    return this.name;
  }

  set setAddress(address: string) {
    this.adrs = address;
  }

  get getAddress(): string {
    return this.adrs;
  }

  set setContactno(contact: number) {
    this.contactno = contact;
  }

  get getContactno(): number {
    return this.contactno;
  }

  set setEmailid(email: string) {
    this.emailid = email;
  }

  get getEmailid(): string {
    return this.emailid;
  }

}
