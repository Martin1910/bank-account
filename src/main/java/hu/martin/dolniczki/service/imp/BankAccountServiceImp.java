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
	public boolean createNew_BankAccount(BankAccountEntity bankAccount) {
		Iterable<BankAccountEntity> bankAccounts = bankAccountRepository.findAll();
		
		if (bankAccounts == null) {
			bankAccountRepository.save(bankAccount);
			return true;
		}
		else {
			for (BankAccountEntity bankAccountEntity : bankAccounts) {
				if (bankAccountEntity.getBankAccount().equals(bankAccount.getBankAccount())) {
					return false;
				}
			}
			bankAccountRepository.save(bankAccount);
			return true;
		}
		
	}
	
	@Override
	public void updateBankAccount(Long id) {
		bankAccountRepository.findOne(id);
	}
	
	@Override
	public void deleteBankAccount(String bankAccountNo) {
		Iterable<BankAccountEntity> bankAccounts = bankAccountRepository.findAll();
		for (BankAccountEntity bankAccountEntity : bankAccounts) {
			if (bankAccountEntity.getBankAccount().equals(bankAccountNo)) {
				bankAccountRepository.delete(bankAccountEntity);
			}
		}
	}
	
	@Override
	public void deleteAllBankAccounts() {
		bankAccountRepository.deleteAll();
	}
	
}
