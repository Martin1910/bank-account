package hu.martin.dolniczki.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import hu.martin.dolniczki.entity.BankAccountEntity;
import hu.martin.dolniczki.service.BankAccountService;

@RestController
public class MainController {

	private BankAccountService bankAccountService;
	
	@Autowired
	public MainController(BankAccountService bankAccountService) {
		super();
		this.bankAccountService = bankAccountService;
	}
	
	@GetMapping(path="/listBankAccounts", produces=MediaType.APPLICATION_JSON_VALUE)
	Iterable<BankAccountEntity> listBankAccounts(){
		return bankAccountService.listAll_BankAccount();
	}
	
	@PostMapping(path="/newBankAccount", consumes=MediaType.APPLICATION_JSON_VALUE)
	void createNewBankAccount(@RequestBody BankAccountEntity newBankAccount) {
		bankAccountService.createNew_BankAccount(newBankAccount);
	}
}
