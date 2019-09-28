export class Ticket{

    constructor(private ticketId:number, private subject:string, private message:string,
        private phoneNumber: number, private email:string, private isActive: boolean, private memberId:number){
            this.TicketId = ticketId;
            this.Subject = subject;
            this.Message = message;
            this.PhoneNumber = phoneNumber;
            this.Email = email;
            this.IsActive = isActive;
            this.MemberId = memberId
    }

    TicketId : number;
    Subject : string;
    Message : string;
    PhoneNumber: number;
    Email : string;
    IsActive : boolean;
    MemberId : number;
}