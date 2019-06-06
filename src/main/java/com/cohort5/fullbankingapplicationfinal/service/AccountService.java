package com.cohort5.fullbankingapplicationfinal.service;

import com.cohort5.fullbankingapplicationfinal.model.*;
import com.cohort5.fullbankingapplicationfinal.repository.AccountRepository;
import com.cohort5.fullbankingapplicationfinal.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CustomerRepository customerRepository;

    //get all account method
    public Iterable<Account> getAllAccounts(){
        return accountRepository.findAll();
    }

    //get account by id method
    public Optional<Account> getAccountById(Long account_id){
        return accountRepository.findById(account_id);
    }

    //create account method
    public Account createAccount(Long customer_id, Account account){
        accountRepository.save(account);
        account.set(customer_id);




    }

    //update an account method
    public Account updateAccount(Account account){
        return accountRepository.save(account);
    }

    //deletes an account method
    public void deleteAccount (Long account_id){
        accountRepository.deleteById(account_id);
    }

    //get Account owner id method (customer)
    //find the account by its ID... .get() is used to take the account out of the optional
    //store account_id into a variable customer_id
    public Customer getAccountOwner (Long account_id){
        Account account = accountRepository.findById(account_id).get();
        Long customer_id = account.getCustomerId();
        accountRepository.findById(customer_id);
        return customer;
    }

    //get deposits by account method
    public Iterable<Deposit> getDepositsByAccount(Long account_id){
        Account account = accountRepository.findById(account_id).get();

    }

    //get withdrawals by account method
    public Iterable<Withdrawal> getWithdrawalsByAccount (Long account_id){

    }

    //get bills by account method
    public Iterable<Bill> getBillsByAccount (Long account_id){

    }
}
