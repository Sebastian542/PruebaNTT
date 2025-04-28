
import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root',
})
export class ClientService {
  private apiUrl = 'http://localhost:8090/api/clients/query';

  constructor(private http: HttpClient) {}

  getClientData(documentType: string, documentNumber: string): Observable<any> {
    return this.http
      .get(
        `${this.apiUrl}?documentType=${documentType}&documentNumber=${documentNumber}`
      )
      .pipe(catchError(this.handleError));
  }

  private handleError(error: HttpErrorResponse) {
    let errorMessage = 'Unknown error occurred';
    if (error.status === 404) {
      errorMessage = 'Client not found';
    } else if (error.status === 500) {
      errorMessage = 'Server error';
    }
    return throwError(errorMessage);
  }
}
