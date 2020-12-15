import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Table } from 'C:/Users/PEC/Documents/Codelab/hotel-management/frontend/src/app/shared/class/table';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {
  @ViewChild('tableForm') tableForm: NgForm;
  table: Table = new Table(null, '', 0, null);
  Tables = [];
  editMode = false;
  editDataId;
  show = true;

    constructor(private http: HttpClient) {
      setTimeout(() => {
        this.show = false;
      }, 2000);
     }

    ngOnInit(): void {
      this.fetchData();
    }
    onAddData(tableData: Table): void {
      if (this.editMode){
       // console.log('http://localhost:8080/update');
       this.tableForm.value.id = this.editDataId;
       this.http.put('/app-hotel-management/table', tableData)
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
        console.log(tableData);
        this.Tables.push(tableData);
        this.http.post('/app-hotel-management/table', tableData)
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
      this.http.get('/app-hotel-management/table')
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
      .subscribe(Tables => {
        console.log(Tables);
        this.Tables = Tables;
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
      this.editDataId = id;
      // console.log(this.Tables[index]);
      this.tableForm.setValue({
       table_name: this.Tables[index].table_name,
       table_capacity: this.Tables[index].table_capacity
      });

    }

    onDeleteData(id): void {
      if (confirm('Do you want to delete this data')){
        console.log(id);
        this.http.delete('/app-hotel-management/table/delete/' + id)
        .subscribe(() => {
            this.fetchData();
            }
        );
      }
    }


}
