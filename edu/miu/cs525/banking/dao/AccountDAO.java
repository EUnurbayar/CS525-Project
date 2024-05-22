package edu.miu.cs525.banking.dao;

import edu.miu.cs525.banking.domain.Account;

import java.util.Collection;

public interface AccountDAO {
    void create(Account account);
    void update(Account account);
    Account getAccountByAccountNumber(String accountNumber);
    Collection<Account> getAccounts();
}
