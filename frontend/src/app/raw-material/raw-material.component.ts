import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { RawMaterials } from 'C:/Users/PEC/Documents/Codelab/hotel-management/frontend/src/app/shared/class/raw-materials';

@Component({
  selector: 'app-raw-material',
  templateUrl: './raw-material.component.html',
  styleUrls: ['./raw-material.component.css']
})
export class RawMaterialComponent implements OnInit {
  @ViewChild('rawMaterialForm') rawMaterialForm: NgForm;
  rawMaterials: RawMaterials = new RawMaterials(null, '', 0, 0);
  Materials = [];
  editMode = false;
  editUserId;
  // url = 'https://hotel-management-85fb2.firebaseio.com/rawmaterials.json';
    constructor(private http: HttpClient) { }

    ngOnInit(): void {
      this.fetchData();
    }
    onAddData(rawMaterialData: RawMaterials): void {
      if (this.editMode){
       console.log('http://localhost:8080/update');

       this.http.put('http://localhost:8080/update', rawMaterialData)
       .subscribe(
       (res) => {
        console.log(res);
        alert('Your data updated successfully.');
        this.fetchData();
        }
       );
      }
      else{
        console.log(rawMaterialData);
        this.Materials.push(rawMaterialData);
        this.http.post('http://localhost:8080/addMaterial', rawMaterialData).subscribe(
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
      }  }

    fetchData(): void {
      this.http.get('http://localhost:8080/materials')
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
      .subscribe(Materials => {
        console.log(Materials);
        this.Materials = Materials;
      });
    }

    onEditData(id, index): void {
      this.editMode = true;
      console.log(id);
      this.editUserId = id;
      // console.log(this.Materials[index]);
      this.rawMaterialForm.setValue({
       name: this.Materials[index].name,
       price: this.Materials[index].price,
       quantity: this.Materials[index].quantity
      });
    }

    onDeleteData(id): void {
      if (confirm('Do you want to delete this data')){
        console.log(id);
        this.http.delete('https://hotel-management-85fb2.firebaseio.com/rawmaterials/' + id + '.json')
        .subscribe(() => {
          this.fetchData();
        });
      }
    }

}
