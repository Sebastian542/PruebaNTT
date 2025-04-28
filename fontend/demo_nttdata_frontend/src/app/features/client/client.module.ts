/**
 * -------------------------------------------------------------------
 *?Archivo: client.module.ts
 *?Autor: Daniel Alejandro Palma Garcia
 *?Correo: danielpalma2003@hotmail.com
 *?Fecha: Octubre 2024
 *?Empresa: NTT Data
 *
 *?Descripción:
 * Este archivo define el módulo Angular `ClientModule`, que se encarga
 * de gestionar los componentes y la lógica relacionada con la
 * funcionalidad de clientes en la aplicación.
 * -------------------------------------------------------------------
 */

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { DocumentInputComponent } from '@/app/features/client/components/document-input/document-input.component';
import { SummaryComponent } from '@/app/features/client/components/summary/summary.component';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [DocumentInputComponent, SummaryComponent],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    RouterModule.forChild([
      { path: '', component: DocumentInputComponent },
      { path: 'summary', component: SummaryComponent },
    ]),
  ],
})
export class ClientModule {}
