import { Role } from "../_auth_models/Role";

export class Member {
    id: number;
    username: string;
    password: string;
    firstName: string;
    lastName: string;
    role: Role;
    token?: string;
}