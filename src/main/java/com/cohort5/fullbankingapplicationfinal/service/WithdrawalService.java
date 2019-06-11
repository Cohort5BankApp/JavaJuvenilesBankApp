package com.cohort5.fullbankingapplicationfinal.service;

import com.cohort5.fullbankingapplicationfinal.model.Account;
import com.cohort5.fullbankingapplicationfinal.model.Withdrawal;
import com.cohort5.fullbankingapplicationfinal.repository.AccountRepository;
import com.cohort5.fullbankingapplicationfinal.repository.WithdrawalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class WithdrawalService {

    @Autowired
    WithdrawalRepository withdrawalRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountService accountService;

    public Optional<Withdrawal> getWithdrawalById(Long id) {
        return withdrawalRepository.findById(id);
    }

    public void createWithdrawal(Long account_id, Withdrawal withdrawal) {
        withdrawal.setAccount_id(account_id);
        Account account = accountRepository.findById(account_id).get();
        Double newBalance = account.getBalance() - withdrawal.getAmount();
        account.setBalance(newBalance);
        withdrawalRepository.save(withdrawal);
        //return withdrawalRepository.findById(withdrawal.getId());
    }

    public void updateWithdrawal(Withdrawal withdrawal) {
        Long account_id = withdrawal.getAccount_id();
        Account account = accountService.getAccountById(account_id).get();
        Withdrawal withdrawal1 = withdrawalRepository.findById(withdrawal.getId()).get();
        Double newBalance = (account.getBalance() + withdrawal1.getAmount()) - withdrawal.getAmount();
        account.setBalance(newBalance);
        withdrawalRepository.save(withdrawal);
    }

    public void deleteWithdrawal(Long withdrawal_id, Long account_id) {
        Account account = accountService.getAccountById(account_id).get();
        Withdrawal withdrawal = withdrawalRepository.findById(withdrawal_id).get();
        Double newBalance = account.getBalance() + withdrawal.getAmount();
        account.setBalance(newBalance);
        withdrawalRepository.deleteById(withdrawal_id);
    }

//    Possibly do not need method, saving for future
//    public ArrayList<Withdrawal> getAllWithdrawals() {
//        Iterable<Withdrawal> withdrawals = withdrawalRepository.findAll();
//        ArrayList<Withdrawal> all_withdrawals = new ArrayList<>();
//        for(Withdrawal withdrawal : withdrawals) {
//            all_withdrawals.add(withdrawal);
//        }
//        return all_withdrawals;
//    }

}
