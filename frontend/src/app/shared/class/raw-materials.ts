export class RawMaterials {
    id?: string;
    name: string;
    price: number;
    quantity: number;
    constructor(id: string, name: string, price: number, quantity: number){
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    set setName(Name: string){
        this.name = Name;
    }

    get getName(): string{
        return this.name;
    }

    set setPrice(Price: number){
        this.price = Price;
    }

    get getPrice(): number{
        return this.price;
    }

    set setQuantity(qty: number){
        this.quantity = qty;
    }

    get getQuantity(): number{
        return this.quantity;
    }

}
