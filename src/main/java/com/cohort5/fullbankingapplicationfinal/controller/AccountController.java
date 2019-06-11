package com.cohort5.fullbankingapplicationfinal.controller;

import com.cohort5.fullbankingapplicationfinal.exception.HttpException;
import com.cohort5.fullbankingapplicationfinal.model.*;
import com.cohort5.fullbankingapplicationfinal.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
//@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    
    //get all accounts method
    //Iterable<Account>
    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public ResponseEntity<?> getAllAccounts() {
        ArrayList<Account> arrayList = accountService.getAllAccounts();
        return accountService.getAllAccounts();
    }

    //get account owner method
    //Optional<Account>
    //option.of throws the NullPointerException if the passed parameter is null
    @RequestMapping(value = "/accounts/{accountId}/customer", method = RequestMethod.GET)
    public ResponseEntity<?> getAccountOwner(@PathVariable Long accountId) {
        Optional<Customer> customer = Optional.of(accountService.getAccountOwner(accountId));
        return customer;
    }

    //get bills by account method
    //Iterable<Bill>
    @RequestMapping(value = "/accounts/{accountId}/bills", method = RequestMethod.GET)
    public ResponseEntity<?> getBillsByAccount(@PathVariable Long accountId){
        ArrayList<Bill> arrayList = accountService.getBillsByAccount(accountId);
            return accountService.getBillsByAccount(accountId);
    }

    //get withdrawals by account method
    //Iterable<Withdrawal>
    @RequestMapping(value = "/accounts/accountId}/withdrawals", method = RequestMethod.GET)
    public ResponseEntity<?> getWithdrawalsByAccount(@PathVariable Long accountId){
      ArrayList<Withdrawal> arrayList = accountService.getWithdrawalsByAccount(accountId);
          return accountService.getWithdrawalsByAccount(accountId);
    }

    //get deposits by account method
    //Iterable<Deposits>
    @RequestMapping(value = "/accounts/{accountId}/deposits", method = RequestMethod.GET)
    public ResponseEntity<?> getDepositsByAccount(@PathVariable Long accountId){
        ArrayList<Deposit> arrayList = accountService.getDepositsByAccount(accountId);
            return accountService.getDepositsByAccount(accountId);
    }

    //create an account method check
    //Optional<Account>
    @RequestMapping(value = "/customers/{customerId}/accounts", method = RequestMethod.POST)
    public ResponseEntity<?> createAccount(@RequestBody Account account, @PathVariable Long customerId){
    Account account1 = accountService.createAccount(account);
    Long account_id = account1.getAccount_id();
    Optional<Account> optionalAccount = accountService.getAccountById(account_id);
        return optionalAccount;
    }

    //get account by id method
    //Optional<Account>
    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.GET)
    public ResponseEntity<?> getAccountById(@PathVariable Long accountId) {
        Optional<Account> optionalAccount = accountService.getAccountById(accountId);
            return accountService.getAccountById(accountId);
        }

    //update an account method
    //Account
    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateAccount(@RequestBody Account account, @PathVariable Long accountId){
        accountService.updateAccount(account);
        Account account1 = accountService.getAccountById(account.getAccount_id()).get();
            return account1;
    }

    //delete an account method
    //void
    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAccount(@PathVariable Long accountId){
        Optional<Account> optionalAccount = accountService.getAccountById(accountId);
       accountService.deleteAccount(accountId);
    }

}
