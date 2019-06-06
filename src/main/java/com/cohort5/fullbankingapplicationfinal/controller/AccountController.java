package com.cohort5.fullbankingapplicationfinal.controller;

import com.cohort5.fullbankingapplicationfinal.model.Account;
import com.cohort5.fullbankingapplicationfinal.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    //get all accounts method
    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public Iterable<Account> getAllAccounts()(@PathVariable Long account_id){
        accountService.getAllAccounts();
    }

    //get account owner method
    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
    public


}
