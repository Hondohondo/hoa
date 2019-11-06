/**
 * Class object for posting tickets to the API.
 */
export class TicketPost {

    ticketMessage: string;
    phoneNumber: string;
    subject: string;
    name: string;
    email: string;
    /**
     * Constructor creates a TicketPost object.
     * @param ticketMessage - Holds the ticket's message.
     * @param phoneNumber - Holds the user's phone number.
     * @param email - Holds the user's email.
     * @param name - Holds the user's name.
     * @param subject -Holds the user's subject for the ticket.
     */
    constructor(ticketMessage:string, phoneNumber:string, email:string, name:string, subject:string){
        this.ticketMessage = ticketMessage;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.name = name;
        this.subject = subject;
    }

}