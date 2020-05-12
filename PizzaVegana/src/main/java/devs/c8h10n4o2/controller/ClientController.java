package devs.c8h10n4o2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import devs.c8h10n4o2.entities.Client;
import devs.c8h10n4o2.entities.UserRole;
import devs.c8h10n4o2.services.ClientService;
import devs.c8h10n4o2.services.UserRoleService;

@Component
@Controller
@CrossOrigin("*")
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
	@RequestMapping(value = "/query/clients", method = RequestMethod.GET)
	public Client getClientByUsername(@RequestParam String username, @RequestParam String password) {
		Client client = new Client();
		client.setUsername(username);
		client.setPassword(password);

		Client c = cs.getClientByUsername(username);
		if(c.equals(client)) {
			System.out.println(c);
			return c;
		}else {
			System.out.println("Didnt work");
			return null;
		}
	}

	
	@ResponseBody
	@RequestMapping(value = "/clients", method = RequestMethod.POST)
	public Client createClient(@RequestBody Client client) {	
		System.out.println(client);
		UserRole ur = us.getUserRoleById(2);
		client.setUserRole(ur);
		return cs.createClient(client);
	}
	
	@ResponseBody
	@RequestMapping(value = "/updateclient", method = RequestMethod.PUT)
	public Client updateClient(@RequestBody Client client) {
		System.out.println(client);
		UserRole u = us.getUserRoleById(2);
		//System.out.println(u.getRoleId());
		//client.setUserRole(userRole););
		client.setUserRole(u);
		return cs.updateClient(client);
	} 
	
	
	
}
