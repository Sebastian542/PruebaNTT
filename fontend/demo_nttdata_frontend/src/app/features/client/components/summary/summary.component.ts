/**
 * -------------------------------------------------------------------
 *?Archivo: summary.component.ts
 *?Autor: Daniel Alejandro Palma Garcia
 *?Correo: danielpalma2003@hotmail.com
 *?Fecha: Octubre 2024
 *?Empresa: NTT Data
 *
 *?Descripción:
 * Este componente representa la vista de resumen de un cliente en la
 * aplicación Angular. Utiliza el Router de Angular para navegar entre
 * las diferentes vistas.
 *
 * - **Selector**: `app-summary`, utilizado para incrustar este componente
 *   en otras plantillas.
 * - **Constructor**: Inyecta el Router y verifica si hay datos de navegación
 *   disponibles. Si no se encuentran datos, redirige a la página principal.
 * - **clientData**: Almacena los datos del cliente recibidos a través de la
 *   navegación.
 * - **Método goBack**: Permite al usuario regresar a la vista principal
 *   navegando a la ruta '/'.
 * -------------------------------------------------------------------
 */

import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-summary',
  templateUrl: './summary.component.html'
})
export class SummaryComponent {
  clientData: any;

  constructor(private router: Router) {
    const navigation = this.router.getCurrentNavigation();
    if (!navigation?.extras.state) {
      router.navigate(["/"])
    }
    this.clientData = navigation?.extras.state;
  }

  goBack(): void {
    this.router.navigate(['/']);
  }
}
