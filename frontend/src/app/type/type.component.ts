import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Type } from 'C:/Users/PEC/Documents/Codelab/hotel-management/frontend/src/app/shared/class/type';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-type',
  templateUrl: './type.component.html',
  styleUrls: ['./type.component.css']
})
export class TypeComponent implements OnInit {

  @ViewChild('typeForm') typeForm: NgForm;
  type: Type = new Type(null, '');
  Types = [];
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
    onAddData(typeData: Type): void {
      if (this.editMode){
       this.typeForm.value.id = this.editUserId;
       this.http.put('/app-hotel-management/type', typeData)
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
        console.log(typeData);
        this.Types.push(typeData);
        this.http.post('/app-hotel-management/type', typeData)
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
      this.http.get('/app-hotel-management/type')
      .pipe(map(resData => {
        console.log(resData);
        const userArray = [];
        // tslint:disable-next-line: forin
        for (const key in resData){
          // console.log(key);
          // console.log({resData[key]});
          // console.log(resData.hasOwnProperty(key));
          if (resData.hasOwnProperty(key)){
            userArray.push({id: key, ...resData[key]});
          }
        }
        return userArray;
      }))
      .subscribe(Types => {
        console.log(Types);
        this.Types = Types;
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
      this.typeForm.setValue({
       type_name: this.Types[index].type_name
      });

    }

    onDeleteData(id): void {
      if (confirm('Do you want to delete this data')){
        console.log(id);
        this.http.delete('/app-hotel-management/type/delete/' + id)
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
