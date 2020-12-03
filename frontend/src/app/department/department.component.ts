import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Department } from 'src/app/shared/class/department';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-department',
  templateUrl: './department.component.html',
  styleUrls: ['./department.component.css']
})
export class DepartmentComponent implements OnInit {

  @ViewChild('departmentForm') departmentForm: NgForm;
  department: Department = new Department(null, '');
  Departments = [];
  editMode = false;
  editUserId;
  show = true;

    constructor(private http: HttpClient) {
      setTimeout(() => {
        this.show = false;
      }, 2000);
     }

    ngOnInit(): void {
      this.fetchData();
    }
    onAddData(departmentData: Department): void {
      if (this.editMode){
       this.departmentForm.value.dept_id = this.editUserId;
       this.http.put('/app-hotel-management/department', departmentData)
       .subscribe(
       (res) => {
        console.log(res);
        alert('Your data updated successfully.');
        this.fetchData();
        },
        error => {
          // debugger;
         },
         () => {
          //  debugger;
         }
       );
      }
      else{
        console.log(departmentData);
        this.Departments.push(departmentData);
        this.http.post('/app-hotel-management/department', departmentData)
        .subscribe(
        (res) => {
          console.log(res);
          alert('Your data added successfully.');
        },
        error => {
         // debugger;
        },
        () => {
         //  debugger;
        }
      );
      }

    }

    fetchData(): void {
      this.http.get('/app-hotel-management/department')
      .pipe(map(resData => {
        console.log(resData);
        const userArray = [];
        // tslint:disable-next-line: forin
        for (const key in resData){
          // console.log(key);
          // console.log({resData[key]});
          // console.log(resData.hasOwnProperty(key));
          if (resData.hasOwnProperty(key)){
            userArray.push({dept_id: key, ...resData[key]});
          }
        }
        return userArray;
      }))
      .subscribe(Departments => {
        console.log(Departments);
        this.Departments = Departments;
      },
      error => {
        // debugger;
       },
       () => {
        //  debugger;
       }
      );
    }

    onEditData(deptid, index): void {
      this.editMode = true;
      console.log(deptid);
      this.editUserId = deptid;
      // console.log(this.Materials[index]);
      this.departmentForm.setValue({
       dept_name: this.Departments[index].dept_name
      });

    }

    onDeleteData(deptid): void {
      if (confirm('Do you want to delete this data')){
        console.log(deptid);
        this.http.delete('/app-hotel-management/department/delete/' + deptid)
        .subscribe(() => {
            this.fetchData();
            },
          error => {
          // debugger;
          },
          () => {
          //  debugger;
         }
        );
      }
    }

}
