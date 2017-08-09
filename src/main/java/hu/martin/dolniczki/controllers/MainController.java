package hu.martin.dolniczki.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/")
	public String bankAccountsForm(Model model) {
		model.addAttribute("bankAccount", new BankAccountEntity());
		return "index";
	}
	
	@GetMapping("/allBankAccounts")
	public String listBankAccounts(Model model) {
		model.addAttribute("allBankAccount", bankAccountService.listAll_BankAccount());
		return "allbankaccount";
	}
	
	@PostMapping("/newAccount")
	public String bankAccountsSubmit(@ModelAttribute BankAccountEntity bankAccount) {
		if (bankAccountService.createNew_BankAccount(bankAccount)) {
			return "newbankaccount";
		}
		return "existingbankaccount";
	}
	
	@DeleteMapping("/delete/{bankAccountNo}")
	public String deleteBankAccount(@PathVariable String bankAccountNo) {
		bankAccountService.deleteBankAccount(bankAccountNo);
		return "success";
	}
	
	@DeleteMapping("/deleteAll")
	public String deleteBankAccounts() {
		bankAccountService.deleteAllBankAccounts();
		return "success";
	}
}
