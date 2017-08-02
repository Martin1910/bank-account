package hu.martin.dolniczki.service;

import org.springframework.stereotype.Service;

import hu.martin.dolniczki.entity.BankAccountEntity;

@Service
public interface BankAccountService {
	Iterable<BankAccountEntity> listAll_BankAccount();
	void createNew_BankAccount(BankAccountEntity bankAccount);
}
