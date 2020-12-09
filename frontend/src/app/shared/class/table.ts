export class Table {
    table_id: string;
    table_name: string;
    table_capacity: number;
    table_status: string;

    constructor(table_id: string, table_name: string, table_capacity: number, table_status: string){
        this.table_id = table_id;
        this.table_name = table_name;

    }

    set name(table_name: string){
        this.table_name = table_name;
    }

    get name(): string{
        return this.table_name;
    }

    set capacity(table_capacity: number){
        this.table_capacity = table_capacity;
    }

    get capacity(): number{
        return this.table_capacity;
    }
}