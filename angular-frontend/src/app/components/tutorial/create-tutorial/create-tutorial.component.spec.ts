import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateTutorialComponent } from './create-tutorial.component';

describe('CreateTutorialComponent', () => {
  let component: CreateTutorialComponent;
  let fixture: ComponentFixture<CreateTutorialComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateTutorialComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateTutorialComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
