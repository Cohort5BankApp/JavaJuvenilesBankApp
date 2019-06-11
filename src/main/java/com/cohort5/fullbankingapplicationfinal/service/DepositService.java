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
    public AccountService accountService;

    public Optional<Deposit> getDepositById(Long deposit_id){
        return depositRepository.findById(deposit_id);
    }
    public void createDeposit(Long account_id, Deposit deposit){
        deposit.setAccount_id(account_id);
        Account account = accountService.getAccountById(account_id).get();
        account.setBalance(deposit.getAmount() + account.getBalance());
        depositRepository.save(deposit);
    }
    public void updateDeposit(Deposit deposit){
        Long accountId = deposit.getAccount_id();
        Account account = accountService.getAccountById(accountId).get();
        Deposit deposit1 = depositRepository.findById(deposit.getId()).get();
        Double newBalance = (account.getBalance() - deposit1.getAmount()) + deposit.getAmount();
        account.setBalance(newBalance);
        depositRepository.save(deposit);
    }
    public void deleteDeposit(Long account_id,Long deposit_id){
         Deposit deposit = depositRepository.findById(deposit_id).get();
         Account account = accountService.getAccountById(account_id).get();
         account.setBalance(account.getBalance() - deposit.getAmount());
        depositRepository.delete(getDepositById(deposit_id).get());
    }
}
