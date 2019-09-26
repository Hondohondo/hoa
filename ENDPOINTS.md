# Service Endpoints for the front-end:

### Ticket
##### Insert New
TYPE: HTTP POST
</br>URI: http://hoa.api.ngrok.io/services/ticket/microservices/ticket_crud_service/
</br>Params: 
<ol>
  <li>subject (String)</li>
  <li>ticketMessage (String)</li>
  <li>isActive (bit - 1 or 0)</li>
  <li>createdBy (String)</li>
  <li>name (String)</li>
  <li>phoneNumber (String)</li>
  <li>email (String)</li>
  <li>memberId (String)</li>
</ol>
</br>

##### Get All Ticket Records (for populating the admin table)
TYPE: HTTP GET
</br>URI: http://hoa.api.ngrok.io/services/ticket/microservices/ticket_crud_service/GetAll
</br>Params: None!
</br>
