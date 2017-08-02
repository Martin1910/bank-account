package hu.martin.dolniczki.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hu.martin.dolniczki.entity.BankAccountEntity;

@Repository
public interface BankAccountRepository extends CrudRepository<BankAccountEntity, Long> {

}
