import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateInvoiceComponent } from './update-invoice.component';

describe('UpdateInvoiceComponent', () => {
  let component: UpdateInvoiceComponent;
  let fixture: ComponentFixture<UpdateInvoiceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateInvoiceComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateInvoiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
