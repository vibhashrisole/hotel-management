export class Type {
    type_id: string;
    type_name: string;

    constructor(type_id: string, type_name: string){
        this.type_id = type_id;
        this.type_name = type_name;

    }

    set types_name(type_name: string){
        this.type_name = type_name;
    }

    get types_name(): string{
        return this.type_name;
    }

}