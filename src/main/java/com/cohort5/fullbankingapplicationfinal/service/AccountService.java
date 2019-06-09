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
    public ArrayList<Account> getAllAccounts(){
        Iterable<Account> accounts = accountRepository.findAll();
        ArrayList<Account> accounts1 = new ArrayList<>();
        for (Account account : accounts){
            accounts1.add(account);
        }
        return accounts1;
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
     public ArrayList<Deposit> getDepositsByAccount(Long account_id){
        Iterable<Deposit> deposits = depositRepository.findAll();
        Iterable<Account> accounts = accountRepository.findAll();
        ArrayList<Deposit> list = new ArrayList<>();
        ArrayList<Account> accounts1 = new ArrayList<>();
        for(Account account : accounts){
            if (account.getAccount_id() == account_id){
                accounts1.add(account);
            }
        for (Deposit deposit : deposits){
            for(Account accounts1s : accounts1){
                if(deposit.getAccount_id() == accounts1s.getAccount_id()){
                list.add(deposit);
                }
            }
        }
    } return list;
    }

    //get withdrawals by account method
    public ArrayList<Withdrawal> getWithdrawalsByAccount(Long account_id){
        Iterable<Withdrawal> withdrawals = withdrawalRepository.findAll();
        Iterable<Account> accounts = accountRepository.findAll();
        ArrayList<Withdrawal> list = new ArrayList<>();
        ArrayList<Account> accounts1 = new ArrayList<>();
        for(Account account : accounts){
            if (account.getAccount_id() == account_id){
                accounts1.add(account);
            }
            for (Withdrawal withdrawal : withdrawals){
                for(Account accounts1s : accounts1){
                    if(withdrawal.getAccount_id() == accounts1s.getAccount_id()){
                        list.add(withdrawal);
                    }
                }
            }
        } return list;
    }

    //get bills by account method
    public ArrayList<Bill> getBillsByAccount(Long account_id){
        Iterable<Bill> bills = billRepository.findAll();
        Iterable<Account> accounts = accountRepository.findAll();
        ArrayList<Bill> list = new ArrayList<>();
        ArrayList<Account> accounts1 = new ArrayList<>();
        for(Account account : accounts){
            if (account.getAccount_id() == account_id){
                accounts1.add(account);
            }
            for (Bill bill : bills){
                for(Account accounts1s : accounts1){
                    if(bill.getAccount_id() == accounts1s.getAccount_id()){
                        list.add(bill);
                    }
                }
            }
        } return list;
    }
}
