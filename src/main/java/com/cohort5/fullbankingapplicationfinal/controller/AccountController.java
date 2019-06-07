package com.cohort5.fullbankingapplicationfinal.controller;

import com.cohort5.fullbankingapplicationfinal.exception.HttpException;
import com.cohort5.fullbankingapplicationfinal.model.*;
import com.cohort5.fullbankingapplicationfinal.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Optional;

@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    //get all accounts method
    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public HttpException getAllAccounts(){
        try{
        ArrayList<Iterable> arrayList = new ArrayList<>();
        arrayList.add(accountService.getAllAccounts());
        HttpException message = new HttpException(HttpStatus.OK, "Success");
        return message;
    } catch (Exception e){
            HttpException message = new HttpException(HttpStatus.NOT_FOUND, "error fetching accounts");
            return message;
        }
    }

    //get account owner method
    @RequestMapping(value = "/customers/{accountId}", method = RequestMethod.GET)
    public HttpException getAccountOwner(@PathVariable Long accountId){
        try{
            ArrayList<Customer> arrayList = new ArrayList<>();
            arrayList.add(accountService.getAccountOwner(accountId));
            HttpException message = new HttpException(HttpStatus.OK, "Success");
            return message;
        } catch (Exception e){
            HttpException message = new HttpException(HttpStatus.NOT_FOUND, "error fetching account");
            return message;
        }
    }

    //get bills by account method
    @RequestMapping(value = "/accounts/{accountId}/bills", method = RequestMethod.GET)
    public HttpException getBillsByAccount(@PathVariable Long accountId){
        try{
            ArrayList<Iterable> arrayList = new ArrayList<>();
            arrayList.add(accountService.getBillsByAccount(accountId));
            HttpException message = new HttpException(HttpStatus.OK, "Success");
            return message;
        } catch (Exception e){
            HttpException message = new HttpException(HttpStatus.NOT_FOUND, "error fetching bill with id");
            return message;
        }

    }

    //get withdrawals by account method
    @RequestMapping(value = "/accounts/{accountId}/withdrawals", method = RequestMethod.GET)
    public HttpException getWithdrawalsByAccount(@PathVariable Long accountId){
        try{
            ArrayList<Iterable> arrayList = new ArrayList<>();
            arrayList.add(accountService.getWithdrawalsByAccount(accountId));
            HttpException message = new HttpException(HttpStatus.OK, "Success");
            return message;
        } catch (Exception e){
            HttpException message = new HttpException(HttpStatus.NOT_FOUND, "error fetching withdrawals with id");
            return message;
        }
    }

    //get deposits by account method
    @RequestMapping(value = "/accounts/{accountId}/deposits", method = RequestMethod.GET)
    public HttpException getDepositsByAccount(@PathVariable Long accountId){
        try{
            ArrayList<Iterable> arrayList = new ArrayList<>();
            arrayList.add(accountService.getDepositsByAccount(accountId));
            HttpException message = new HttpException(HttpStatus.OK, " Success");
            return message;
        } catch (Exception e){
            HttpException message = new HttpException(HttpStatus.NOT_FOUND, "error fetching deposits with id");
            return message;
        }
    }

    //create an account method
    @RequestMapping(value = "/customers/{customerId}/accounts", method = RequestMethod.POST)
    public HttpException createAccount(@RequestBody Account account, @PathVariable Long customerId ){
        try{
            ArrayList<Account> arrayList = new ArrayList<>();
            arrayList.add(accountService.createAccount(customerId, account));
            HttpException message = new HttpException(HttpStatus.OK, "Account created");
            return message;
            } catch (Exception e){
            HttpException message = new HttpException(HttpStatus.NOT_FOUND, "error fetching creating customers account");
            return message;
        }
    }

    //get account by id method
    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.GET)
    public HttpException getAccountById(@PathVariable Long accountId) {
        try {
            ArrayList<Optional<Account>> arrayList = new ArrayList<>();
            arrayList.add(accountService.getAccountById(accountId));
            HttpException message = new HttpException(HttpStatus.OK, "Success");
            return message;
        } catch (Exception e) {
            HttpException message = new HttpException(HttpStatus.NOT_FOUND, "error fetching account");
            return message;
        }
    }

    //update an account method
    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.PUT)
    public HttpException updateAccount(@RequestBody Account account, @PathVariable Long accountId){
        try{
            accountService.updateAccount(account);
            ArrayList<Account> arrayList = new ArrayList();
            arrayList.add(accountService.updateAccount(account));
            HttpException message = new HttpException(HttpStatus.OK, "Customer account updated");
                    return message;
        } catch (Exception e){
            HttpException message = new HttpException(HttpStatus.NOT_FOUND, "Error ");
            return message;
        }
    }

    //delete an account method
    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.DELETE)
    public HttpException deleteAccount(@PathVariable Long accountId){
        try{
        accountService.deleteAccount(accountId);
        HttpException message = new HttpException(HttpStatus.OK, "Account successfully deleted");
        return message;
        } catch (Exception e){
            HttpException message = new HttpException(HttpStatus.BAD_REQUEST, "Account does not exist");
            return message;
        }
    }

}
