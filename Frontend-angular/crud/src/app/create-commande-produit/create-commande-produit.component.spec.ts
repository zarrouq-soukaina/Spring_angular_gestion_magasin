import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateCommandeProduitComponent } from './create-commande-produit.component';

describe('CreateCommandeProduitComponent', () => {
  let component: CreateCommandeProduitComponent;
  let fixture: ComponentFixture<CreateCommandeProduitComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateCommandeProduitComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateCommandeProduitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
