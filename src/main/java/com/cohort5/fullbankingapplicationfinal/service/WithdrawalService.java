package com.cohort5.fullbankingapplicationfinal.service;

import com.cohort5.fullbankingapplicationfinal.model.Account;
import com.cohort5.fullbankingapplicationfinal.model.Withdrawal;
import com.cohort5.fullbankingapplicationfinal.repository.AccountRepository;
import com.cohort5.fullbankingapplicationfinal.repository.WithdrawalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class WithdrawalService {

    @Autowired
    private WithdrawalRepository withdrawalRepository;

    @Autowired
    private AccountRepository accountRepository;

    public Optional<Withdrawal> getWithdrawalById(Long withdrawal_id) {
        return withdrawalRepository.findById(withdrawal_id);
    }

    public void createWithdrawal(Long account_id, Withdrawal withdrawal) {
        withdrawalRepository.save(withdrawal);
        withdrawal.setId(account_id);
        Account account = accountRepository.findById(account_id).get();
        Double newBalance = account.getBalance() - withdrawal.getAmount();
        account.setBalance(newBalance);
    }

    public void updateWithdrawal(Long account_id, Withdrawal withdrawal) {
        withdrawalRepository.save(withdrawal);
        Account account = accountRepository.findById(account_id).get();
        Double newBalance = account.getBalance() - withdrawal.getAmount();
        account.setBalance(newBalance);
    }

    public void deleteWithdrawal(Long account_id, Long withdrawal_id) {
        withdrawalRepository.deleteById(withdrawal_id);
        Account account = accountRepository.findById(account_id).get();
        Withdrawal withdrawal = withdrawalRepository.findById(withdrawal_id).get();
        Double newBalance = account.getBalance() + withdrawal.getAmount();
        account.setBalance(newBalance);
    }

    public ArrayList<Withdrawal> getWithdrawals() {
        Iterable<Withdrawal> withdrawals = withdrawalRepository.findAll();
        ArrayList<Withdrawal> all_withdrawals = new ArrayList<>();
        for(Withdrawal withdrawal : withdrawals) {
            all_withdrawals.add(withdrawal);
        }
        return all_withdrawals;
    }

}
