import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GenerarCostosComponent } from './generar-costos.component';

describe('GenerarCostosComponent', () => {
  let component: GenerarCostosComponent;
  let fixture: ComponentFixture<GenerarCostosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GenerarCostosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GenerarCostosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
