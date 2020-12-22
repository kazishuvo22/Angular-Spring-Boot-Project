import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateTutorialComponent } from './update-tutorial.component';

describe('UpdateTutorialComponent', () => {
  let component: UpdateTutorialComponent;
  let fixture: ComponentFixture<UpdateTutorialComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateTutorialComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateTutorialComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
