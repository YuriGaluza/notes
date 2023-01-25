package com.home.notes.controller;

import com.home.notes.dto.request.AccountDtoRequest;
import com.home.notes.dto.response.AccountDtoResponse;
import com.home.notes.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

    @Autowired
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('accounts:write')")
    public AccountDtoRequest createAccount(@RequestBody AccountDtoResponse accountDtoResponse) {
        return accountService.createAccount(accountDtoResponse);
    }

    @GetMapping("/{login}")
    @PreAuthorize("hasAuthority('accounts:read')")
    public AccountDtoRequest getAccountByLogin(@PathVariable("login") String login) {
        return accountService.getAccountByLogin(login);
    }

    @GetMapping("/")
    @PreAuthorize("hasAuthority('accounts:read')")
    public List<AccountDtoRequest> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @DeleteMapping("/{login}")
    @PreAuthorize("hasAuthority('accounts:write')")
    public AccountDtoRequest removeAccountByLogin(@PathVariable("login") String login) {
        return accountService.removeAccountByLogin(login);
    }
}
