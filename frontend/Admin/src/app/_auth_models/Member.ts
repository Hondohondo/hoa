import { Role } from "../_auth_models/Role";
/**
 * The representation for a member object. This is a model class used for authentication.
 */
export class Member {
    id: number;
    username: string;
    password: string;
    firstName: string;
    lastName: string;
    role: Role;
    token?: string;
}