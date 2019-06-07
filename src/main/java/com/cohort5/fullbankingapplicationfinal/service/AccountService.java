package com.cohort5.fullbankingapplicationfinal.service;

import com.cohort5.fullbankingapplicationfinal.model.*;
import com.cohort5.fullbankingapplicationfinal.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;


@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private DepositRepository depositRepository;
    @Autowired
    private WithdrawalRepository withdrawalRepository;
    @Autowired
    private BillRepository billRepository;

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
        account.setCustomer_id(customer_id);
        return account;
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
    //find the customer that is associated with that account_id and then return that customer
    public Customer getAccountOwner (Long account_id){
        Account account = accountRepository.findById(account_id).get();
        Long customer_id = account.getCustomer_id();
        Customer customer = customerRepository.findById(customer_id).get();
        return customer;
    }

    //get deposits by account method
    //find the account by its ID and store it into the account variable
    //find all of the deposits and store it into a variable
    //take the deposits grabbed and the account_id grabbed and compare the two
    //if the two are
    public Iterable<Deposit> getDepositsByAccount(Long account_id){
        Account account = accountRepository.findById(account_id).get();
        Iterable<Deposit> deposit = depositRepository.findAll();
        ArrayList<Deposit> list = new ArrayList<>();
        for (Deposit deposits : deposit){
            if(deposit.getAccount_id() == account_id)
                list.add(deposits);
        }
        return list;
    }

    //get withdrawals by account method
    public Iterable<Withdrawal> getWithdrawalsByAccount (Long account_id) {
        Account account = accountRepository.findById(account_id).get();
        Iterable<Withdrawal> withdrawal = withdrawalRepository.findAll();
        ArrayList<Withdrawal> list = new ArrayList<>();
        for (Withdrawal withdrawals : withdrawal) {
            if (withdrawal.getaccount_Id() == account_id)
                list.add(withdrawals);
        }
        return list;
    }

    //get bills by account method
    public Iterable<Bill> getBillsByAccount (Long account_id){
        Account account = accountRepository.findById(account_id).get();
        Iterable<Bill> bill = billRepository.findAll();
        ArrayList<Bill> list = new ArrayList<>();
        for (Bill bills : bill){
            if(bill.getAccount_id() == account_id)
                list.add(bills);
        }
        return list;
    }
}
