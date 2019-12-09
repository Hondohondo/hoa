import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

import { AuthenticationService } from '../_auth_services/authentication.service';
/**
 * This class handles errors from the API. If the error is a 401 then it sends back an error message to the user. This is used for logging in with invalid credentials.
 */
@Injectable()
export class ErrorInterceptor implements HttpInterceptor {
    constructor(private authenticationService: AuthenticationService) {}

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        return next.handle(request).pipe(catchError(err => {
            if (err.status === 401) {
                // auto logout if 401 response returned from api
                //sets error as the error message from HTTP error status or pre-made string.
                this.authenticationService.logout();
                //location.reload(true);
            }
            const error = err.error.message || "Wrong username or password.";
            return throwError(error);
        }))
    }
}