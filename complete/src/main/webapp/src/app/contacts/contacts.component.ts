import { Component, OnInit } from '@angular/core';
import { trigger, state, style, transition, animate } from '@angular/animations';
import { ContactsService } from '../contacts.service';
import { Observable } from 'rxjs/Observable';

@Component({
  selector: 'app-contacts',
  templateUrl: './contacts.component.html',
  styleUrls: ['./contacts.component.css'],
  animations: [
    trigger('contactsAnimation', [
      state('active', style({
        opacity: '1'
      })),
      transition('void => *', [
        style({transform: 'translateY(-100px)', opacity: '0'}),
        animate('1000ms ease-in-out')
      ])
    ])
  ]
})

export class ContactsComponent implements OnInit {
  input = {
    'width': '360px',
    'background': '#fff',
    'box-shadow': '0 6px 10px 0 rgba(0, 0, 0, .1)',
    'border': '0',
    'outline': '0',
    'padding': '22px 18px'
  }

  public customers;

  constructor(private contactService: ContactsService) {}

  ngOnInit() {
    this.getCustomers();
  }

  getCustomers() {
    this.contactService.getCustomers()
    .subscribe(
      data => { this.customers = data },
      err => console.log(err)
    )
  }
  addCustomer(value:any) {
    let contact = value;
    this.contactService.addCustomer(contact)
    .subscribe(
      data => {
        this.getCustomers();
        return true;
      },
      error => {
        console.error("Error saving contact");
        return Observable.throw(error);
      }
    )
  }
}
