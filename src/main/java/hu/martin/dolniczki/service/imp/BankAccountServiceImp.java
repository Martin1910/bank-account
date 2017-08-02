package hu.martin.dolniczki.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.martin.dolniczki.entity.BankAccountEntity;
import hu.martin.dolniczki.repository.BankAccountRepository;
import hu.martin.dolniczki.service.BankAccountService;

@Service
public class BankAccountServiceImp implements BankAccountService {

	private BankAccountRepository bankAccountRepository;

	@Autowired
	public BankAccountServiceImp(BankAccountRepository bankAccountRepository) {
		super();
		this.bankAccountRepository = bankAccountRepository;
	}

	@Override
	public Iterable<BankAccountEntity> listAll_BankAccount() {
		return bankAccountRepository.findAll();
	}

	@Override
	public void createNew_BankAccount(BankAccountEntity bankAccount) {
		bankAccountRepository.save(bankAccount);
	}

}
