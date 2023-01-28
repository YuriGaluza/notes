package com.home.notes.service;

import com.home.notes.dao.AccountDao;
import com.home.notes.dto.request.AccountDtoRequest;
import com.home.notes.dto.response.AccountDtoResponse;
import com.home.notes.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Component
public class AccountService {

    @Autowired
    private final AccountDao accountDao;

    public AccountService(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public AccountDtoRequest createAccount(AccountDtoResponse accountDtoResponse) {
        Account account = accountDao.createAccount(accountDtoResponse.getLogin(), accountDtoResponse.getFirstName(),
                accountDtoResponse.getLastName());
        if (account != null) {
            return new AccountDtoRequest(account.getLogin(), account.getFirstName(), account.getLastName());
        }
        return null;
    }

    public AccountDtoRequest getAccountByLogin(String login) {
        Account account = accountDao.getAccountByLogin(login);
        if (account != null) {
            return new AccountDtoRequest(account.getLogin(), account.getFirstName(), account.getLastName());
        }
        return null;
    }

    public List<AccountDtoRequest> getAllAccounts() {
        Collection<Account> accounts = accountDao.getAllAccounts();
        List<AccountDtoRequest> accountDtoRequests = new ArrayList<>();
        for (Account account : accounts) {
            accountDtoRequests.add(new AccountDtoRequest(account.getLogin(), account.getFirstName(),
                    account.getLastName()));
        }
        return accountDtoRequests;
    }

    public AccountDtoRequest removeAccountByLogin(String login) {
        Account account = accountDao.removeAccountByLogin(login);
        if (account != null) {
            return new AccountDtoRequest(account.getLogin(), account.getFirstName(), account.getLastName());
        }
        return null;
    }
}
