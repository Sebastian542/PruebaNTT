/**
 * -------------------------------------------------------------------
 *?Archivo: document-input.component.ts
 *?Autor: Daniel Alejandro Palma Garcia
 *?Correo: danielpalma2003@hotmail.com
 *?Fecha: Octubre 2024
 *?Empresa: NTT Data
 *
 *?Descripción:
 * Este componente maneja la entrada de documentos de clientes en la
 * aplicación Angular. Permite a los usuarios ingresar el tipo y
 * número de documento, valida los datos y envía la solicitud al
 * servicio correspondiente.
 *
 *?Funcionalidades:
 * - Uso de reactive forms con validaciones para los campos de entrada.
 * - Formatea el número de documento al introducirlo (separadores de miles).
 * - Envío de los datos a través del servicio ClientService para
 *   obtener información del cliente.
 * - Redirección a la vista de resumen si la solicitud es exitosa.
 * - Manejo de errores en caso de que la solicitud falle.
 *
 *?Dependencias:
 * - FormBuilder: Para crear y gestionar el formulario reactivo.
 * - Router: Para navegar entre diferentes vistas de la aplicación.
 * - ClientService: Servicio para interactuar con la API del backend.
 * -------------------------------------------------------------------
 */

import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ClientService } from '@/app/core/services/client.service';

type FormControls = { documentType: string; documentNumber: string };

@Component({
  selector: 'app-document-input',
  templateUrl: './document-input.component.html'
})
export class DocumentInputComponent {
  clientForm: FormGroup;
  error: string | null = null;

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private clientService: ClientService
  ) {
    this.clientForm = this.fb.group({
      documentType: ['', Validators.required],
      documentNumber: [
        '',
        [
          Validators.required,
          Validators.minLength(10),
          Validators.maxLength(14),
        ],
      ],
    });
  }

  formatDocumentNumber(event: Event): void {
    const input = event.target as HTMLInputElement;
    input.value = input.value
      .replace(/\D/g, '')
      .replace(/\B(?=(\d{3})+(?!\d))/g, '.');
  }

  onSubmit(): void {
    if (this.clientForm.valid) {
      let { documentType, documentNumber }: FormControls = this.clientForm.value;
      documentNumber = documentNumber.replace(/\./g, '');
      this.clientService.getClientData(documentType, documentNumber).subscribe(
        (data) => {
          this.router.navigate(['/summary'], { state: data });
        },
        (error) => {
          this.error = error;
        }
      );
    }
  }
}
