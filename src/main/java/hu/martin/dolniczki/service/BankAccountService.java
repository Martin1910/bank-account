package hu.martin.dolniczki.service;

import org.springframework.stereotype.Service;

import hu.martin.dolniczki.entity.BankAccountEntity;

@Service
public interface BankAccountService {
	Iterable<BankAccountEntity> listAll_BankAccount();
	boolean createNew_BankAccount(BankAccountEntity bankAccount);
	void updateBankAccount(Long id);
	void deleteBankAccount(String bankAccountNo);
	void deleteAllBankAccounts();
}
