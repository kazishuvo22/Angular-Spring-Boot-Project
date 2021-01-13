import { TestBed } from '@angular/core/testing';

import { MedicinService } from './medicin.service';

describe('MedicinService', () => {
  let service: MedicinService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MedicinService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
