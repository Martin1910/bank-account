package hu.martin.dolniczki.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import hu.martin.dolniczki.entity.BankAccountEntity;
import hu.martin.dolniczki.service.BankAccountService;

@Controller
public class MainController {

	private BankAccountService bankAccountService;
	
	@Autowired
	public MainController(BankAccountService bankAccountService) {
		super();
		this.bankAccountService = bankAccountService;
	}
	
	@GetMapping("/form")
	public String bankAccountsForm(Model model) {
		model.addAttribute("bankAccount", new BankAccountEntity());
		return "index";
	}
	
	@GetMapping("/allBankAccounts")
	public String listBankAccounts(Model model) {
		model.addAttribute("allBankAccount", bankAccountService.listAll_BankAccount());
		return "allbankaccount";
	}
	
	@PostMapping("/form")
	public String bankAccountsSubmit(@ModelAttribute BankAccountEntity bankAccount) {
		bankAccountService.createNew_BankAccount(bankAccount);
		return "bankaccounts";
	}
}
