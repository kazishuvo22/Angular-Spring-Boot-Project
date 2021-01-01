import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchDoctorNameComponent } from './search-doctor-name.component';

describe('SearchDoctorNameComponent', () => {
  let component: SearchDoctorNameComponent;
  let fixture: ComponentFixture<SearchDoctorNameComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchDoctorNameComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchDoctorNameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
