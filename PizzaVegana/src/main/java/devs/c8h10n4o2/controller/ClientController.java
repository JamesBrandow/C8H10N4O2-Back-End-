package devs.c8h10n4o2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import devs.c8h10n4o2.entities.Client;
import devs.c8h10n4o2.services.ClientService;
import devs.c8h10n4o2.services.UserRoleService;

@Component
@Controller
public class ClientController {
	
	
	
	

	@Autowired
	ClientService cs;
	
	@Autowired
	UserRoleService us;
	
	
	@RequestMapping(value = "/clients", method = RequestMethod.GET)
	@ResponseBody	//says that this method does not return an html view
	//indicates we will be sending back information in JSON, or XML or plain text
	public List<Client> getAllClients() {
		
		return cs.getAllClient();
	}
	
	@ResponseBody
	@RequestMapping(value = "/client/{username}", method = RequestMethod.GET)
	public Client getClientByCredentials(@PathVariable String username) {
		Gson gson = new Gson();
		String json = request.getReader().lines().reduce(""(accumulator,actual) ->accumulator+actual);
		Client cl = gson.fromJson(json, Client.class);
		Client c = cr.findClientByUsername(cl.getUsername());
		
		return cs.getClientByUsername(username);
	}
	
	@ResponseBody
	@RequestMapping(value = "/clients", method = RequestMethod.POST)
	public Client createClient(@RequestBody Client client) {	
		System.out.println(client);
		return cs.createClient(client);
	}
	
	
	
}
