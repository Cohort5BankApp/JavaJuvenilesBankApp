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
        deposit.setAccount_Id(account_id);
        Account account = accountRepository.getAccountById(account_id).get();
        account.setBalance(deposit.getBalance() + deposit.getBalance());
    }
    public Deposit updateDeposit(Long account_Id, Deposit deposit){
        deposit.setAccount_Id(account_Id);
        return depositRepository.save(deposit);
    }
    public void deleteDeposit(Long deposit_id){
        getDepositById(account_Id);
        depositRepository.delete(getDepositById(deposit_id));
    }
}
