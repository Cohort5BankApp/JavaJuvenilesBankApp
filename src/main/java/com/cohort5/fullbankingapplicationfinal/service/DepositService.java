package com.cohort5.fullbankingapplicationfinal.service;

import com.cohort5.fullbankingapplicationfinal.model.Account;
import com.cohort5.fullbankingapplicationfinal.model.Deposit;
import com.cohort5.fullbankingapplicationfinal.repository.AccountRepository;
import com.cohort5.fullbankingapplicationfinal.repository.DepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepositService {

    @Autowired
    public DepositRepository depositRepository;
    @Autowired
    public AccountRepository accountRepository;

    public Optional<Deposit> getDepositById(Long deposit_id){
        return depositRepository.findById(deposit_id);
    }
    public void createDeposit(Long account_id, Deposit deposit){
        depositRepository.save(deposit);
        deposit.setPayee_id(account_id);
        Account account = accountRepository.getAccountById(account_id).get();
        account.setBalance(deposit.getAmount() + account.getBalance());
    }
    public void updateDeposit(Long account_Id, Deposit deposit){
        depositRepository.save(deposit);
        Account account = accountRepository.findById(account_Id).get();
        Double newBalance = account.getBalance() - deposit.getAmount();
        account.setBalance(newBalance);
    }
    public void deleteDeposit(Long account_id,Long deposit_id){
        getDepositById(deposit_id);
         Deposit deposit = depositRepository.findById(deposit_id).get();
         Account account = accountRepository.findById(account_id).get();
         account.setBalance(account.getBalance() - deposit.getAmount());
        depositRepository.delete(getDepositById(deposit_id).get());
    }
}
