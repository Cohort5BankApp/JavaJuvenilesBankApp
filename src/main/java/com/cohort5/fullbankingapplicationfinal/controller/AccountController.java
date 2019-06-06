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
    @RequestMapping(value = "/customers/{account_id}", method = RequestMethod.GET)
    public Customer getAccountOwner(@PathVariable Long account_id){
        return accountService.getAccountOwner(account_id);
    }

    //get bills by account method
    @RequestMapping(value = "/accounts/{account_id}/bills", method = RequestMethod.GET)
    public Iterable<Bill> getBillsByAccount(@PathVariable Long account_id){
        return accountService.getBillsByAccount(account_id);
    }

    //get withdrawals by account method
    @RequestMapping(value = "/accounts/{account_id}/withdrawals", method = RequestMethod.GET)
    public Iterable<Withdrawal> getWithdrawalsByAccount(@PathVariable Long account_id){
        return accountService.getWithdrawalsByAccount(account_id);
    }

    //get deposits by account method
    @RequestMapping(value = "/accounts/{account_id}/deposits", method = RequestMethod.GET)
    public Iterable<Deposit> getDepositsByAccount(@PathVariable Long account_id){
        return accountService.getDepositsByAccount(account_id);
    }

    //create an account method
    @RequestMapping(value = "/customers/{customers_id}/accounts", method = RequestMethod.POST)
    public Account createAccount(@RequestBody Account account, @PathVariable Long customer_id ){
        return accountService.createAccount(customer_id, account);
    }

    //get account by id method
    @RequestMapping(value = "/accounts/{account_id}", method = RequestMethod.GET)
    public Optional<Account> getAccountById(@PathVariable Long account_id){
        return accountService.getAccountById(account_id);
    }

    //update an account method
    @RequestMapping(value = "/accounts/{account_id}", method = RequestMethod.PUT)
    public Account updateAccount(@RequestBody Account account){
        return accountService.updateAccount(account);
    }

    //delete an account method
    @RequestMapping(value = "/accounts/{account_id}", method = RequestMethod.DELETE)
    public void deleteAccount(@PathVariable Long account_id){
        accountService.deleteAccount(account_id);
    }

}
