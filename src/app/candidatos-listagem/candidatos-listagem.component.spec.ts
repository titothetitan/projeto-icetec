import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CandidatosListagemComponent } from './candidatos-listagem.component';

describe('CandidatosListagemComponent', () => {
  let component: CandidatosListagemComponent;
  let fixture: ComponentFixture<CandidatosListagemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CandidatosListagemComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CandidatosListagemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
