import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class ContactsService {
  url= 'http://localhost:8080/customer/getCustomer';
  urlpost='http://localhost:8080/customer/addCustomer';
  constructor(private http: HttpClient) {}

  getCustomers() {
    return this.http.get(this.url);
  }

  addCustomer(value: any) {
    let body = {
      firstName: value.firstName,
      lastName: value.lastName,
      email: value.email,
      company: value.company,
      link:value.link,
      phone: parseInt(value.phone),
    }
    return this.http.post(this.urlpost, body);
  }

}
