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
    @Autowired //gets rid of the setter methods
    private AccountService accountService;

    //get all accounts method
    //Iterable<Account>
    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public ResponseEntity<?> getAllAccounts() {
        accountService.getAllAccounts();
//        Iterable<Account> accounts = accountService.getAllAccounts();
        Message message = new Message(HttpStatus.CREATED.value(), "Success", accountService.getAllAccounts());
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    //get account owner method
    //Optional<Account>
    //option.of throws the NullPointerException if the passed parameter is null
    @RequestMapping(value = "/accounts/{accountId}/customer", method = RequestMethod.GET)
    public ResponseEntity<?> getAccountOwner(@PathVariable Long accountId) {
//        Optional<Customer> customer = Optional.of(accountService.getAccountOwner(accountId));
        Message message = new Message(HttpStatus.OK.value(), "Success", accountService.getAccountOwner(accountId));
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    //get bills by account method
    //Iterable<Bill>
    @RequestMapping(value = "/accounts/{accountId}/bills", method = RequestMethod.GET)
    public ResponseEntity<?> getBillsByAccount(@PathVariable Long accountId){
        Message message = new Message(HttpStatus.OK.value(), "Success", accountService.getBillsByAccount(accountId));
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    //get withdrawals by account method
    //Iterable<Withdrawal>
    @RequestMapping(value = "/accounts/{accountId}/withdrawals", method = RequestMethod.GET)
    public ResponseEntity<?> getWithdrawalsByAccount(@PathVariable Long accountId){
      Message message = new Message(HttpStatus.OK.value(), "Success", accountService.getWithdrawalsByAccount(accountId));
          return new ResponseEntity<>(message, HttpStatus.OK);
    }

    //get deposits by account method
    //Iterable<Deposits>
    @RequestMapping(value = "/accounts/{accountId}/deposits", method = RequestMethod.GET)
    public ResponseEntity<?> getDepositsByAccount(@PathVariable Long accountId){
        Message message = new Message(HttpStatus.OK.value(), "Success", accountService.getDepositsByAccount(accountId));
            return new ResponseEntity<>(message, HttpStatus.OK);
    }

    //create an account method check
    //Optional<Account>
    @RequestMapping(value = "/customers/{customerId}/accounts", method = RequestMethod.POST)
    public ResponseEntity<?> createAccount(@RequestBody Account account, @PathVariable Long customerId){
    Message message = new Message(HttpStatus.OK.value(),"Success", accountService.createAccount(account, customerId));
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    //get account by id method
    //Optional<Account>
    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.GET)
    public ResponseEntity<?> getAccountById(@PathVariable Long accountId) {
        Message message = new Message(HttpStatus.OK.value(), "Success", accountService.getAccountById(accountId));
            return new ResponseEntity<>(message, HttpStatus.OK);
    }

    //update an account method
    //Account
    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateAccount(@RequestBody Account account, @PathVariable Long accountId){
        Message message = new Message(HttpStatus.OK.value(), "Success", accountService.updateAccount(account));
            return new ResponseEntity<>(message, HttpStatus.OK);
    }

    //delete an account method
    //void
    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAccount(@PathVariable Long accountId){
        accountService.deleteAccount(accountId);
       Message message = new Message(HttpStatus.OK.value(), "Success");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
