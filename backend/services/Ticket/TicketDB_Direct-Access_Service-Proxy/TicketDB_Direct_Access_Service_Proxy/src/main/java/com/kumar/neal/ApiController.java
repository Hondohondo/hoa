

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
	
	@RequestMapping("/services/ticket/db_direct_access_service-proxy")
	public TicketSelect get (@RequestParam(value="id") int id) {
		//return new Ticket(id, "asdfasdf");
		return new TicketSelect(id);
	}

}
