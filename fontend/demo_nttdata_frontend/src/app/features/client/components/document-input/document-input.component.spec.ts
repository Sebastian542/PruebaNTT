/**
 * -------------------------------------------------------------------
 *?Archivo: document-input.component.spec.ts
 *?Autor: Daniel Alejandro Palma Garcia
 *?Correo: danielpalma2003@hotmail.com
 *?Fecha: Octubre 2024
 *?Empresa: NTT Data
 *
 *?Descripción:
 * Este archivo contiene las pruebas unitarias para el componente
 * DocumentInputComponent de la aplicación Angular. Utiliza el
 * framework de pruebas de Angular y Jasmine para realizar
 * pruebas sobre la funcionalidad del componente, incluyendo:
 *
 * - Verificar que el componente se crea correctamente.
 * - Validar que se llama al método `getClientData` del servicio
 *   `ClientService` cuando se envía el formulario.
 * - Comprobar que el enrutador navega a la página de resumen
 *   tras un envío exitoso del formulario.
 *
 *?Dependencias:
 * - ReactiveFormsModule: Para manejar formularios reactivos.
 * - ClientService: Servicio que interactúa con la API para
 *   obtener datos del cliente.
 * - Router: Para la navegación dentro de la aplicación.
 * -------------------------------------------------------------------
 */

import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ReactiveFormsModule } from '@angular/forms';
import { DocumentInputComponent } from '@/app/features/client/components/document-input/document-input.component';
import { ClientService } from '@/app/core/services/client.service';
import { Router } from '@angular/router';
import { of } from 'rxjs';

describe('DocumentInputComponent', () => {
  let component: DocumentInputComponent;
  let fixture: ComponentFixture<DocumentInputComponent>;
  let mockClientService: jasmine.SpyObj<ClientService>;
  let mockRouter: jasmine.SpyObj<Router>;

  beforeEach(async () => {
    mockClientService = jasmine.createSpyObj('ClientService', ['getClientData']);
    mockRouter = jasmine.createSpyObj('Router', ['navigate']);

    await TestBed.configureTestingModule({
      declarations: [ DocumentInputComponent ],
      imports: [ ReactiveFormsModule ],
      providers: [
        { provide: ClientService, useValue: mockClientService },
        { provide: Router, useValue: mockRouter }
      ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DocumentInputComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should call getClientData on form submit', () => {
    component.clientForm.setValue({ documentType: 'C', documentNumber: '23.445.322' });
    mockClientService.getClientData.and.returnValue(of({}));

    component.onSubmit();
    expect(mockClientService.getClientData).toHaveBeenCalledWith('C', '23445322');
  });

  it('should navigate to summary on successful form submit', () => {
    component.clientForm.setValue({ documentType: 'C', documentNumber: '23.445.322' });
    mockClientService.getClientData.and.returnValue(of({}));

    component.onSubmit();
    expect(mockRouter.navigate).toHaveBeenCalledWith(['/summary'], { state: {} });
  });
});
