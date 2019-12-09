import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Member } from '../_auth_models/Member';
import{ environment } from '../../environments/environment';
/**
 * This class is currently not in use.
 */
@Injectable({ providedIn: 'root' })
export class UserService {
    constructor(private http: HttpClient) { }

    // getAll() {
    //     return this.http.get<Member[]>(`${environment.apiUrl}/users`);
    // }
    // getById(id: number) {
    //     return this.http.get<Member>(`${environment.apiUrl}/users/${id}`);
    // }
    getById(id: number){
        return this.http.get<Member>('http://danny-test.ngrok.io/services/basic_auth/by_id'+id);
    }
    getAll(){
        return this.http.get<Member[]>(`http://danny-test.ngrok.io/services/basic_auth/all`);
    }
}
