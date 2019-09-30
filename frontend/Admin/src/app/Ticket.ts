export class Ticket {

    ticketMessage: string;
    createdDate: string;
    phoneNumber: string;
    createdBy: string;
    subject: string;
    name: string;
    isActive: boolean;
    ticketId: number;
    memberId: number;

    constructor(data:Ticket|Object){
        Object.assign(this,data);
    }
}