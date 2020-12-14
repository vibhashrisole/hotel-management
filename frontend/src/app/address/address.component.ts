import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Address } from 'C:/Users/PEC/Documents/Codelab/hotel-management/frontend/src/app/shared/class/address';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-address',
  templateUrl: './address.component.html',
  styleUrls: ['./address.component.css']
})
export class AddressComponent implements OnInit {

  @ViewChild('addressForm') addressForm: NgForm;
  address: Address = new Address(null, '', '', '', '', '', 0);
  Address = [];
  editMode = false;
  editUserId;
  show = true;

  selectedCountry = '--Choose Country--';

  Countries: Array<any> = [
    { name: 'Australia',
      states: [
                {name: 'New South Wales', cities: ['Albury', 'Bathurst', 'Goulburn', 'Sydney', 'Taree']},
                {name: 'Queensland', cities: ['Brisbane', 'Cairns', 'Gladstone', 'Logan city', 'Redland city']},
                {name: 'South Australia', cities: ['Adelaide', 'Mount Gambier', 'Gawler', 'whyalla']},
                {name: 'Victoria', cities: ['Bellaral', 'Berwick', 'Melbourne', 'Frankston', 'Saint Albans']},
                {name: 'Western Australia', cities: ['Albany', 'Bunbury', 'Geraldton', 'Karratha']},
              ]
    },
    { name: 'Canada',
      states: [
                {name: 'Alberta', cities: ['Calgary', 'Edmonton', 'Lethbridge', 'St. Albert', 'Leduce']},
                {name: 'British Columbia', cities: ['Vancouver', 'Surrey', 'Burnaby', 'Richmond', 'Delta']},
                {name: 'Manitoba', cities: ['Brandon', 'Steinbach', 'Thompson', 'Selkirk', 'Winnipeg']},
                {name: 'New Brunswick', cities: ['Bathurst', 'Caraquet', 'Dalhousie', 'Edmundston', 'Sackville']},
                {name: 'Ontario', cities: ['Brampton', 'Hamilton', 'London', 'Toronto', 'Ottawa']},
              ]
    },
    { name: 'Germany',
      states: [
                {name: 'Bavaria', cities: ['Lindau', 'Fiissen', 'Regensburg', 'wiirzburg', 'Bamberg']},
                {name: 'Hesse', cities: ['Kassel', 'Darmstadt', 'Offenbach', 'Hanau', 'Gieben']},
                {name: 'Thuringia', cities: ['Erfurt', 'Jena', 'Gera', 'Gotha', 'Weimar']},
                {name: 'Saxony', cities: ['Leipzig', 'Dresden', 'Chemnitz', 'Zwickau', 'Plauen']},
                {name: 'Saarland', cities: ['Neunkirchen', 'Homburg', 'Volklingen', 'Saarlouis', 'Merzig']},
              ]
    },
    { name: 'India',
      states: [
                {name: 'Assam', cities: ['Guwahati', 'Dibrugarh', 'Jorhat', 'Tezpur', 'Tinsukia']},
                {name: 'Bihar', cities: ['Patna', 'Gaya', 'Hajipur', 'Katihar', 'Purnia']},
                {name: 'Goa', cities: ['Bicholim', 'Panaji', 'Ponda', 'Valpoi']},
                {name: 'Gujarat', cities: ['Ahmedabad', 'Surat', 'Vadodara', 'Rajkot', 'Gandhinagar']},
                {name: 'Maharashtra', cities: ['Mumbai', 'Pune', 'Nagpur', 'Nashik', 'Aurangabad']},
              ]
    },
    { name: 'Mexico',
      states: [
                {name: 'Tabasco', cities: ['Balancan', 'Frontera', 'Paraiso', 'Tenosique', 'Villahermosa']},
                {name: 'Baja California', cities: ['Mexicali', 'Tijuana', 'Ensenada', 'Tecate', 'Rosarito']},
                {name: 'Chiapas', cities: ['Comitan', 'Tapachula', 'Palenque', 'Tonala']},
                {name: 'Durango', cities: ['Lerdo', 'Pueblo Nuevo', 'Victoria De Durango', 'Ignacio Allende']},
                {name: 'Jalisco', cities: ['Guadalajara', 'Tlaquepaque', 'Zapopan', 'Tonala']},
              ]
    },
    { name: 'Spain',
      states: [
                {name: 'Andalucia', cities: ['Sevilla', 'Malaga', 'Cadiz', 'Cordoba', 'Granada']},
                {name: 'Aragon', cities: ['', 'Calatayud', 'Huesca', 'Teruel', 'Zaragoza']},
                {name: 'Cantabria', cities: ['Comillas', 'Torrelavega', 'Laredo', 'Soba', 'Guarnizo']},
                {name: 'Galicia', cities: ['Ferrol', 'Lugo', 'Ourense', 'Pontevedras']},
              ]
    },
    { name: 'USA',
      states: [
                {name: 'Alabama', cities: ['Albury', 'Birmingham', 'Dothan', 'Hoover', 'Montgomery']},
                {name: 'California', cities: ['Los Angeles', 'San Diego', 'San Jose', 'Fresno', 'Sacramento']},
                {name: 'Florida', cities: ['Jacksonville', 'Tampa', 'Orlando', 'Hialeah']},
                {name: 'Hawaii', cities: ['Hilo', 'Pearl City', 'Kaneohe', 'Halawa', 'Wahiawa']},
                {name: 'Kansas', cities: ['Topeka', 'Olathe', 'Lawrence', 'Salina', 'Emporia']},
              ]
    },
  ];

  states: Array<any>;

  cities: Array<any>;

  changeCountry(country): void {
    this.states = this.Countries.find(cntry => cntry.name === country).states;
  }

  changeState(state): void {
    this.cities = this.Countries.find(cntry => cntry.name === this.selectedCountry).states.find(stat => stat.name === state).cities;
  }

    constructor(private http: HttpClient) {
      setTimeout(() => {
        this.show = false;
      }, 2000);
     }

    ngOnInit(): void {
      this.fetchData();
    }
    onAddData(addressData: Address): void {
      if (this.editMode){
       this.addressForm.value.id = this.editUserId;
       this.http.put('/app-hotel-management/address', addressData)
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
        console.log(addressData);
        this.Address.push(addressData);
        this.http.post('/app-hotel-management/address', addressData)
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
      this.http.get('/app-hotel-management/address')
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
      .subscribe(Adrs => {
        console.log(Adrs);
        this.Address = Adrs;
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
      this.addressForm.setValue({
       line_1: this.Address[index].line_1,
       line_2: this.Address[index].line_2,
       country: this.Address[index].country,
       state: this.Address[index].state,
       city: this.Address[index].city,
       pin_code: this.Address[index].pin_code
      });

    }

    onDeleteData(id): void {
      if (confirm('Do you want to delete this data')){
        console.log(id);
        this.http.delete('/app-hotel-management/address/delete/' + id)
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
