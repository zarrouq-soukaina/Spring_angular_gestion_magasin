import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CommandeProduitDetailsComponent } from './commande-produit-details.component';

describe('CommandeProduitDetailsComponent', () => {
  let component: CommandeProduitDetailsComponent;
  let fixture: ComponentFixture<CommandeProduitDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CommandeProduitDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CommandeProduitDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
