import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Role } from 'src/app/shared/class/role';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';


@Component({
  selector: 'app-role',
  templateUrl: './role.component.html',
  styleUrls: ['./role.component.css']
})
export class RoleComponent implements OnInit {

  @ViewChild('roleForm') roleForm: NgForm;
  role: Role = new Role(null, '');
  Roles = [];
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
  onAddData(roleData: Role): void {
    if (this.editMode) {
      // console.log('http://localhost:8080/update');
      this.roleForm.value.role_id = this.editUserId;
      this.http.put('/app-hotel-management/role', roleData)
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
    else {
      console.log(roleData);
      this.Roles.push(roleData);
      this.http.post('/app-hotel-management/role', roleData)
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
    this.http.get('/app-hotel-management/role')
      .pipe(map(resData => {
        console.log(resData);
        const userArray = [];
        // tslint:disable-next-line: forin
        for (const key in resData) {
          // console.log(key);
          // console.log({resData[key]});
          // console.log(resData.hasOwnProperty(key));
          if (resData.hasOwnProperty(key)) {
            userArray.push({ role_id: key, ...resData[key] });
          }
        }
        return userArray;
      }))
      .subscribe(roles => {
        console.log(roles);
        this.Roles = roles;
      },
        error => {
          // debugger;
        },
        () => {
          //  debugger;
        }
      );
  }

  onEditData(id, index): void {
    this.editMode = true;
    console.log(id);
    this.editUserId = id;
    // console.log(this.Materials[index]);
    this.roleForm.setValue({
      role_name: this.Roles[index].role_name
    });

  }

  onDeleteData(id): void {
    if (confirm('Do you want to delete this data')) {
      console.log(id);
      this.http.delete('/app-hotel-management/role/delete/' + id)
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
