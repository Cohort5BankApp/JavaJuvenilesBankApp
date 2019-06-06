package com.cohort5.fullbankingapplicationfinal.service;

import com.cohort5.fullbankingapplicationfinal.model.*;
import com.cohort5.fullbankingapplicationfinal.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

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
        accountRepository.save(customer_id);

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
    public Customer getAccountOwner (Long account_id){
        account.get(customer_id);
        accountRepository.findById(account_id);
    }

    //get deposits by account method
    public Iterable<Deposit> getDepositsByAccount(Long account_id){

    }

    //get withdrawals by account method
    public Iterable<Withdrawal> getWithdrawalsByAccount (Long account_id){

    }

    //get bills by account method
    public Iterable<Bill> getBillsByAccount (Long account_id){

    }




}
