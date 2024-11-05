package jayson.javaapp.passman.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jayson.javaapp.passman.entity.LoginEntity;
import jayson.javaapp.passman.service.LoginService;

@RestController
@RequestMapping("/logins")
public class LoginController {

	
	@Autowired
	private LoginService loginService;
	
	@GetMapping()
	public List<LoginEntity> getAllLogins() {
		return this.loginService.getAllLogins();
	}
	
	@GetMapping("/user/{name}")
	public List<LoginEntity> getLoginByUser(@PathVariable String name) {
		return this.loginService.getLoginByUser(name);
	}
	
	@GetMapping("/account/{name}")
	public List<LoginEntity> getLoginByAccount(@PathVariable String name) {
		return this.loginService.getLoginByAccount(name);
	}
	
	@GetMapping("/email/{id}")
	public List<LoginEntity> getLoginByEmail(@PathVariable String id){
		return this.loginService.getLoginByEmail(id);
	}
	
	@GetMapping("/search/{str}")
	public List<LoginEntity> search(@PathVariable String str){
		return this.loginService.search(str);
	}
	
	@PostMapping("/add")
	public LoginEntity addLogin(@RequestBody LoginEntity login) {
		return this.loginService.addLogin(login);
	}
}
