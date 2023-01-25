package com.home.notes.dao;

import com.home.notes.model.Account;

import java.util.Collection;

public interface AccountDao {

    Account createAccount(String login, String firstName, String lastName);

    Account getAccountByLogin(String login);

    Collection<Account> getAllAccounts();

    Account removeAccountByLogin(String login);
}
