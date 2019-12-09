import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { environment } from '../../environments/environment';
import { Member } from '../_auth_models/Member';

@Injectable({ providedIn: 'root' })
export class AuthenticationService {
    //Current user information variables.
    private currentUserSubject: BehaviorSubject<Member>;
    public currentUser: Observable<Member>;

    constructor(private http: HttpClient) {
        this.currentUserSubject = new BehaviorSubject<Member>(JSON.parse(localStorage.getItem('currentUser')));
        this.currentUser = this.currentUserSubject.asObservable();
    }
    //Grabs the current user information if they are logged in.
    public get currentUserValue(): Member {
        return this.currentUserSubject.value;
    }
    /**
     * This method requests a POST HTTP call to the API with the user credentials in a query parameter for validation.
     * @param username - user input for their username
     * @param password - user input for their password
     */
    login(username: string, password: string) {
        // return this.http.post<any>(`${environment.apiUrl}/users/authen`, { username, password })
        //     .pipe(map(user => {
        //         // login successful if there's a jwt token in the response
        //         if (user && user.token) {
        //             // store user details and jwt token in local storage to keep user logged in between page refreshes
        //             localStorage.setItem('currentUser', JSON.stringify(user));
        //             this.currentUserSubject.next(user);
        //         }

        //         return user;
        //     }));
        return this.http.post<any>(`http://hoa.api.ngrok.io/services/basic_auth/`, { username, password })
        .pipe(map(user => {
            // login successful if there's a jwt token in the response
            if (user && user.id) {
                // store user details and jwt token in local storage to keep user logged in between page refreshes
                localStorage.setItem('currentUser', JSON.stringify(user));
                this.currentUserSubject.next(user);
            }

            return user;
        }));
    }

    logout() {
        // remove user from local storage to log user out
        localStorage.removeItem('currentUser');
        this.currentUserSubject.next(null);
    }
}