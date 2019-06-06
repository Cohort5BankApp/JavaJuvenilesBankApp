package com.cohort5.fullbankingapplicationfinal.controller;

import com.cohort5.fullbankingapplicationfinal.model.*;
import com.cohort5.fullbankingapplicationfinal.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    //get all accounts method
    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public Iterable<Account> getAllAccounts(){
        return accountService.getAllAccounts();
    }

    //get account owner method
    @RequestMapping(value = "/customers/{accountId}", method = RequestMethod.GET)
    public Customer getAccountOwner(@PathVariable Long accountId){
        return accountService.getAccountOwner(accountId);
    }

    //get bills by account method
    @RequestMapping(value = "/accounts/{accountId}/bills", method = RequestMethod.GET)
    public Iterable<Bill> getBillsByAccount(@PathVariable Long accountId){
        return accountService.getBillsByAccount(accountId);
    }

    //get withdrawals by account method
    @RequestMapping(value = "/accounts/{accountId}/withdrawals", method = RequestMethod.GET)
    public Iterable<Withdrawal> getWithdrawalsByAccount(@PathVariable Long accountId){
        return accountService.getWithdrawalsByAccount(accountId);
    }

    //get deposits by account method
    @RequestMapping(value = "/accounts/{accountId}/deposits", method = RequestMethod.GET)
    public Iterable<Deposit> getDepositsByAccount(@PathVariable Long accountId){
        return accountService.getDepositsByAccount(accountId);
    }

    //create an account method
    @RequestMapping(value = "/customers/{customerId}/accounts", method = RequestMethod.POST)
    public Account createAccount(@RequestBody Account account, @PathVariable Long customerId ){
        return accountService.createAccount(customerId, account);
    }

    //get account by id method
    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.GET)
    public Optional<Account> getAccountById(@PathVariable Long accountId){
        return accountService.getAccountById(accountId);
    }

    //update an account method
    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.PUT)
    public Account updateAccount(@RequestBody Account account, @PathVariable Long accountId){
        return accountService.updateAccount(account);
    }

    //delete an account method
    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.DELETE)
    public void deleteAccount(@PathVariable Long accountId){
        accountService.deleteAccount(accountId);
    }

}
