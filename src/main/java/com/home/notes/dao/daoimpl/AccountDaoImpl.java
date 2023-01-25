package com.home.notes.dao.daoimpl;

import com.home.notes.dao.AccountDao;
import com.home.notes.model.Account;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class AccountDaoImpl implements AccountDao {

    private final Map<String, Account> accountMap = new HashMap<>();

    public Account createAccount(String login, String firstName, String lastName) {
        Account account = new Account(login, firstName, lastName);
        return accountMap.putIfAbsent(login, account);
    }

    public Account getAccountByLogin(String login) {
        return accountMap.get(login);
    }

    public Collection<Account> getAllAccounts() {
        return accountMap.values();
    }

    public Account removeAccountByLogin(String login) {
        return accountMap.remove(login);
    }
}
