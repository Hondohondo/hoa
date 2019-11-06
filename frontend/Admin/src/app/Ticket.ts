/**
 * Export class that acts as the model for a Ticket object.
 */
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
    message: string;
    /**
     * Constructor takes in a Ticket object or a generic object then copies the properties from JSON data from API to the target object which is a Ticket object.
     * @param data - The source data from API
     */
    constructor(data:Ticket|Object){
        Object.assign(this,data);
    }
}