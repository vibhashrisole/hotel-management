export class Address {
    address_id: string;
    line_1: string;
    line_2: string;
    country: string;
    state: string;
    city: string;
    pin_code: number;

    constructor(address_id: string, line_1: string, line_2: string, country: string, state: string, city: string, pin_code: number){
        this.address_id = address_id;
        this.line_1 = line_1;
        this.line_2 = line_2;
        this.country = country;
        this.state = state;
        this.city = city;
        this.pin_code = pin_code;

    }

    set address_Id(address_id: string){
        this.address_id = address_id;
    }

    get address_Id(): string{
        return this.address_id;
    }

    set address_line1(line_1: string){
        this.line_1 = line_1;
    }

    get address_line1(): string{
        return this.line_1;
    }

    set address_line2(line_2: string){
        this.line_2 = line_2;
    }

    get address_line2(): string{
        return this.line_2;
    }

    set Country(country: string){
        this.country = country;
    }

    get Country(): string{
        return this.country;
    }

    set State(state: string){
        this.state = state;
    }

    get State(): string{
        return this.state;
    }

    set City(city: string){
        this.city = city;
    }

    get City(): string{
        return this.city;
    }

    set pincode(pin_code: number){
        this.pin_code = pin_code;
    }

    get pincode(): number{
        return this.pin_code;
    }


}
