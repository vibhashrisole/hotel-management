export class Department {
    dept_id: string;
    dept_name: string;

    constructor(dept_id: string, dept_name: string){
        this.dept_id = dept_id;
        this.dept_name = dept_name;

    }

    set department_name(Name: string){
        this.dept_name = Name;
    }

    get department_name(): string{
        return this.dept_name;
    }

}
