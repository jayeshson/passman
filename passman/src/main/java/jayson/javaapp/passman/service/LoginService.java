package jayson.javaapp.passman.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jayson.javaapp.passman.entity.LoginEntity;
import jayson.javaapp.passman.repo.LoginRepo;

@Service
public class LoginService {

	@Autowired
	private LoginRepo loginRepo;
	
	public List<LoginEntity> getAllLogins() {
		return this.loginRepo.findAll();
	}
	
	public List<LoginEntity> getLoginByUser(String name) {
		return this.loginRepo.findByUsername(name);
	}
	
	public List<LoginEntity> getLoginByAccount(String name) {
		return this.loginRepo.findByAccount(name);
	}
	
	public List<LoginEntity> getLoginByEmail(String id){
		return this.loginRepo.findByEmail(id);
	}
	
	public LoginEntity addLogin(LoginEntity login) {
		return this.loginRepo.save(login);
	}
	
	public List<LoginEntity> search(String str){
		return this.loginRepo.search(str);
	}
}
