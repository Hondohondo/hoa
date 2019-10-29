import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Member } from '../_auth_models/Member';
import{ environment } from '../../environments/environment';

@Injectable({ providedIn: 'root' })
export class UserService {
    constructor(private http: HttpClient) { }

    getAll() {
        return this.http.get<Member[]>(`${environment.apiUrl}/users`);
    }
    getById(id: number) {
        return this.http.get<Member>(`${environment.apiUrl}/users/${id}`);
    }
}
