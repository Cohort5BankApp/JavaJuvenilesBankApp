package com.cohort5.fullbankingapplicationfinal.controller;

import com.cohort5.fullbankingapplicationfinal.exception.HttpException;
import com.cohort5.fullbankingapplicationfinal.model.*;
import com.cohort5.fullbankingapplicationfinal.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    //inside is what is happening when there is an exception error
    @GetMapping("/age")
    ResponseEntity<String> age(@RequestParam("yearOfBirth") int yearOfBirth) {
        if (isInFuture(yearOfBirth)) {
            return ResponseEntity.badRequest()
                    .body("Year of birth cannot be in the future");
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body("Your age is " + calculateAge(yearOfBirth));
    }

    //get all accounts method
    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public Iterable<Account> getAllAccounts() {
        ArrayList<Account> arrayList = accountService.getAllAccounts();
        if (arrayList.size() < 1)
            throw new HttpException(HttpStatus.NOT_FOUND, "error fetching accounts");
        if (arrayList.size() > 0)
            throw new HttpException(HttpStatus.OK, "Success");
        return accountService.getAllAccounts();
    }

    //get account owner method
    //option.of throws the NullPointerException if the passed parameter is null
    @RequestMapping(value = "/customers/{accountId}", method = RequestMethod.GET)
    public Optional<Customer> getAccountOwner(@PathVariable Long accountId) {
        Optional<Customer> customer = Optional.of(accountService.getAccountOwner(accountId));
        if (!customer.isPresent())
            throw new HttpException(HttpStatus.NOT_FOUND, "error fetching account");
        if (customer.isPresent())
            throw new HttpException(HttpStatus.OK, "Success");
        return customer;
    }

    //get bills by account method
    @RequestMapping(value = "/accounts/{accountId}/bills", method = RequestMethod.GET)
    public Iterable<Bill> getBillsByAccount(@PathVariable Long accountId){
        ArrayList<Bill> arrayList = accountService.getBillsByAccount(accountId);
        if(arrayList.size() < 1)
            throw new HttpException(HttpStatus.NOT_FOUND, "error fetching bills with id");
        if(arrayList.size() > 0)
            throw new HttpException(HttpStatus.OK, "Success");
            return accountService.getBillsByAccount(accountId);
    }

    //get withdrawals by account method
    @RequestMapping(value = "/accounts/{accountId}/withdrawals", method = RequestMethod.GET)
    public Iterable<Withdrawal> getWithdrawalsByAccount(@PathVariable Long accountId){
      ArrayList<Withdrawal> arrayList = accountService.getWithdrawalsByAccount(accountId);
      if(arrayList.size() < 1)
          throw new HttpException(HttpStatus.NOT_FOUND, "error fetching withdrawals with id");
      if(arrayList.size() > 0)
          throw new HttpException(HttpStatus.OK, "Success");
          return accountService.getWithdrawalsByAccount(accountId);
    }

    //get deposits by account method
    @RequestMapping(value = "/accounts/{accountId}/deposits", method = RequestMethod.GET)
    public Iterable<Deposit> getDepositsByAccount(@PathVariable Long accountId){
        ArrayList<Deposit> arrayList = accountService.getDepositsByAccount(accountId);
        if(arrayList.size() < 1)
            throw new HttpException(HttpStatus.NOT_FOUND, " error fetching deposits with id");
        if(arrayList.size() > 0)
            throw new HttpException(HttpStatus.OK, "Success");
            return accountService.getDepositsByAccount(accountId);
    }

    //create an account method
    @RequestMapping(value = "/customers/{customerId}/accounts", method = RequestMethod.POST)
    public Account createAccount(@RequestBody Account account, @PathVariable Long customerId ){
        Account account1 = accountService.createAccount(customerId, account);
        Long account_id = account1.getAccount_id();
        Optional<Account> optionalAccount = accountService.getAccountById(account_id);
        if(!optionalAccount.isPresent())
            throw new HttpException(HttpStatus.NOT_FOUND, "error fetching creating customers account");
        if(optionalAccount.isPresent())
            throw new HttpException(HttpStatus.OK, "Success creating account");
            return account1;
    }

    //get account by id method
    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.GET)
    public Optional<Account> getAccountById(@PathVariable Long accountId) {
        Optional<Account> optionalAccount = accountService.getAccountById(accountId);
        if(!optionalAccount.isPresent())
            throw new HttpException(HttpStatus.NOT_FOUND, "error fetching account");
        if(optionalAccount.isPresent())
            throw new HttpException(HttpStatus.OK, "Success");
            return accountService.getAccountById(accountId);
        }

    //update an account method
    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.PUT)
    public Account updateAccount(@RequestBody Account account, @PathVariable Long accountId){
        accountService.updateAccount(account);
        Optional<Account> account1 = accountService.getAccountById(account.getAccount_id());
        if (!account1.isPresent())
            throw new HttpException(HttpStatus.NOT_FOUND, "Error");
        if (account1.isPresent())
            throw new HttpException(HttpStatus.OK, "Customer Account Updated");
            return account;
    }

    //delete an account method
    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.DELETE)
    public void deleteAccount(@PathVariable Long accountId){
        Optional<Account> optionalAccount = accountService.getAccountById(accountId);
        if(!optionalAccount.isPresent())
            throw new HttpException(HttpStatus.BAD_REQUEST, "Account does not exist");
        if(optionalAccount.isPresent())
        throw new HttpException(HttpStatus.OK, "Account successfully deleted");
       accountService.deleteAccount(accountId);
    }

}
