import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateCommandeProduitComponent } from './update-commande-produit.component';

describe('UpdateCommandeProduitComponent', () => {
  let component: UpdateCommandeProduitComponent;
  let fixture: ComponentFixture<UpdateCommandeProduitComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateCommandeProduitComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateCommandeProduitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
