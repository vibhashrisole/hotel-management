export class Role {
    role_id: string;
    role_name: string;

    constructor(role_id: string, role_name: string){
        this.role_id = role_id;
        this.role_name = role_name;

    }

    set name(Name: string){
        this.role_name = Name;
    }

    get name(): string{
        return this.name;
    }

}
